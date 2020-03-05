using DevExpress.XtraGrid;
using DevExpress.XtraGrid.Views.Card;
using DevExpress.XtraGrid.Views.Grid;
using DevExpress.XtraGrid.Views.Grid.ViewInfo;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.grid
{
    /// <summary>
    /// JDL:请大哥补充界面设计器上还有哪些常见属性的配置
    /// </summary>
    public class DevGridUtilsEx
    {
        #region dataSource

        public static void initDataSource(GridControl oGrid, object oDataSource)
        {
            oGrid.DataSource = oDataSource;
        }

        public static void refreshDataSource(GridControl oGrid)
        {
            oGrid.RefreshDataSource();
        }

        #endregion

        #region getGridSelectDateRow

        public static List<T> getGridSelectDataRow<T>(GridView oGridView)
        {
            List<T> lstT = new List<T>();
            var arrIndex = oGridView.GetSelectedRows();
            foreach (var index in arrIndex)
            {
                var oT = (T)oGridView.GetRow(index);
                lstT.Add(oT);
            }
            return lstT;
        }

        public static int getGridSelectRowCount(GridView oGridView)
        {
            return oGridView.SelectedRowsCount;
        }

        public static T getGridSelectDataRow<T>(GridView oGridView, int iRowIndex)
        {
            return (T)oGridView.GetRow(iRowIndex);
        }

        #endregion

        #region getCardSelectDateRow

        public static List<T> getCardSelectDataRow<T>(CardView oCardView)
        {
            List<T> lstT = new List<T>();
            var arrIndex = oCardView.GetSelectedRows();
            foreach (var index in arrIndex)
            {
                var oT = (T)oCardView.GetRow(index);
                lstT.Add(oT);
            }
            return lstT;
        }

        #endregion

        #region getRowData4Index

        public static T getRowData4Index<T>(GridView oGridView, int iRowIndex)
        {
            return (T)oGridView.GetRow(iRowIndex);
        }

        #endregion

        #region gridRightClick

        public static void gridRightClick(GridView oGridView, MouseEventArgs e, Action<int> oCallback4RightClick)
        {
            GridHitInfo info = oGridView.CalcHitInfo(e.Location);
            if (e.Button == MouseButtons.Right && info.InRowCell)
            {
                oCallback4RightClick(info.RowHandle);
            }
        }

        #endregion

        #region del

        public static void delSelectRows(GridView oGrid)
        {
            oGrid.DeleteSelectedRows();
        }

        #endregion

        #region point

        public static Point getScreenPoint(GridControl oGridControl, MouseEventArgs e)
        {
            return oGridControl.PointToScreen(e.Location);
        }

        #endregion
    }
}
