using core_fw.component.io;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace test_core_fw.component.io.path
{
    public partial class PathForm : Form
    {
        public PathForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show(PathUtils.getAbsTmpFilePath(@"cpk\core-fw-ddd\index.html"));
        }
    }
}
