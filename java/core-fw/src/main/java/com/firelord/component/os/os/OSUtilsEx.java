package com.firelord.component.os.os;

import com.firelord.component.os.os.mo.OSOutMo;
import com.firelord.component.os.os.prodvider.AbstractOS;
import com.firelord.component.os.os.prodvider.LinuxOS;
import com.firelord.component.os.os.prodvider.WindowsOS;

/**
 * OSUtilsEx
 */
public class OSUtilsEx {
    //#region getInfo

    /**
     * getInfo
     *
     * @return OSOutMo
     */
    public static OSOutMo getInfo() {
        //get instance
        AbstractOS abstractOS;
        String strOS = System.getProperty("os.name").toLowerCase();
        if (strOS.startsWith("windows")) {
            abstractOS = new WindowsOS();
        } else if (strOS.startsWith("linux")) {
            abstractOS = new LinuxOS();
        } else {
            abstractOS = new LinuxOS();
        }

        //getInfo
        OSOutMo oOutMo = abstractOS.getInfo();
        return oOutMo;
    }

    //#endregion
}
