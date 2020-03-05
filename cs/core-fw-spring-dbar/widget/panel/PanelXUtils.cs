using DevComponents.DotNetBar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_dbar.widget.panel
{
    public class PanelXUtils
    {
        #region addPanel

        public static void addPanel(Control oPanel, PanelEx oParent)
        {
            oParent.Controls.Clear();
            oPanel.Dock = DockStyle.Fill;
            oParent.Controls.Add(oPanel);
        }

        #endregion

        #region delPanel

        public static void delPanel(Control oPanel, PanelEx oParent)
        {
            oParent.Controls.Clear();
        }

        #endregion
    }
}
