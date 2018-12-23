package com.firelord.lic.gen.provider;

import com.firelord.component.os.os.OSUtilsEx;
import com.firelord.component.os.os.mo.OSOutMo;
import de.schlichtherle.license.*;
import de.schlichtherle.xml.GenericCertificate;
import org.apache.commons.lang.StringUtils;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * LicMgrEx
 */
public class LicMgrEx extends LicenseManager {
    //#region Const

    private static final String XML_CHARSET = "UTF-8";
    private static final int DEFAULT_BUFSIZE = 8 * 1024;

    //#endregion

    //#region Construction

    public LicMgrEx(LicenseParam oLicenseParam) {
        super(oLicenseParam);
    }

    //#endregion

    //#region create

    @Override
    protected synchronized byte[] create(LicenseContent oLicenseContent,
                                         LicenseNotary oLicenseNotary) throws Exception {
        this.initialize(oLicenseContent);
        this._validateCreate(oLicenseContent);
        final GenericCertificate oGenericCertificate = oLicenseNotary.sign(oLicenseContent);
        return this.getPrivacyGuard().cert2key(oGenericCertificate);
    }

    protected synchronized void _validateCreate(final LicenseContent oLicenseContent)
            throws LicenseContentException {
        //final LicenseParam oLicenseParam = getLicenseParam();
        final Date oNow = new Date();
        final Date oNotBefore = oLicenseContent.getNotBefore();
        final Date oNotAfter = oLicenseContent.getNotAfter();
        if (null != oNotAfter && oNow.after(oNotAfter)) {
            throw new LicenseContentException("证书失效时间不能早于当前时间");
        }
        if (null != oNotBefore && null != oNotAfter && oNotAfter.before(oNotBefore)) {
            throw new LicenseContentException("证书生效时间不能晚于证书失效时间");
        }
        final String strConsumerType = oLicenseContent.getConsumerType();
        if (null == strConsumerType) {
            throw new LicenseContentException("用户类型不能为空");
        }
    }

    //#endregion

    //#region install

    @Override
    protected synchronized LicenseContent install(final byte[] arrKey,
                                                  final LicenseNotary oLicenseNotary)
            throws Exception {
        final GenericCertificate oGenericCertificate = this.getPrivacyGuard().key2cert(arrKey);
        oLicenseNotary.verify(oGenericCertificate);
        final LicenseContent oLicenseContent = (LicenseContent) this.load(oGenericCertificate.
                getEncoded());
        this.validate(oLicenseContent);
        this.setLicenseKey(arrKey);
        this.setCertificate(oGenericCertificate);
        return oLicenseContent;
    }

    private Object load(String strEncoded) {
        BufferedInputStream oBufferedInputStream = null;
        XMLDecoder oXMLDecoder = null;

        try {
            oBufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(strEncoded.
                    getBytes(XML_CHARSET)));
            oXMLDecoder = new XMLDecoder(new BufferedInputStream(oBufferedInputStream,
                    DEFAULT_BUFSIZE), null, null);
            return oXMLDecoder.readObject();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oXMLDecoder != null) {
                    oXMLDecoder.close();
                }
                if (oBufferedInputStream != null) {
                    oBufferedInputStream.close();
                }
            } catch (Exception e) {
                System.out.println("[Hulk]XMLDecoder解析XML失败");
                e.printStackTrace();
            }
        }

        return null;
    }

    //#endregion

    //#region check

    @Override
    protected synchronized LicenseContent verify(final LicenseNotary oLicenseNotary)
            throws Exception {
        GenericCertificate oGenericCertificate = getCertificate();

        final byte[] arrKey = getLicenseKey();
        if (null == arrKey) {
            throw new NoLicenseInstalledException(getLicenseParam().getSubject());
        }
        oGenericCertificate = this.getPrivacyGuard().key2cert(arrKey);
        oLicenseNotary.verify(oGenericCertificate);
        final LicenseContent oLicenseContent = (LicenseContent) this.load(oGenericCertificate.
                getEncoded());
        this.validate(oLicenseContent);
        this.setCertificate(oGenericCertificate);

        return oLicenseContent;
    }

    //#endregion

    //#region validate

    @Override
    protected synchronized void validate(final LicenseContent oLicenseContent)
            throws LicenseContentException {
        super.validate(oLicenseContent);

        OSOutMo oExpect = (OSOutMo) oLicenseContent.getExtra();
        OSOutMo oReal = OSUtilsEx.getInfo();

        if (oExpect != null && oReal != null) {
            if (!this._checkIP(oExpect.getIpLst(), oReal.getIpLst())) {
                throw new LicenseContentException("当前服务器的IP没在授权范围内");
            }
            if (!this._checkIP(oExpect.getMacLst(), oReal.getMacLst())) {
                throw new LicenseContentException("当前服务器的Mac地址没在授权范围内");
            }
            if (!this._checkSerial(oExpect.getMainBoard(), oReal.getMainBoard())) {
                throw new LicenseContentException("当前服务器的主板序列号没在授权范围内");
            }
            if (!this._checkSerial(oExpect.getCpu(), oReal.getCpu())) {
                throw new LicenseContentException("当前服务器的CPU序列号没在授权范围内");
            }
        } else {
            throw new LicenseContentException("不能获取服务器硬件信息");
        }
    }

    private boolean _checkIP(List<String> lstExpect, List<String> lstReal) {
        if (lstExpect != null && lstExpect.size() > 0) {
            if (lstReal != null && lstReal.size() > 0) {
                for (String strExpect : lstExpect) {
                    if (lstReal.contains(strExpect.trim())) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean _checkSerial(String strExpect, String strReal) {
        if (StringUtils.isNotBlank(strExpect)) {
            if (StringUtils.isNotBlank(strReal)) {
                if (strExpect.equals(strReal)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    //#endregion
}
