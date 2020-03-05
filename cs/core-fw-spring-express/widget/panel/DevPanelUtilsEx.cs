using DevExpress.XtraBars.Docking;
using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.panel
{
    /// <summary>
    /// DockPanelUtilsEx
    /// </summary>
    public class DevPanelUtilsEx
    {
        #region addPanel

        /// <summary>
        /// remove old panel and add new panel to DockPanel Parent
        /// </summary>
        /// <param name="oPanel">new panel</param>
        /// <param name="oParent">DockPanel Parent</param>
        public static void addPanel(Control oPanel, PanelControl oParent)
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
