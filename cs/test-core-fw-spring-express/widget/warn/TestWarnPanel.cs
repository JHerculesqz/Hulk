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
using core_fw_spring_express.widget.warn.v3;
using core_fw.component.io;
using System.IO;
using core_fw.component.ds.id;
using walle.component.random;
using walle.component.math;
using core_fw.component.thread.timer;
using walle.widget.form;

namespace test_core_fw_spring_express.widget.warn
{
    public partial class TestWarnPanel : DevExpress.XtraEditors.XtraUserControl
    {
        #region Const

        private static string FILE_PATH_LINK = Path.Combine(PathUtils.getRootDirPath(), @"data\image\link.png");
        private static string FILE_PATH_UNLINK = Path.Combine(PathUtils.getRootDirPath(), @"data\image\unlink.png");

        #endregion

        #region Fields

        private SchedulerUtils m_oShcedulerUtils = new SchedulerUtils();

        private WarnPanelV3 m_oWarnPanelV3;

        #endregion

        #region Construction

        public TestWarnPanel()
        {
            InitializeComponent();
        }

        #endregion

        #region init

        private void m_simpleButtonWarnPanelV3Init_Click(object sender, EventArgs e)
        {
            List<ConItemVo> lstConItemVo = _genConItemLst();
            this.m_oWarnPanelV3 = new WarnPanelV3(lstConItemVo, (strName) =>
             {
                 Console.WriteLine(strName);
             });
            this.m_oWarnPanelV3.Dock = DockStyle.Top;
            this.Controls.Add(this.m_oWarnPanelV3);
        }

        #endregion

        #region update

        private void m_simpleButtonWarnPanelV3UpdateCon_Click(object sender, EventArgs e)
        {
            this.m_oShcedulerUtils.startAsync(500, 100, false, () =>
            {
                //updateCon
                List<ConItemVo> lstConItemVo = _genConItemLst();
                FormUtilsEx.invoke4Control(this, () =>
                {
                    this.m_oWarnPanelV3.updateCon(lstConItemVo);
                });

                //updateWarn
                var lstWarnMsg = new List<string>();
                for (int i = 0; i < new Random().Next(0, 50); i++)
                {
                    lstWarnMsg.Add("FTC:X轴限位告警" + IDUtilsEx.gen());
                }
                FormUtilsEx.invoke4Control(this, () =>
                {
                    this.m_oWarnPanelV3.updateWarn(lstWarnMsg);
                });
            });
        }
        private static List<ConItemVo> _genConItemLst()
        {
            var lstConItemVo = new List<ConItemVo>();
            for (int i = 0; i < 5; i++)
            {
                var iRandom = new Random().Next(0, 2);
                lstConItemVo.Add(new ConItemVo()
                {
                    name = "id" + i,
                    text = "设备" + i,
                    isCon = iRandom >= 1 ? true : false,
                    img = iRandom >= 1 ? Image.FromFile(FILE_PATH_LINK) : Image.FromFile(FILE_PATH_UNLINK)
                });
            }

            return lstConItemVo;
        }

        #endregion
    }
}
