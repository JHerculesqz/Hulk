package com.firelord.component.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPUtilsEx {
	// #region initServer

	public static void initServer(int iPort, int iRecieveMsgLength, IUDPServerCallback oIUDPServerCallback) {
		try (DatagramSocket oDatagramSocket = new DatagramSocket(iPort)) {
			while (true) {
				try {
					// 1.recieve
					DatagramPacket oRequest = new DatagramPacket(new byte[iRecieveMsgLength], iRecieveMsgLength);
					oDatagramSocket.receive(oRequest);

					// 2.callback
					String strRecievMsg = new String(oRequest.getData(), 0, oRequest.getLength());
					String strRes = oIUDPServerCallback.run(strRecievMsg);
					byte[] arrRes = strRes.getBytes();

					// 3.response
					DatagramPacket oResponse = new DatagramPacket(arrRes, arrRes.length, oRequest.getAddress(),
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

	// #endregion

	// #region client

	public static String client(String strIp, int iPort, int iSendMsgLength, String strSendMsg) {
		String strRes = "";

		// 传入0表示让操作系统分配一个端口号
		try (DatagramSocket oDatagramSocket = new DatagramSocket(0)) {
			oDatagramSocket.setSoTimeout(10000);
			InetAddress oIP = InetAddress.getByName(strIp);

			byte[] arrByte = strSendMsg.getBytes();
			DatagramPacket request = new DatagramPacket(arrByte, arrByte.length, oIP, iPort);
			oDatagramSocket.send(request);
			// 为接受的数据包创建空间
			DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
			oDatagramSocket.receive(response);
			strRes = new String(response.getData(), 0, response.getLength(), "ASCII");
		} catch (IOException e) {
			e.printStackTrace();
			strRes = e.getMessage();
		}

		return strRes;
	}

	// #endregion
}
