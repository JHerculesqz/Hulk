using core_fw_spring_express.widget.control;
using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.warn.v3
{
    public class ConItemVo
    {
        #region Fields

        public string name { set; get; }
        public string text { set; get; }
        public bool isCon { set; get; }
        public Image img { set; get; }

        #endregion

        #region init

        public static Dictionary<string, SimpleButton> init(List<ConItemVo> lstConItemVo, PanelControl oParent,
            Action<string> oCallback4Click)
        {
            var mapRes = new Dictionary<string, SimpleButton>();

            for (int iIndex = 0; iIndex < lstConItemVo.Count; iIndex++)
            {
                var oConItemVo = lstConItemVo[iIndex];
                var oBtn = _addBtn(oConItemVo.name, oConItemVo.text, oConItemVo.img, iIndex, oParent,
                    oCallback4Click);
                mapRes.Add(oConItemVo.name, oBtn);
            }

            return mapRes;
        }
        private static SimpleButton _addBtn(string strName, string strText, Image oImg, int iIndex,
            PanelControl oParent, Action<string> oCallback4Click)
        {
            var oBtn = new SimpleButton();

            oBtn.Name = strName;
            oBtn.Text = strText;
            oBtn.Size = new System.Drawing.Size(80, 29);
            oBtn.ImageOptions.Image = oImg;
            oBtn.Location = new System.Drawing.Point(10 + iIndex * 85, 3);
            oBtn.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top |
                System.Windows.Forms.AnchorStyles.Left)));
            oBtn.Click += (sender, e) =>
            {
                DevButtonUtils.disableDelay(oBtn, 500);
                oCallback4Click(strName);
            };
            oParent.Controls.Add(oBtn);

            return oBtn;
        }

        #endregion

        #region updateImg

        public void updateImg(Image oImg, Control oBtn)
        {
            var oBtnEx = oBtn as SimpleButton;
            oBtnEx.ImageOptions.Image = oImg;
        }

        #endregion
    }
}
