package com.firelord.component.io.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;

import org.zeroturnaround.zip.ZipEntryCallback;
import org.zeroturnaround.zip.ZipUtil;

import com.firelord.component.io.dir.DirUtilsEx;
import com.firelord.component.io.file.FileUtilsEx;
import com.firelord.component.io.zip.vo.ZipValidatorVo;

public class ZipUtilsEx {
	// #region unpack

	public static void unpack(String strFilePath4Zip, String strDirPath4unZip) {
		ZipUtil.unpack(new File(strFilePath4Zip), new File(strDirPath4unZip), Charset.forName("utf-8"));
	}

	// #endregion

	// #region unpackEntry

	public static void unpackEntry(String strFilePath4Zip, String strFilePathRelative, String strFilePath4unZip) {
		DirUtilsEx.mkDir(new File(strFilePath4unZip).getParent());
		ZipUtil.unpackEntry(new File(strFilePath4Zip), strFilePathRelative, new File(strFilePath4unZip));
	}

	// #endregion

	// #region replaceEntry

	public static boolean replaceEntry(String strFilePath4Zip, String strFilePathRelative4Unpack,
			IZipUtilsExCallback oICallback) {
		// 1.get strSrc
		byte[] arrBytesSrc = ZipUtil.unpackEntry(new File(strFilePath4Zip), strFilePathRelative4Unpack);
		String strSrc = new String(arrBytesSrc);

		// 2.callback
		String strDst = oICallback.modify(strSrc);
		byte[] arrBytesDst = strDst.getBytes();

		// 3.replaceEntry
		boolean bRes = ZipUtil.replaceEntry(new File(strFilePath4Zip), strFilePathRelative4Unpack, arrBytesDst);

		return bRes;
	}

	public static void replaceEntry(String strFilePath4Zip, String strFilePathRelative4Unpack,
			String strFilePath4Replace) {
		ZipUtil.replaceEntry(new File(strFilePath4Zip), strFilePathRelative4Unpack, new File(strFilePath4Replace));
	}

	/**
	 * 潜规则：SpringBoot的FatJar里面的Jar必须是NO_COMPRESSION
	 * 
	 * @param strFilePath4Zip
	 * @param strFilePathRelative4Unpack
	 * @param strFilePath4Replace
	 */
	public static void replaceJar4SpringBoot(String strFilePath4Zip, String strFilePathRelative4Unpack,
			String strFilePath4Replace) {
		byte[] arrBytes = FileUtilsEx.getBytes(strFilePath4Replace);
		ZipUtil.replaceEntry(new File(strFilePath4Zip), strFilePathRelative4Unpack, arrBytes, Deflater.NO_COMPRESSION);
	}

	// #endregion

	// #region validate

	public static ZipValidatorVo validate(String strFilePathZip) {
		final ZipValidatorVo oZipValidatorVo = new ZipValidatorVo();

		ZipUtil.iterate(new File(strFilePathZip), new ZipEntryCallback() {
			@Override
			public void process(InputStream in, ZipEntry zipEntry) throws IOException {
				oZipValidatorVo.setSize(oZipValidatorVo.getSize() + zipEntry.getSize());
				if (!oZipValidatorVo.isInvalidEntryPath()) {
					String strFilePath4ZipEntry = zipEntry.getName();
					oZipValidatorVo.setInvalidEntryPath(strFilePath4ZipEntry.contains(".."));
				}
			}
		});

		return oZipValidatorVo;
	}

	// #endregion

}
