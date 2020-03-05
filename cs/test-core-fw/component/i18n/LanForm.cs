using core_fw.widget.i18n;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace test_core_fw
{
    public partial class LanForm : Form
    {
        public LanForm()
        {
            InitializeComponent();
        }

        private void LanForm_Load(object sender, EventArgs e)
        {
            this.m_labelLanTip.Text = I18nUtilsEx.getStrFromApp("lan");
        }
    }
}
