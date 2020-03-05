using core_fw.widget.control;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.ribbon.vo
{
    public class DevRibbonPageMapVo
    {
        #region Fields

        private Dictionary<string, DevRibbonPageVo> mapPageVo = new Dictionary<string, DevRibbonPageVo>();

        public Dictionary<string, DevRibbonPageVo> MapPageVo { get => mapPageVo; set => mapPageVo = value; }

        #endregion

        #region upsertMap

        public void upsertMap(string strPageName, DevRibbonPageVo oPageVo)
        {
            if (!this.mapPageVo.ContainsKey(strPageName))
            {
                this.mapPageVo.Add(strPageName, oPageVo);
            }
            else
            {
                this.mapPageVo[strPageName] = oPageVo;
            }
        }

        #endregion

        #region enableBtn

        public void enableBtn(string strBtnName, bool bIsEnable, Control oParent)
        {
            var oRes = ControlUtils.findControlByName(oParent, strBtnName);
            if (null != oRes)
            {
                oRes.Enabled = bIsEnable;
            }
        }

        #endregion

        #region visibleBtn

        public void visibleBtn(string strBtnName, bool bIsVisible, Control oParent)
        {
            var oRes = ControlUtils.findControlByName(oParent, strBtnName);
            if (null != oRes)
            {
                oRes.Visible = bIsVisible;
            }
        }

        #endregion
    }
}
