using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using DevExpress.XtraEditors;

namespace core_fw_spring_express.widget.warn.v3
{
    public partial class WarnPanelV3 : DevExpress.XtraEditors.XtraUserControl
    {
        #region Fields

        private Dictionary<string, SimpleButton> m_mapConBtn = new Dictionary<string, SimpleButton>();

        #endregion

        #region Construction

        public WarnPanelV3()
        {
            InitializeComponent();
        }

        public WarnPanelV3(List<ConItemVo> lstConItemVo, Action<string> oCallback4Click)
        {
            InitializeComponent();
            this.m_mapConBtn = ConItemVo.init(lstConItemVo, this.m_panelControl, oCallback4Click);
        }

        #endregion

        #region updateCon

        public void updateCon(List<ConItemVo> lstConItemVoNew)
        {
            foreach (var oConItemVo in lstConItemVoNew)
            {
                if (this.m_mapConBtn.ContainsKey(oConItemVo.name))
                {
                    oConItemVo.updateImg(oConItemVo.img, this.m_mapConBtn[oConItemVo.name]);
                }
                #region not del

                //var arrCtrl = this.m_panelControl.Controls.Find(oConItemVo.name, false);
                //if (arrCtrl.Count() == 1)
                //{
                //    oConItemVo.updateImg(oConItemVo.img, arrCtrl[0]);
                //}

                #endregion
            }
        }

        #endregion

        #region updateWarn

        public void updateWarn(List<string> lstWarnMsg)
        {
            var strWarnTitle = string.Format("告警({0})", lstWarnMsg.Count);
            if (this.m_dropDownButtonWarn.Text != strWarnTitle)
            {
                this.m_dropDownButtonWarn.Text = strWarnTitle;
            }

            var strWarnMsg = string.Join(Environment.NewLine, lstWarnMsg);
            if (this.m_labelControlWarnMsg.Text != strWarnMsg)
            {
                this.m_labelControlWarnMsg.Text = strWarnMsg;
            }
        }

        #endregion
    }
}
