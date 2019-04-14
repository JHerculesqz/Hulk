package com.firelord.spring.component.rpc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPUtilsEx
 */
public class UDPUtilsEx {
    //#region initServer

    /**
     * init udp server
     *
     * @param iPort             port
     * @param iReceiveMsgLength receive msg length
     * @param oCallback         callback after receive msg
     */
    public static void initServer(int iPort, int iReceiveMsgLength, IUDPServerCallback oCallback) {
        try (DatagramSocket oDatagramSocket = new DatagramSocket(iPort)) {
            while (true) {
                try {
                    //receive msg
                    DatagramPacket oRequest = new DatagramPacket(new byte[iReceiveMsgLength],
                            iReceiveMsgLength);
                    oDatagramSocket.receive(oRequest);

                    //callback
                    String strReceiveMsg = new String(oRequest.getData(), 0,
                            oRequest.getLength());
                    String strRes = oCallback.run(strReceiveMsg);
                    byte[] arrRes = strRes.getBytes();

                    //response
                    DatagramPacket oResponse = new DatagramPacket(arrRes, arrRes.length,
                            oRequest.getAddress(),
                            oRequest.getPort());
                    oDatagramSocket.send(oResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //#endregion

    //#region client

    /**
     * udp client
     *
     * @param strIp      udp server ip
     * @param iPort      udp server port
     * @param strSendMsg send msg
     * @return udp server response msg
     */
    public static String client(String strIp, int iPort, String strSendMsg) {
        String strRes;

        try (DatagramSocket oDatagramSocket = new DatagramSocket(0)) {
            //send
            oDatagramSocket.setSoTimeout(10000);
            InetAddress oIP = InetAddress.getByName(strIp);
            byte[] arrByte = strSendMsg.getBytes();
            DatagramPacket request = new DatagramPacket(arrByte, arrByte.length, oIP, iPort);
            oDatagramSocket.send(request);

            //receive
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            oDatagramSocket.receive(response);
            strRes = new String(response.getData(), 0, response.getLength(),
                    "ASCII");
        } catch (IOException e) {
            e.printStackTrace();
            strRes = e.getMessage();
        }

        return strRes;
    }

    //#endregion
}
