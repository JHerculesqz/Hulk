using DevComponents.DotNetBar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_dbar.widget
{
    public class ButtonItemUtils
    {
        #region isExistsByText

        public static bool isExistsByText(ButtonItem oParent, String strText)
        {
            foreach (var oSubBtnItem in oParent.SubItems)
            {
                if (oSubBtnItem is ButtonItem)
                {
                    var oSubBtnItemEx = oSubBtnItem as ButtonItem;
                    if (oSubBtnItemEx.Text == strText)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        #endregion

        #region addBtnItem

        public static void addBtnItem(ButtonItem oParent, String strName, String strText,
            EventHandler oBtnClickCallback)
        {
            var oBtnItem = new ButtonItem();
            oBtnItem.Name = strName;
            oBtnItem.Text = strText;
            oBtnItem.Click += oBtnClickCallback;
            oParent.SubItems.Add(oBtnItem);
        }

        #endregion
    }
}
