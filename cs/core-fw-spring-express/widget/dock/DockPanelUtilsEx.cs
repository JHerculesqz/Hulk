using DevExpress.XtraBars.Docking;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.dock
{
    /// <summary>
    /// DockPanelUtilsEx
    /// </summary>
    public class DockPanelUtilsEx
    {
        #region updateName

        /// <summary>
        /// update DockPanel text
        /// </summary>
        /// <param name="strName">new text for DockPanel</param>
        /// <param name="oDockPanel">DockPanel</param>
        public static void updateName(string strName, DockPanel oDockPanel)
        {
            oDockPanel.Text = strName;
        }

        #endregion

        #region addPanel

        /// <summary>
        /// remove old panel and add new panel to DockPanel Parent
        /// </summary>
        /// <param name="oPanel">new panel</param>
        /// <param name="oParent">DockPanel Parent</param>
        public static void addPanel(Control oPanel, DockPanel oParent)
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

        #region hidePanel

        /// <summary>
        /// hide panel to DockPanel Parent
        /// </summary>
        /// <param name="bIsHide">true: hide</param>
        /// <param name="oParent">DockPanel Parent</param>
        public static void hidePanel(bool bIsHide, DockPanel oParent)
        {
            oParent.Visible = bIsHide;
        }

        #endregion
    }
}
