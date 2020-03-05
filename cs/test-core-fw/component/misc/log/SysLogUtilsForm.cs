using core_fw.component.misc.log;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace test_core_fw.component.misc.log
{
    public partial class SysLogUtilsForm : Form
    {
        #region Construction

        public SysLogUtilsForm()
        {
            InitializeComponent();
        }

        #endregion

        #region test

        private void m_buttonTest_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 100000; i++)
            {
                SysLogUtils.info4Sys("Module1", "log..." + i);
            }
        }

        #endregion
    }
}
