using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.layout
{
    public class DevTableLayoutUtils
    {
        #region addLayout

        #endregion
        public static TableLayoutPanel addLayout(string strName, int iColCount, int iRowCount, bool isAutoSize, Control oParent)
        {
            ////clear
            //foreach (Control oChildControl in oParent.Controls)
            //{
            //    oChildControl.Dispose();
            //}
            //oParent.Controls.Clear();

            var oLayout = new TableLayoutPanel();
            oLayout.AutoSize = isAutoSize;
            oLayout.AutoSizeMode = isAutoSize ? System.Windows.Forms.AutoSizeMode.GrowAndShrink
                                              : System.Windows.Forms.AutoSizeMode.GrowOnly;
            oLayout.ColumnCount = iColCount;
            oLayout.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            oLayout.Dock = System.Windows.Forms.DockStyle.Fill;
            oLayout.Name = strName;
            oLayout.RowCount = iRowCount;
            oParent.Controls.Add(oLayout);

            return oLayout;
        }

        #region addItem

        public static void addItemControl(Control oControl, TableLayoutPanel oParent, int iColIndex, int iRowIndex)
        {
            oControl.AutoSize = true;
            oControl.Dock = System.Windows.Forms.DockStyle.Fill;
            oParent.Controls.Add(oControl, iColIndex, iRowIndex);
        }

        #endregion

    }
}
