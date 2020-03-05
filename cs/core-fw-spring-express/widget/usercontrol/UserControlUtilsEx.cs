using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.usercontrol
{
    public class DevUserControlUtilsEx
    {
        #region addPanel

        public static void addPanel(Control oPanel, XtraUserControl oParent)
        {
            foreach (Control oChildControl in oParent.Controls)
            {
                oChildControl.Dispose();
            }
            oParent.Controls.Clear();

            oPanel.Dock = DockStyle.Fill;
            oParent.Controls.Add(oPanel);
        }

        #endregion
    }
}
