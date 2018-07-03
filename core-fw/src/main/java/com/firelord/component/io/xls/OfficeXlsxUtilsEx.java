package com.firelord.component.io.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellUtil;

public class OfficeXlsxUtilsEx {
	// #region getWorkBook

	public static Workbook getWorkBook(String strFilePath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook oWorkbook = WorkbookFactory.create(new File(strFilePath));
		return oWorkbook;
	}

	public static Workbook getWorkBook4Write(String strFilePath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook oWorkbook = WorkbookFactory.create(new FileInputStream(strFilePath));
		return oWorkbook;
	}

	// #endregion

	// #region getSheet

	public static Sheet getSheet(int iSheetIndex, Workbook oWorkbook) {
		Sheet oSheet = oWorkbook.getSheetAt(iSheetIndex);
		return oSheet;
	}

	// #endregion

	// #region getRowStartIndex

	public static int getRowStartIndex(Sheet oSheet) {
		return oSheet.getFirstRowNum();
	}

	// #endregion

	// #region getRowCount

	public static int getRowCount(Sheet oSheet) {
		return oSheet.getPhysicalNumberOfRows();
	}

	// #endregion

	// #region getRow

	public static Row getRow(int iRowIndex, Sheet oSheet) {
		return oSheet.getRow(iRowIndex);
	}

	// #endregion

	// #region getColumnStartIndex

	public static int getColumnStartIndex(Row oRow) {
		return oRow.getFirstCellNum();
	}

	// #endregion

	// #region getColumnCount

	public static int getColumnCount(Row oRow) {
		return oRow.getPhysicalNumberOfCells();
	}

	// #endregion

	// #region getCell

	public static Cell getCell(int iColumnIndex, Row oRow) {
		return oRow.getCell(iColumnIndex);
	}

	// #endregion

	// #region killMe

	public static void killMe(Workbook oWorkbook) throws IOException {
		oWorkbook.close();
	}

	// #endregion

	// #region saveAs

	public static void saveAs(Workbook oWorkbook, String strFilePath) throws IOException {
		FileOutputStream oFileOutputStream = new FileOutputStream(strFilePath);
		oWorkbook.write(oFileOutputStream);
		oFileOutputStream.close();
	}

	// #endregion

	// #region createRow

	public static Row createRow(Sheet oSheet, int iRowIndex) {
		Row oRow = oSheet.createRow((short) iRowIndex);
		return oRow;
	}

	// #endregion

	// #region createCell

	public static Cell createCell(Row oRow, int iColIndex) {
		Cell oCell = oRow.createCell((short) iColIndex);
		return oCell;
	}

	// #endregion

	// #region setCellVal

	public static void setCellVal(Cell oCell, double val) {
		oCell.setCellValue(val);
	}

	public static void setCellVal(Cell oCell, Date val) {
		oCell.setCellValue(val);
	}

	public static void setCellVal(Cell oCell, Calendar val) {
		oCell.setCellValue(val);
	}

	public static void setCellVal(Cell oCell, RichTextString val) {
		oCell.setCellValue(val);
	}

	public static void setCellVal(Cell oCell, String val) {
		oCell.setCellValue(val);
	}

	public static void setCellVal(Cell oCell, boolean val) {
		oCell.setCellValue(val);
	}

	// #endregion

	// #region setCellStyle

	public static Map<String, Object> initCellBorder() {
		Map<String, Object> oProps = new HashMap<String, Object>();

		// border around a cell
		oProps.put(CellUtil.BORDER_TOP, BorderStyle.THIN);
		oProps.put(CellUtil.BORDER_BOTTOM, BorderStyle.THIN);
		oProps.put(CellUtil.BORDER_LEFT, BorderStyle.THIN);
		oProps.put(CellUtil.BORDER_RIGHT, BorderStyle.THIN);

		// Give it a color
		oProps.put(CellUtil.TOP_BORDER_COLOR, IndexedColors.GREY_25_PERCENT.getIndex());
		oProps.put(CellUtil.BOTTOM_BORDER_COLOR, IndexedColors.GREY_25_PERCENT.getIndex());
		oProps.put(CellUtil.LEFT_BORDER_COLOR, IndexedColors.GREY_25_PERCENT.getIndex());
		oProps.put(CellUtil.RIGHT_BORDER_COLOR, IndexedColors.GREY_25_PERCENT.getIndex());

		return oProps;
	}

	public static void applyCellStyle(Cell oCell, Map<String, Object> oProps) {
		CellUtil.setCellStyleProperties(oCell, oProps);
	}

	// #endregion
}
