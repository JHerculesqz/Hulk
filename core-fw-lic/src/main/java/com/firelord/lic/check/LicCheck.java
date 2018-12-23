package com.firelord.lic.check;

import com.firelord.lic.check.mo.LicCheckInMo;
import com.firelord.lic.check.provider.LicMgrHolder;
import com.firelord.lic.gen.provider.KeyStoreParamEx;
import de.schlichtherle.license.*;

import java.io.File;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;

/**
 * LicCheck
 */
public class LicCheck {
    //#region install

    /**
     * install
     *
     * @param oLicCheckInMo LicCheckInMo
     * @return LicenseContent
     */
    public static synchronized LicenseContent install(LicCheckInMo oLicCheckInMo) {
        LicenseContent oLicenseContent = null;

        try {
            DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            LicenseParam oLicenseParam = _initLicenseParam(oLicCheckInMo);
            LicenseManager oLicenseManager = LicMgrHolder.getInstance(oLicenseParam);
            oLicenseManager.uninstall();
            oLicenseContent = oLicenseManager.install(new File(oLicCheckInMo.getLicensePath()));
            System.out.println(MessageFormat.format("证书安装成功，证书有效期：{0} - {1}",
                    oDateFormat.format(oLicenseContent.getNotBefore()),
                    oDateFormat.format(oLicenseContent.getNotAfter())));
        } catch (Exception e) {
            System.out.println("证书安装失败！");
            e.printStackTrace();
        }

        return oLicenseContent;
    }

    private static LicenseParam _initLicenseParam(LicCheckInMo oLicCheckInMo) {
        Preferences oPreferences = Preferences.userNodeForPackage(LicCheck.class);
        CipherParam oCipherParam = new DefaultCipherParam(oLicCheckInMo.getStorePass());
        KeyStoreParam oKeyStoreParamPublic = new KeyStoreParamEx(LicCheck.class,
                oLicCheckInMo.getPublicKeysStorePath(),
                oLicCheckInMo.getPublicAlias(),
                oLicCheckInMo.getStorePass(),
                null);
        return new DefaultLicenseParam(oLicCheckInMo.getSubject(),
                oPreferences,
                oKeyStoreParamPublic,
                oCipherParam);
    }

    //#endregion

    //#region check

    /**
     * check
     *
     * @return
     */
    public static boolean check() {
        LicenseManager oLicenseManager = LicMgrHolder.getInstance(null);

        try {
            DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            LicenseContent licenseContent = oLicenseManager.verify();
            System.out.println(licenseContent.getSubject());
            System.out.println(MessageFormat.format("证书校验通过，证书有效期：{0} - {1}",
                    oDateFormat.format(licenseContent.getNotBefore()),
                    oDateFormat.format(licenseContent.getNotAfter())));
            return true;
        } catch (Exception e) {
            System.out.println("证书校验失败！");
            e.printStackTrace();
            return false;
        }
    }

    //#endregion
}
