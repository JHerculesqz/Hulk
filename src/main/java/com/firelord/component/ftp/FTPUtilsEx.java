package com.firelord.component.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.List;

import com.firelord.component.ftp.vo.FTPAddressVo;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.firelord.component.io.dir.DirUtilsEx;
import com.firelord.component.io.file.FileUtilsEx;
import com.firelord.component.io.file.vo.FilePathVo;

public class FTPUtilsEx {
	// #region Const

	@SuppressWarnings("unused")
	private static final boolean IS_DEBUG = true;

	private static final String FTP_URL_SPLIT = ":";

	private static final String FTP_URL_HEADER = "ftp://";

	// #endregion

	// #region downloadFile

	/**
	 * 
	 * @param strHostname
	 *            127.0.0.1
	 * @param iPort
	 *            21
	 * @param strUserName
	 *            xxxx
	 * @param strPassword
	 *            xxxx
	 * @param strFilePathRelativeOnFTP
	 *            /a/b/c/1.zip
	 * @param strDirPath4Download
	 *            C:\\download\zombie1
	 * @return
	 */
	public static boolean downloadFile(String strHostname, int iPort, String strUserName, String strPassword,
			String strFilePathRelativeOnFTP, String strDirPath4Download) {
		boolean bRes = false;

		// 1.0.FileUtilsEx.parseFilePath, get oFilePathVoOnFTP
		FilePathVo oFilePathVoOnFTP = FileUtilsEx.parseFilePath(strFilePathRelativeOnFTP);

		// 1.缺啥补啥
		DirUtilsEx.mkDir(strDirPath4Download);
		// 2.多啥删啥
		String strFilePath4Download = strDirPath4Download + File.separator + oFilePathVoOnFTP.getFileName();
		FileUtilsEx.delFile(strFilePath4Download);

		// 3.FTP connect/login/changeWorkingDirectory
		FTPClient oFTPClient = null;
		try {
			oFTPClient = connect(strHostname, iPort, strUserName, strPassword);
			gotoDir(oFTPClient, oFilePathVoOnFTP.getDirPath4File());
			// 4.FTP getFileLst
			FTPFile[] arrFTPFile = getFileLst(oFTPClient);
			for (FTPFile oFTPFile : arrFTPFile) {
				// 5.download specific file
				if (oFTPFile.getName().equals(oFilePathVoOnFTP.getFileName())) {
					bRes = downloadFile(oFTPClient, oFTPFile, strFilePath4Download);
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnnect(oFTPClient);
		}

		return bRes;
	}

	// #endregion

	// #region uploadFile

	public static boolean uploadFile(String strHostname, int iPort, String strUserName, String strPassword,
			String strDirPathFileOnFTP, List<File> lstFile4Upload) {
		boolean bRes = false;

		// 1.FTP connect/login/changeWorkingDirectory
		FTPClient oFTPClient = null;
		try {
			oFTPClient = connect(strHostname, iPort, strUserName, strPassword);
			gotoDir(oFTPClient, strDirPathFileOnFTP);
			setUploadMode(oFTPClient);

			for (File oFile4Upload : lstFile4Upload) {
				// 2.FileUtilsEx.parseFilePath, get oFilePathVoOnFTP
				FilePathVo oFilePathVo4Upload = FileUtilsEx.parseFilePath(oFile4Upload.getPath());

				// 3.storeFile
				FileInputStream oFileInputStream = new FileInputStream(oFile4Upload);
				oFTPClient.storeFile(oFilePathVo4Upload.getFileName(), oFileInputStream);
				oFileInputStream.close();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnnect(oFTPClient);
		}

		return bRes;
	}

	// #endregion

	// #region parse4FtpUrl

	public static FTPAddressVo parse4FtpUrl(String strFTPUrl) {
		strFTPUrl = strFTPUrl.replaceAll(FTP_URL_HEADER, "");
		int indexOfFtpUrlSplit = strFTPUrl.lastIndexOf(FTP_URL_SPLIT);
		FTPAddressVo oFTPAdressVo = new FTPAddressVo();
		oFTPAdressVo.setHostName(strFTPUrl.substring(0, indexOfFtpUrlSplit));
		oFTPAdressVo.setPort(Integer.parseInt(strFTPUrl.substring(indexOfFtpUrlSplit + 1)));
		return oFTPAdressVo;
	}

	// #endregion

	// #region Private

	// #region connect

	private static FTPClient connect(String strHostname, int iPort, String strUserName, String strPassword)
			throws SocketException, IOException {
		FTPClient oFTPClient = new FTPClient();
		oFTPClient.setControlEncoding("UTF-8");
		oFTPClient.connect(strHostname, iPort);
		oFTPClient.login(strUserName, strPassword);
		int iReplyCode = oFTPClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(iReplyCode)) {
			return null;
		} else {
			return oFTPClient;
		}
	}

	// #endregion

	// #region gotoDir

	private static void gotoDir(FTPClient oFTPClient, String strDirPathOnFTP) throws IOException {
		oFTPClient.makeDirectory(strDirPathOnFTP);
		oFTPClient.changeWorkingDirectory(strDirPathOnFTP);
	}

	// #endregion

	// #region getFileLst

	private static FTPFile[] getFileLst(FTPClient oFTPClient) throws IOException {
		return oFTPClient.listFiles();
	}

	// #endregion

	// #region downloadFile

	private static boolean downloadFile(FTPClient oFTPClient, FTPFile oFTPFile, String strFilePath4Download)
			throws FileNotFoundException, IOException {
		File oNewFile = new File(strFilePath4Download);
		OutputStream oOutputStream = new FileOutputStream(oNewFile);
		oFTPClient.retrieveFile(oFTPFile.getName(), oOutputStream);
		oOutputStream.close();
		return true;
	}

	// #endregion

	// #region disConnect

	private static void disConnnect(FTPClient oFTPClient) {
		if (oFTPClient.isConnected()) {
			try {
				// 2.3 disConnect FTP
				oFTPClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// #endregion

	// #region setUploadMode

	private static void setUploadMode(FTPClient oFTPClient) throws IOException {
		oFTPClient.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
		oFTPClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
	}

	// #endregion

	// #endregion
}
