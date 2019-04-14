using OfficeOpenXml;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace walle.component.file
{
    public class XlsUtilsEx
    {
        public static ExcelPackage getExcel(String strFilePath)
        {
            ExcelPackage oExcel = new ExcelPackage(new FileInfo(strFilePath));
            return oExcel;
        }

        public static ExcelWorkbook getWorkBook(ExcelPackage oExcel)
        {
            return oExcel.Workbook;
        }

        public static ExcelWorksheet getSheet(int iSheetIndex, ExcelWorkbook oWorkbook)
        {
            ExcelWorksheet oSheet = oWorkbook.Worksheets[iSheetIndex];
            return oSheet;
        }

        public static int getRowCount(ExcelWorksheet oSheet)
        {
            int iRowCount = oSheet.Dimension.End.Row;
            return iRowCount;
        }

        public static int getColCount(ExcelWorksheet oSheet)
        {
            int iCellCount = oSheet.Dimension.End.Column;
            return iCellCount;
        }

        public static ExcelRange getCell(int iRowIndex, int iColIndex, ExcelWorksheet oSheet)
        {
            ExcelRange oCell = oSheet.Cells[iRowIndex, iColIndex];
            return oCell;
        }
    }
}
