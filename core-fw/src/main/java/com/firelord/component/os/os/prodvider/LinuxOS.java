package com.firelord.component.os.os.prodvider;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LinuxOS
 */
public class LinuxOS extends AbstractOS {
    //#region getIPLst

    @Override
    protected List<String> getIPLst() throws Exception {
        List<String> lstRes = null;

        //getLocalAllInetAddress
        List<InetAddress> lstInetAddress = getLocalAllInetAddress();

        //Provider
        if (CollectionUtils.isEmpty(lstInetAddress)) {
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
        if (CollectionUtils.isEmpty(lstInetAddress)) {
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

        //get CPU
        String[] shell = {"/bin/bash", "-c", "dmidecode -t processor | grep 'ID' | awk -F ':' '{print $2}' | head -n 1"};
        Process process = Runtime.getRuntime().exec(shell);
        process.getOutputStream().close();

        //Provider
        BufferedReader oBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String strLine = oBufferedReader.readLine().trim();
        if (StringUtils.isNotBlank(strLine)) {
            strRes = strLine;
        }
        oBufferedReader.close();

        return strRes;
    }

    //#endregion

    //#region getMainBoard

    @Override
    protected String getMainBoard() throws Exception {
        String strRes = "";

        //get MainBoard
        String[] shell = {"/bin/bash", "-c", "dmidecode | grep 'Serial Number' | awk -F ':' '{print $2}' | head -n 1"};
        Process process = Runtime.getRuntime().exec(shell);
        process.getOutputStream().close();

        //Provider
        BufferedReader oBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String strLine = oBufferedReader.readLine().trim();
        if (StringUtils.isNotBlank(strLine)) {
            strRes = strLine;
        }
        oBufferedReader.close();

        return strRes;
    }

    //#endregion
}
