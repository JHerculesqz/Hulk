using DevExpress.XtraTab;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.tab
{
    public class TabUtilsEx
    {
        #region addTab

        public static void addPanel2Tab(Control oChild, XtraTabPage oParent)
        {
            foreach (Control oChildControl in oParent.Controls)
            {
                oChildControl.Dispose();
            }
            oParent.Controls.Clear();

            oChild.Dock = DockStyle.Fill;
            oParent.Controls.Add(oChild);
        }

        public static void addPanel(Control oPanel, Control oParent)
        {
            oParent.Controls.Clear();

            oPanel.Dock = DockStyle.Fill;
            oParent.Controls.Add(oPanel);
        }

        #endregion
    }
}
