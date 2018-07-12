package com.firelord.component.io.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.firelord.component.io.file.vo.FilePathVo;
import com.firelord.component.process.ProcessUtilsEx;
import org.apache.commons.io.IOUtils;

public class FileUtilsEx {
	// #region Const

	@SuppressWarnings("unused")
	private static final boolean IS_DEBUG = true;

	// #endregion

	// #region isExists

	public static boolean isExists(String strFilePath) {
		File oFile = new File(strFilePath);
		boolean bRes = oFile.exists();
		return bRes;
	}

	// #endregion

	// #region delFile

	public static boolean delFile(String strFilePath) {
		if (isExists(strFilePath)) {
			File oFile = new File(strFilePath);
			return FileUtils.deleteQuietly(oFile);
		} else {
			return false;
		}
	}

	// #endregion

	// #region getFileLst

	public static Collection<File> getFileLst(String strDirPath) {
		File oDir = new File(strDirPath);
		Collection<File> lstFile = FileUtils.listFiles(oDir, null, true);
		return lstFile;
	}

	// #endregion

	// #region writeAllText

	public static void writeAllText(String strContent, String strFilePath) {
		// 1.delFile
		delFile(strFilePath);

		// 2.writeAllText
		File oFile = new File(strFilePath);
		try {
			FileUtils.writeStringToFile(oFile, strContent, Charset.forName("utf-8"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #endregion

	// #region appendAllText

	public static void appendAllText(String strContent, String strFilePath) {
		File oFile = new File(strFilePath);
		try {
			FileUtils.writeStringToFile(oFile, strContent, Charset.forName("utf-8"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #endregion

	// #region readAllText

	public static String readAllText(String strFilePath) {
		String strRes = "";

		File oFile = new File(strFilePath);
		try {
			strRes = FileUtils.readFileToString(oFile, Charset.forName("utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strRes;
	}

	// #endregion

	// #region parseFilePath

	public static FilePathVo parseFilePath(String strFilePath) {
		FilePathVo oFilePathVo = new FilePathVo();

		// 1.generate oFile by strFilePath
		File oFile = new File(strFilePath);

		// 1.1.setFileName
		oFilePathVo.setFileName(oFile.getName());

		// 1.2.setDirPath4File
		String strDirPath4Parent = oFile.getParent();
		oFilePathVo.setDirPath4File(strDirPath4Parent);

		return oFilePathVo;
	}

	// #endregion

	// #region getBytes

	public static byte[] getBytes(String strFilePath) {
		byte[] arrRes = null;
		try {
			arrRes = Files.readAllBytes(new File(strFilePath).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrRes;
	}

	// #endregion

	// #region xcopy

	public static void xcopyDir(String strDirPathSrc, String strDirPathDst) {
		// 1.generate strDirPathSrc
		if (!strDirPathSrc.endsWith("\\")) {
			strDirPathSrc = strDirPathSrc + "\\*.*";
		} else {
			strDirPathSrc = strDirPathSrc + "*.*";
		}

		// 2.generate strDirPathDst
		if (!strDirPathDst.endsWith("\\")) {
			strDirPathDst = strDirPathDst + "\\";
		}

		// 3.run
		// bak:ProcessUtilsEx.runByShellSyn("ping", "localhost -n 20 > nul");
		// samples:xcopy D:\src\*.* D:\dst\ /s /e /y
		String strCmd = "xcopy";
		String strCmdArgs = strDirPathSrc + " " + strDirPathDst + " /s /e /y";
		ProcessUtilsEx.runByShellSyn(strCmd, strCmdArgs);
	}

	// #endregion

	// #region writeAllByte

	public static void writeAllByte(byte[] arrBytes, String strFilePath) {
		try {
			FileUtils.writeByteArrayToFile(new File(strFilePath), arrBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #endregion

	// #region readAllByte

	public static byte[] readAllByte(String strFilePath) {
		byte[] arrBytes = null;
		try {
			arrBytes = FileUtils.readFileToByteArray(new File(strFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrBytes;
	}

	// #endregion

	// #region exclude

	public static List<File> exclude(List<File> lstFiles, List<String> lstExcludeKeyInFileName) {
		List<File> lstRes = new ArrayList<>();

		for (File oFile : lstFiles) {
			String strFileName = oFile.getName();
			boolean bIsExclude = false;
			for (String strExcludeKeyInFileName : lstExcludeKeyInFileName) {
				if (strFileName.contains(strExcludeKeyInFileName)) {
					bIsExclude = true;
					break;
				}
			}
			if (!bIsExclude) {
				lstRes.add(oFile);
			}
		}

		return lstRes;
	}

	// #endregion

	// #region xcopyFiles

	public static void xcopyFile(String strFilePath, String strDirPathDst) {
		// 1.generate strDirPathDst
		if (!strDirPathDst.endsWith("\\")) {
			strDirPathDst = strDirPathDst + "\\";
		}

		// 2.run
		// bak:ProcessUtilsEx.runByShellSyn("ping", "localhost -n 20 > nul");
		// samples:xcopy D:\src\1.txt D:\dst\ /k /y
		String strCmd = "xcopy";
		String strCmdArgs = strFilePath + " " + strDirPathDst + " /k /y";
		ProcessUtilsEx.runByShellSyn(strCmd, strCmdArgs);
	}

	// #endregion

	// #region copy

	public static void copy(String strFilePathSrc, String strFilePathDst) throws IOException {
		File oFileSrc = new File(strFilePathSrc);
		File oFileDst = new File(strFilePathDst);
		FileUtils.copyFile(oFileSrc, oFileDst);
	}

	public static void writeFileAppendByInputStream(String strFilePath,
													InputStream oInputStream,
													boolean bAppend) throws IOException {
		File oFileDestination = new File(strFilePath);
		try {
			FileOutputStream oFileOutputStream = FileUtils.openOutputStream(oFileDestination,
					bAppend);
			try {
				IOUtils.copy(oInputStream, oFileOutputStream);
				oFileOutputStream.close();
			} finally {
				IOUtils.closeQuietly(oInputStream);
			}
		} finally {
			IOUtils.closeQuietly(oInputStream);
		}
	}
	// #endregion
}
