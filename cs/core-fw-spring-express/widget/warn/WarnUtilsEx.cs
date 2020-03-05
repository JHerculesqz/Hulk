using core_fw_spring_express.widget.warn.vo;
using DevExpress.XtraBars.Alerter;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.warn
{
    public class WarnUtilsEx
    {
        #region addWarn(暂时保留)

        public static void addWarn(Form ower, string caption, string text, Action oActionCallback)
        {

            var oAlertControl = new DevExpress.XtraBars.Alerter.AlertControl();
            oAlertControl.ButtonClick += (sender, e) =>
            {
                if (e.ButtonName == "m_btnReConnect")
                {
                    oAlertControl.AutoFormDelay = 100;
                    oActionCallback();
                }
            };
            Image image4btn = Image.FromFile("data/images/MC/p_24px.png");
            Image image = Image.FromFile("data/images/MC/p_24px.png");
            AlertButton btnReConnet = new AlertButton(image4btn);
            btnReConnet.Hint = "重新连接";
            btnReConnet.Name = "m_btnReConnect";
            oAlertControl.Buttons.Add(btnReConnet);
            oAlertControl.ShowCloseButton = false;
            oAlertControl.FormMaxCount = 1;
            oAlertControl.Show(ower, caption, text, "", image);
        }

        public static AlertControl getWarn(Action oActionCallback)
        {
            var oAlertControl = new AlertControl();
            oAlertControl.ButtonClick += (sender, e) =>
            {
                if (e.ButtonName == "m_btnReConnect")
                {
                    oAlertControl.AutoFormDelay = 100;
                    oActionCallback();
                }
            };
            Image image4btn = Image.FromFile("data/images/MC/p_24px.png");
            Image image = Image.FromFile("data/images/MC/p_24px.png");
            AlertButton btnReConnet = new AlertButton(image4btn);
            btnReConnet.Hint = "重新连接";
            btnReConnet.Name = "m_btnReConnect";
            oAlertControl.Buttons.Add(btnReConnet);
            oAlertControl.ShowCloseButton = false;
            oAlertControl.FormMaxCount = 1;
            return oAlertControl;
        }

        #endregion

        #region WarmControl

        public static WarnControl genWarmControl(List<WarnVo> lstWarnVo, Form oParent)
        {
            var oWarnControl = new WarnControl(lstWarnVo);
            oParent.Width = oWarnControl.Width + (WarnControl.SPLIT * 2);
            oParent.Height = oWarnControl.Height + WarnControl.SPLIT;
            oParent.Controls.Clear();
            oParent.Controls.Add(oWarnControl);
            return oWarnControl;
        }

        public static void updateView(List<WarnVo> lstWarnVo, WarnControl oWarnControl)
        {
            oWarnControl.updateView(lstWarnVo);
        }

        #endregion

        #region WarmControlV2

        public static WarnControlV2 genWarmControlV2(List<WarnVo> lstWarnVo, Form oParent)
        {
            var oWarnControl = new WarnControlV2(lstWarnVo, oParent);
            oParent.Width = oWarnControl.Width + (WarnControlV2.SPLIT * 2);
            oParent.Height = oWarnControl.Height + WarnControlV2.SPLIT;
            //oParent.Controls.Clear();
            oParent.Controls.Add(oWarnControl);
            return oWarnControl;
        }

        public static void updateViewV2(List<WarnVo> lstWarnVo, WarnControlV2 oWarnControl)
        {
            oWarnControl.updateView(lstWarnVo);
        }

        #endregion
    }
}
