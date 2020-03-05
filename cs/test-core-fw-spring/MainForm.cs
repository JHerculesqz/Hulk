using core_fw.core;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using test_core_fw_spring.core.ioc;

namespace test_core_fw_spring
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void m_buttonIOC_Click(object sender, EventArgs e)
        {
            var oITest = IOCUtils.getBean<ITest>();
            oITest.test();
        }
    }
}
