package com.firelord.component.os.os.prodvider;

import org.apache.commons.collections4.CollectionUtils;

import java.net.InetAddress;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * WindowsOS
 */
public class WindowsOS extends AbstractOS {
    //#region getIPLst

    @Override
    protected List<String> getIPLst() throws Exception {
        List<String> lstRes = null;

        //getLocalAllInetAddress
        List<InetAddress> lstInetAddress = getLocalAllInetAddress();

        //Provider
        if (!CollectionUtils.isEmpty(lstInetAddress)) {
            lstRes = lstInetAddress.stream().map(InetAddress::getHostAddress)
                    .distinct()
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        }

        return lstRes;
    }

    //#endregion

    //#region getMacLst

    @Override
    protected List<String> getMacLst() throws Exception {
        List<String> lstRes = null;

        //getLocalAllInetAddress
        List<InetAddress> lstInetAddress = getLocalAllInetAddress();

        //Provider
        if (!CollectionUtils.isEmpty(lstInetAddress)) {
            lstRes = lstInetAddress.stream().map(this::getMacByInetAddress)
                    .distinct()
                    .collect(Collectors.toList());
        }

        return lstRes;
    }

    //#endregion

    //#region getCPU

    @Override
    protected String getCPU() throws Exception {
        String strRes = "";

        //WMI
        Process oProcess = Runtime.getRuntime().exec("wmic cpu get processorid");
        oProcess.getOutputStream().close();

        //toString
        Scanner oScanner = new Scanner(oProcess.getInputStream());
        if (oScanner.hasNext()) {
            oScanner.next();
        }
        if (oScanner.hasNext()) {
            strRes = oScanner.next().trim();
        }
        oScanner.close();

        return strRes;
    }

    //#endregion

    //#region getMainBoard

    @Override
    protected String getMainBoard() throws Exception {
        String strRes = "";

        //WMI
        Process oProcess = Runtime.getRuntime().exec("wmic baseboard get serialnumber");
        oProcess.getOutputStream().close();

        //toString
        Scanner oScanner = new Scanner(oProcess.getInputStream());
        if (oScanner.hasNext()) {
            oScanner.next();
        }
        if (oScanner.hasNext()) {
            strRes = oScanner.next().trim();
        }
        oScanner.close();

        return strRes;
    }

    //#endregion
}
