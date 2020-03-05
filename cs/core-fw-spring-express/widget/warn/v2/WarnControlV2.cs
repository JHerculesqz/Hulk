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
using core_fw_spring_express.widget.warn.vo;
using core_fw_spring_express.widget.layout;

namespace core_fw_spring_express.widget.warn
{
    public partial class WarnControlV2 : DevExpress.XtraEditors.XtraUserControl
    {
        #region Const

        public const int SPLIT = 5;

        #endregion

        #region Fields
        private Point point;
        private bool m_isManualsHide = false;
        private Form m_oParentForm;
        private TableLayoutPanel m_oTableLayoutWarn;
        private Dictionary<string, WarnItemControlV2> m_oDicWarnItem = new Dictionary<string, WarnItemControlV2>();

        #endregion

        #region Construction

        public WarnControlV2(List<WarnVo> lstWarnVo, Form oParent)
        {
            InitializeComponent();
            _init(lstWarnVo, oParent);
        }

        private void _init(List<WarnVo> lstWarnVo, Form oParent)
        {
            this.m_oParentForm = oParent;
            var iCount = lstWarnVo.Count;
            this.m_oTableLayoutWarn = DevTableLayoutUtils.addLayout("tableLayoutWarn", 1, iCount, true, this);
            this.m_oTableLayoutWarn.Visible = false;
            //this.Controls.Clear();
            for (int i = 0; i < iCount; i++)
            {
                var oWarnVo = lstWarnVo[i];
                var oWarnItemControl = WarnItemControlV2.genWarmFromItem(oWarnVo);
                oWarnItemControl.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
                DevTableLayoutUtils.addItemControl(oWarnItemControl, this.m_oTableLayoutWarn, 0, i);
                this.m_oDicWarnItem.Add(oWarnVo.devType, oWarnItemControl);
            }
        }

        #endregion

        #region updateView

        public void updateView(List<WarnVo> lstWarnVo)
        {
            var iCount = lstWarnVo.Count;
            if (iCount == 0)
            {
                this.m_oTableLayoutWarn.Visible = false;
            }
            else if (iCount > 0 && !this.m_isManualsHide)
            {
                this.m_oTableLayoutWarn.Visible = true;
            }
            this.m_simpleButtonWarnNum.Text = lstWarnVo.Count.ToString();
            foreach (var strKey in m_oDicWarnItem.Keys)
            {
                var oWarnItemControl = m_oDicWarnItem[strKey];
                var oWarnVo = lstWarnVo.FirstOrDefault(o => o.devType == strKey);
                if (oWarnVo != null)
                {
                    oWarnItemControl.updateView4Warn(oWarnVo);
                }
                else
                {
                    oWarnItemControl.updateView4Hide();
                }
            }
        }

        #endregion

        #region show/hide

        private void m_simpleButtonWarnNum_DoubleClick(object sender, EventArgs e)
        {
            this.m_oTableLayoutWarn.Visible = !this.m_oTableLayoutWarn.Visible;
            this.m_isManualsHide = !this.m_oTableLayoutWarn.Visible;
        }

        #endregion

        #region mouse

        private void m_simpleButtonWarnNum_MouseDown(object sender, MouseEventArgs e)
        {
            point = new Point(e.X, e.Y);
        }

        private void m_simpleButtonWarnNum_MouseMove(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                this.m_oParentForm.Location = new Point(this.m_oParentForm.Location.X + e.X - point.X,
                    this.m_oParentForm.Location.Y + e.Y - point.Y);
            }
        }

        #endregion
    }
}
