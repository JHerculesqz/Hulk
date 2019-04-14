package com.firelord.component.io.xls;

import com.firelord.component.io.dir.DirUtilsEx;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * OfficeXlsConfigUtilsEx
 */
public class OfficeXlsConfigUtilsEx {
    //#region parseXls

    /**
     * parse xls config file
     *
     * @param strDirPathXls xls config dir path
     * @param iSheetIndex   xls sheet index
     * @param oCallback     callback
     */
    public static void parseXls(String strDirPathXls,
                                int iSheetIndex,
                                OfficeXlsConfigUtilsExCallback oCallback) {
        try {
            //get lstFile
            List<File> lstFile = DirUtilsEx.getFileLstInDirEx(strDirPathXls, ".xlsx");

            //遍历lstFilePath
            for (File oFile : lstFile) {
                Workbook oWorkbook = OfficeXlsxUtilsEx.getWorkBook(oFile.getPath());
                Sheet oSheet = OfficeXlsxUtilsEx.getSheet(iSheetIndex, oWorkbook);
                for (int iRowIndex = OfficeXlsxUtilsEx.getRowStartIndex(oSheet) + 1;
                     iRowIndex < OfficeXlsxUtilsEx.getRowCount(oSheet);
                     iRowIndex++) {
                    Row oRow = OfficeXlsxUtilsEx.getRow(iRowIndex, oSheet);
                    oCallback.row2Obj(oRow);
                }
                //killMe
                OfficeXlsxUtilsEx.killMe(oWorkbook);
            }
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    //#endregion
}
