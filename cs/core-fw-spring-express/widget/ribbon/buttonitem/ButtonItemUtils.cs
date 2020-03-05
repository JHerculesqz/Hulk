using DevExpress.XtraBars;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.buttonitem
{
    public class ButtonItemUtils
    {
        #region isExistsByText

        public static bool isExistsByText(BarSubItem oParent, String strText)
        {
            foreach (LinkPersistInfo oSubBtnItem in oParent.LinksPersistInfo)
            {
                if (oSubBtnItem.Item.Caption == strText)
                {
                    return true;
                }
            }

            return false;
        }

        #endregion

        #region addBtnItem

        public static void addBtnItem(BarSubItem oParent, String strName, String strText,
            ItemClickEventHandler oBtnClickCallback)
        {
            var oBtnItem = new BarButtonItem();
            oBtnItem.Name = strName;
            oBtnItem.Caption = strText;
            oBtnItem.ItemClick += oBtnClickCallback;
            var oLinkPersistInfo = new LinkPersistInfo(oBtnItem);
            oParent.LinksPersistInfo.Add(oLinkPersistInfo);
        }

        #endregion
    }
}
