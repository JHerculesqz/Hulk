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
    public partial class WarnItemControl : DevExpress.XtraEditors.XtraUserControl
    {
        #region Const

        private const string LIGHT_IMAGE_PATH_GRAY = "data\\images\\bu-app\\ribbon\\advance\\custom-icon-11.svg";
        private const string LIGHT_IMAGE_PATH_GREEN = "data\\images\\bu-app\\ribbon\\advance\\custom-icon-14.svg";

        #endregion

        #region Fields

        private WarnVo m_oWarnVo;
        private SvgImage m_oSvgImage4Exception = SvgImage.FromFile(PathUtils.getRootDirPath() + LIGHT_IMAGE_PATH_GRAY);
        private SvgImage m_oSvgImage4Normal = SvgImage.FromFile(PathUtils.getRootDirPath() + LIGHT_IMAGE_PATH_GREEN);

        private Dictionary<int, string> m_oDicStatus = new Dictionary<int, string>()
        {
            { 1,"正常"},
            { 2,"重连"},
            { 3,"报警"}
        };

        #endregion

        #region Construction

        public WarnItemControl()
        {
            InitializeComponent();
        }

        public WarnItemControl(WarnVo oWarnVo)
        {
            InitializeComponent();
            this.m_oWarnVo = oWarnVo;
            var oWindowsUIButton = (WindowsUIButton)this.m_winUIButtonStatus.Buttons[0];
            oWindowsUIButton.Caption = this.m_oWarnVo.devName;
            oWindowsUIButton.ImageOptions.SvgImage = oWarnVo.isConnException ? this.m_oSvgImage4Exception : this.m_oSvgImage4Normal;
        }

        #endregion

        #region genWarmFromItem

        public static WarnItemControl genWarmFromItem(WarnVo oWarnVo)
        {
            var oWarnItemControl = new WarnItemControl(oWarnVo);
            return oWarnItemControl;
        }

        #endregion

        #region updateView

        public void updateView4Warn(WarnVo oWarnVo)
        {
            var oWindowsUIButton = (WindowsUIButton)this.m_winUIButtonStatus.Buttons[0];
            oWindowsUIButton.Tag = true;
            oWindowsUIButton.ImageOptions.SvgImage = this.m_oSvgImage4Exception;
            oWindowsUIButton.Caption = this.m_oWarnVo.devName + "-" + m_oDicStatus[2];
            this.m_labelControlMsg.Text = String.Join(Environment.NewLine, oWarnVo.WarnInfoLst);
        }

        public void updateView4Normal(WarnVo oWarnVo)
        {
            var oWindowsUIButton = (WindowsUIButton)this.m_winUIButtonStatus.Buttons[0];
            oWindowsUIButton.Tag = false;
            oWindowsUIButton.ImageOptions.SvgImage = this.m_oSvgImage4Normal;
            oWindowsUIButton.Caption = this.m_oWarnVo.devName + "-" + m_oDicStatus[1];
            this.m_labelControlMsg.Text = String.Join(Environment.NewLine, oWarnVo.WarnInfoLst);
        }

        #endregion

        #region click

        private void m_winUIButtonStatus_ButtonClick(object sender, ButtonEventArgs e)
        {
            if ((bool)e.Button.Properties.Tag)
            {
                this.m_oWarnVo.oCallback4Conn(this.m_oWarnVo.devType);
            }
        }

        #endregion
    }
}
