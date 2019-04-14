using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_csharp.src.widget.grid
{
    public class GridUtils
    {
        #region addComboCol

        public static void addComboCol(string strColName, string strColText,
            List<string> lstColOptions, DataGridView oDataGridView)
        {
            var oDataGridViewComboBoxColumn = new DataGridViewComboBoxColumn();
            oDataGridViewComboBoxColumn.Name = strColName;
            oDataGridViewComboBoxColumn.HeaderText = strColText;
            foreach (var strColOption in lstColOptions)
            {
                oDataGridViewComboBoxColumn.Items.Add(strColOption);
            }
            oDataGridView.Columns.Add(oDataGridViewComboBoxColumn);
        }

        #endregion

        #region addTextCol

        public static void addTextCol(string strColName, string strColText,
            DataGridView oDataGridView)
        {
            var oDataGridViewTextBoxColumn = new DataGridViewTextBoxColumn();
            oDataGridViewTextBoxColumn.Name = strColName;
            oDataGridViewTextBoxColumn.HeaderText = strColText;
            oDataGridView.Columns.Add(oDataGridViewTextBoxColumn);
        }

        public static void addLinkColumnCol(string strColName, string strColText,
           DataGridView oDataGridView)
        {
            var oDataGridViewLinkColumn = new DataGridViewLinkColumn();
            oDataGridViewLinkColumn.HeaderText = strColText;
            oDataGridViewLinkColumn.Name = strColName;
            oDataGridViewLinkColumn.ActiveLinkColor = System.Drawing.Color.White;
            oDataGridViewLinkColumn.LinkBehavior = LinkBehavior.SystemDefault;
            oDataGridViewLinkColumn.LinkColor = System.Drawing.Color.Blue;
            oDataGridViewLinkColumn.TrackVisitedState = true;
            oDataGridViewLinkColumn.VisitedLinkColor = System.Drawing.Color.YellowGreen;
            oDataGridView.Columns.Add(oDataGridViewLinkColumn);
        }

        #endregion

        #region addRow

        public static void addRow(List<object> lstValue, DataGridView oDataGridView)
        {
            oDataGridView.Rows.Add(lstValue.ToArray());
        }

        #endregion

        #region getColumn

        public static DataGridViewColumn getColumn(int iColIndex,
            DataGridView oDataGridView)
        {
            DataGridViewColumn oColumn = oDataGridView.Columns[iColIndex];
            return oColumn;
        }

        #endregion

        #region getRow

        public static DataGridViewRow getRow(int iRowIndex,
            DataGridView oDataGridView)
        {
            DataGridViewRow oRow = oDataGridView.Rows[iRowIndex];
            return oRow;
        }

        #endregion

        #region getCell

        public static DataGridViewCell getCell(int iRowIndex, int iColIndex,
            DataGridView oDataGridView)
        {
            DataGridViewCell oCell = oDataGridView.Rows[iRowIndex].Cells[iColIndex];
            return oCell;
        }

        public static DataGridViewCell getCell(int iColIndex,
         DataGridViewRow oDataGridViewRow)
        {
            DataGridViewCell oCell = oDataGridViewRow.Cells[iColIndex];
            return oCell;
        }

        #endregion

        #region clear

        public static void clear(DataGridView oDataGridView)
        {
            oDataGridView.Columns.Clear();
            oDataGridView.Rows.Clear();
        }

        #endregion
    }
}
