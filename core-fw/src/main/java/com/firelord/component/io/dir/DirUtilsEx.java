package com.firelord.component.io.dir;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import jodd.io.findfile.FindFile;

public class DirUtilsEx {
	//#region isExists

	public static boolean isExists(String strDirPath) {
		File oDir = new File(strDirPath);
		boolean bRes = oDir.exists();
		return bRes;
	}

	//#endregion

	//#region mkdir

	public static void mkDir(String strDirPath) {
		try {
			FileUtils.forceMkdir(new File(strDirPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//#endregion

	//#region delDir

	public static boolean delDir(String strDirPath) {
		if (isExists(strDirPath)) {
			File oFile = new File(strDirPath);
			return FileUtils.deleteQuietly(oFile);
		} else {
			return false;
		}
	}

	//#endregion

	//#region getFileLstInDir

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<File> getFileLstInDir(String strDirPath, String strRegex) {
		List<File> lstRes = new ArrayList<>();

		FindFile oFindFile = new FindFile().searchPath(strDirPath).setRecursive(true).setIncludeDirs(true);

		Iterator<File> oIter = oFindFile.iterator();
		while (oIter.hasNext()) {
			File oFile = oIter.next();
			if (oFile.isFile()) {
				String strFilePath = oFile.getPath();
				if (strFilePath.matches(strRegex)) {
					lstRes.add(oFile);
				}
			}
		}

		return lstRes;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<File> getFileLstInDirEx(String strDirPath, String strSuffix) {
		List<File> lstRes = new ArrayList<>();

		FindFile oFindFile = new FindFile().searchPath(strDirPath).setRecursive(true).setIncludeDirs(true);

		Iterator<File> oIter = oFindFile.iterator();
		while (oIter.hasNext()) {
			File oFile = oIter.next();
			if (oFile.isFile()) {
				String strFilePath = oFile.getPath();
				if (strFilePath.endsWith(strSuffix)) {
					lstRes.add(oFile);
				}
			}
		}

		return lstRes;
	}

	public static List<File> getFileLstInDirEx2(String strDirPath) {
		List<File> lstRes = new ArrayList<>();

		FindFile oFindFile = new FindFile().searchPath(strDirPath).setRecursive(true).setIncludeDirs(true);

		Iterator<File> oIter = oFindFile.iterator();
		while (oIter.hasNext()) {
			File oFile = oIter.next();
			if (oFile.isFile()) {
				lstRes.add(oFile);
			}
		}

		return lstRes;
	}

	//#endregion

	//#region getParentDirPath

	public static String getParentDirPath(String strDirPath) {
		File oDir = new File(strDirPath);
		String strDirPathParent = oDir.getParent();
		return strDirPathParent;
	}

	//#endregion
}
