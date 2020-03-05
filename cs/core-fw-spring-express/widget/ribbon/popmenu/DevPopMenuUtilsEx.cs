using DevExpress.XtraBars;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.popmenu
{
    public class DevPopMenuUtilsEx
    {
        #region containsByText

        public static bool containsByText(string strText, PopupMenu oParent)
        {
            foreach (BarItemLink oBarItemLink in oParent.ItemLinks)
            {
                if (oBarItemLink.Caption == strText)
                {
                    return true;
                }
            }

            return false;
        }

        #endregion

        #region addBarItem

        public static void addBarItem(string strId, string strText, ItemClickEventHandler oCallbackItemClick,
            PopupMenu oParent)
        {
            var oBarButtonItem = new BarButtonItem();
            oBarButtonItem.Name = strId;
            oBarButtonItem.Caption = strText;
            oBarButtonItem.ItemClick += oCallbackItemClick;
            oParent.AddItem(oBarButtonItem);
        }

        #endregion
    }
}
