package com.firelord.lic.check.provider;

import com.firelord.lic.gen.provider.LicMgrEx;
import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * LicMgrHolder
 */
public class LicMgrHolder {
    //#region Fields

    private static volatile LicenseManager m_oInstance;

    //#endregion

    //#region getInstance

    public static LicenseManager getInstance(LicenseParam oLicenseParam) {
        if (m_oInstance == null) {
            synchronized (LicMgrHolder.class) {
                if (null == m_oInstance) {
                    m_oInstance = new LicMgrEx(oLicenseParam);
                }
            }
        }

        return m_oInstance;
    }

    //#endregion
}
