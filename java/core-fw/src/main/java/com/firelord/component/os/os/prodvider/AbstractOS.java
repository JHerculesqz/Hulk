package com.firelord.component.os.os.prodvider;

import com.firelord.component.os.os.mo.OSOutMo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * AbstractOS
 */
public abstract class AbstractOS {
    //#region getInfo

    /**
     * getInfo
     *
     * @return OSOutMo
     */
    public OSOutMo getInfo() {
        OSOutMo oOutMo = new OSOutMo();

        try {
            oOutMo.setIpLst(this.getIPLst());
            oOutMo.setMacLst(this.getMacLst());
            oOutMo.setCpu(this.getCPU());
            oOutMo.setMainBoard(this.getMainBoard());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return oOutMo;
    }

    protected abstract List<String> getIPLst() throws Exception;

    protected abstract List<String> getMacLst() throws Exception;

    protected abstract String getCPU() throws Exception;

    protected abstract String getMainBoard() throws Exception;

    protected List<InetAddress> getLocalAllInetAddress() throws Exception {
        List<InetAddress> lstInetAddress = new ArrayList<>(4);

        // 遍历所有的网络接口
        for (Enumeration enumNetworkInterfaceLst = NetworkInterface.getNetworkInterfaces(); enumNetworkInterfaceLst.hasMoreElements(); ) {
            NetworkInterface oNetworkInterface = (NetworkInterface) enumNetworkInterfaceLst.nextElement();
            // 在所有的接口下再遍历IP
            for (Enumeration enumInetAddressLst = oNetworkInterface.getInetAddresses(); enumInetAddressLst.hasMoreElements(); ) {
                InetAddress oInetAddress = (InetAddress) enumInetAddressLst.nextElement();

                //排除LoopbackAddress、SiteLocalAddress、LinkLocalAddress、MulticastAddress类型的IP地址
                if (!oInetAddress.isLoopbackAddress() /*&& !inetAddr.isSiteLocalAddress()*/
                        && !oInetAddress.isLinkLocalAddress()
                        && !oInetAddress.isMulticastAddress()) {
                    lstInetAddress.add(oInetAddress);
                }
            }
        }

        return lstInetAddress;
    }

    protected String getMacByInetAddress(InetAddress oInetAddress) {
        StringBuffer strRes = new StringBuffer();

        try {
            byte[] arrMac = NetworkInterface.getByInetAddress(oInetAddress).getHardwareAddress();
            for (int i = 0; i < arrMac.length; i++) {
                if (i != 0) {
                    strRes.append("-");
                }
                String strTmp = Integer.toHexString(arrMac[i] & 0xff);
                if (strTmp.length() == 1) {
                    strRes.append("0" + strTmp);
                } else {
                    strRes.append(strTmp);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return strRes.toString().toUpperCase();
    }

    //#endregion
}
