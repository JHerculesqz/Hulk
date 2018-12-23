package com.firelord.lic.gen;

import com.firelord.lic.gen.mo.LicGenInMo;
import com.firelord.lic.gen.provider.KeyStoreParamEx;
import com.firelord.lic.gen.provider.LicMgrEx;
import de.schlichtherle.license.*;

import javax.security.auth.x500.X500Principal;
import java.io.File;
import java.util.prefs.Preferences;

/**
 * LicGen
 */
public class LicGen {
    //#region Const

    private final static X500Principal DEFAULT_HOLDER_AND_ISSUER = new X500Principal(
            "CN=localhost, OU=localhost, O=localhost, L=SH, ST=SH, C=CN");

    //#endregion

    //#region gen

    /**
     * gen
     *
     * @param oInVo LicGenInMo
     * @return
     */
    public static boolean gen(LicGenInMo oInVo) {
        try {
            LicenseManager licenseManager = new LicMgrEx(initLicenseParam(oInVo));
            LicenseContent licenseContent = initLicenseContent(oInVo);

            licenseManager.store(licenseContent, new File(oInVo.getLicensePath()));

            return true;
        } catch (Exception e) {
            System.out.println("[Hulk]证书生成失败");
            e.printStackTrace();
            return false;
        }
    }

    private static LicenseParam initLicenseParam(LicGenInMo oInVo) {
        Preferences preferences = Preferences.userNodeForPackage(LicGen.class);

        //设置对证书内容加密的秘钥
        CipherParam cipherParam = new DefaultCipherParam(oInVo.getStorePass());

        KeyStoreParam privateStoreParam = new KeyStoreParamEx(LicGen.class
                , oInVo.getPrivateKeysStorePath()
                , oInVo.getPrivateAlias()
                , oInVo.getStorePass()
                , oInVo.getKeyPass());

        LicenseParam licenseParam = new DefaultLicenseParam(oInVo.getSubject()
                , preferences
                , privateStoreParam
                , cipherParam);

        return licenseParam;
    }

    private static LicenseContent initLicenseContent(LicGenInMo oInVo) {
        LicenseContent licenseContent = new LicenseContent();
        licenseContent.setHolder(DEFAULT_HOLDER_AND_ISSUER);
        licenseContent.setIssuer(DEFAULT_HOLDER_AND_ISSUER);

        licenseContent.setSubject(oInVo.getSubject());
        licenseContent.setIssued(oInVo.getIssuedTime());
        licenseContent.setNotBefore(oInVo.getIssuedTime());
        licenseContent.setNotAfter(oInVo.getExpiryTime());
        licenseContent.setConsumerType(oInVo.getConsumerType());
        licenseContent.setConsumerAmount(oInVo.getConsumerAmount());
        licenseContent.setInfo(oInVo.getDescription());

        //扩展校验服务器硬件信息
        licenseContent.setExtra(oInVo.getOsOutMo());

        return licenseContent;
    }

    //#endregion
}
