using core_fw.component.ds;
using DevComponents.DotNetBar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_dbar.widget
{
    public class StyleUtils
    {
        #region Fields

        private static StyleManager m_oStyleManager;

        #endregion

        #region addStyleBtnLst

        public static void addStyleBtnLst(ButtonItem oStyleBtnParent, StyleManager oStyleManager)
        {
            m_oStyleManager = oStyleManager;

            List<String> lstStyleName = EnumUtils.getKeys<eStyle>();
            for (int i = 0; i < lstStyleName.Count; i++)
            {
                var strStyleName = lstStyleName[i];
                ButtonItemUtils.addBtnItem(oStyleBtnParent, 
                    "m_buttonItemStyle" + i,
                    strStyleName,
                    new EventHandler(onStyleBtn));
            }
        }
        private static void onStyleBtn(object sender, EventArgs e)
        {
            var oBtn = (ButtonItem)sender;
            StyleUtils.setStyle(m_oStyleManager, oBtn.Text);
        }

        #endregion

        #region setStyle

        private static void setStyle(StyleManager oStyleManager, eStyle oStyle)
        {
            oStyleManager.ManagerStyle = oStyle;
        }

        public static void setStyle(StyleManager oStyleManager, String strStyleName)
        {
            eStyle oStyle = EnumUtils.getEnumByKey<eStyle>(strStyleName);
            setStyle(oStyleManager, oStyle);
        }

        #endregion
    }
}
