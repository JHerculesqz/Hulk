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
using core_fw_spring_express.widget.log.syslog;
using core_fw_spring_express.widget.panel;
using core_fw.component.thread.task;
using core_fw.component.thread.timer;
using walle.widget.form;

namespace test_core_fw_spring_express.widget.log
{
    public partial class SystemLogPanel : DevExpress.XtraEditors.XtraUserControl
    {
        public SystemLogPanel()
        {
            InitializeComponent();
        }

        private void simpleButton1_Click(object sender, EventArgs e)
        {
            var oPanel = SysUserLogUtils.initUI4UserLog();
            DevPanelUtilsEx.addPanel(oPanel, this.panelControl1);
        }

        private void simpleButtonDebug_Click(object sender, EventArgs e)
        {
            SysUserLogUtils.debug4Sys("Module1", "debug");
        }

        private void simpleButton7_Click(object sender, EventArgs e)
        {
            SysUserLogUtils.info4Sys("Module1", "info");
        }

        private void simpleButton6_Click(object sender, EventArgs e)
        {
            SysUserLogUtils.warn4Sys("Module1", "warn");
        }

        private void simpleButton5_Click(object sender, EventArgs e)
        {
            SysUserLogUtils.error4Sys("Module1", "error");
        }

        private void simpleButton4_Click(object sender, EventArgs e)
        {
            SchedulerUtils oSchedulerUtils = new SchedulerUtils();
            oSchedulerUtils.startAsync(500, 100, false, () =>
            {
                FormUtilsEx.invoke4Control(this, () =>
                {
                    SysUserLogUtils.debug4Sys("Module1", "debug");
                });
            });
        }
    }
}
