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

namespace core_fw_spring_express.widget.warn
{
    public partial class WarnControl : DevExpress.XtraEditors.XtraUserControl
    {
        #region Const

        public const int WIDTH = 110;
        public const int SPLIT = 5;

        #endregion

        #region Fields

        private Dictionary<string, WarnItemControl> m_oDicWarnItem = new Dictionary<string, WarnItemControl>();

        #endregion

        #region Construction

        public WarnControl(List<WarnVo> lstWarnVo)
        {
            InitializeComponent();
            _init(lstWarnVo);
        }

        private void _init(List<WarnVo> lstWarnVo)
        {
            var iCount = lstWarnVo.Count;
            this.Width = (WIDTH + SPLIT) * iCount;
            var iX = SPLIT;
            var iY = SPLIT;
            this.Controls.Clear();
            for (int i = 0; i < iCount; i++)
            {
                var oWarnVo = lstWarnVo[i];
                var oWarnItemControl = WarnItemControl.genWarmFromItem(oWarnVo);
                iX = (WIDTH + SPLIT) * i + SPLIT;
                oWarnItemControl.Location = new Point(iX, iY);
                this.Controls.Add(oWarnItemControl);
                m_oDicWarnItem.Add(oWarnVo.devType, oWarnItemControl);
            }
        }

        #endregion

        #region updateView

        public void updateView(List<WarnVo> lstWarnVo)
        {
            foreach (var strKey in m_oDicWarnItem.Keys)
            {
                var oWarnItemControl = m_oDicWarnItem[strKey];
                var oWarnVo = lstWarnVo.FirstOrDefault(o => o.devType == strKey);
                if (oWarnVo != null)
                {
                    if (oWarnVo.isConnException)
                    {
                        oWarnItemControl.updateView4Warn(oWarnVo);
                    }
                    else
                    {
                        oWarnItemControl.updateView4Normal(oWarnVo);
                    }
                }
            }
        }

        #endregion
    }
}
