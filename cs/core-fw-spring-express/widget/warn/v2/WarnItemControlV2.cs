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
using DevExpress.XtraEditors.ButtonPanel;
using DevExpress.XtraBars.Docking2010;
using core_fw.component.io;
using DevExpress.Utils.Svg;
using core_fw_spring_express.widget.warn.vo;

namespace core_fw_spring_express.widget.warn
{
    public partial class WarnItemControlV2 : DevExpress.XtraEditors.XtraUserControl
    {
        #region Fields

        private WarnVo m_oWarnVo;

        #endregion

        #region Construction

        public WarnItemControlV2()
        {
            InitializeComponent();
        }

        public WarnItemControlV2(WarnVo oWarnVo)
        {
            InitializeComponent();
            _init(oWarnVo);
        }

        public void _init(WarnVo oWarnVo)
        {
            this.m_oWarnVo = oWarnVo;
            this.m_simpleButton.Text = oWarnVo.devName;
            this.m_simpleButton.Tag = oWarnVo.isConnException;
            this.m_labelControlMsg.Text = String.Join(Environment.NewLine, oWarnVo.WarnInfoLst);
        }

        #endregion

        #region genWarmFromItem

        public static WarnItemControlV2 genWarmFromItem(WarnVo oWarnVo)
        {
            var oWarnItemControl = new WarnItemControlV2(oWarnVo);
            return oWarnItemControl;
        }

        #endregion

        #region updateView

        public void updateView4Warn(WarnVo oWarnVo)
        {
            //更新图标
            this.m_simpleButton.Tag = oWarnVo.isConnException;
            this.m_labelControlMsg.Text = String.Join(Environment.NewLine, oWarnVo.WarnInfoLst);
            this.Visible = oWarnVo.isConnException;
        }

        public void updateView4Hide()
        {
            this.m_simpleButton.Tag = false;
            this.m_labelControlMsg.Text = String.Join(Environment.NewLine, new List<string>());
            this.Visible = false;
        }

        #endregion

        #region click

        private void m_simpleButton_Click(object sender, EventArgs e)
        {
            if ((bool)this.m_simpleButton.Tag)
            {
                this.m_oWarnVo.oCallback4Conn(this.m_oWarnVo.devType);
            }
        }

        #endregion


    }
}
