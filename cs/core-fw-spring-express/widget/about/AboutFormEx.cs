using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.about
{
    public partial class AboutFormEx : Form
    {
        public AboutFormEx(string strTitle, string strProductName, string strVersion,
            string strCopyRight, string strCompanyName, string strDesc)
        {
            InitializeComponent();
            this.Text = String.Format("关于 {0}", strTitle);
            this.labelProductName.Text = strProductName;
            this.labelVersion.Text = String.Format("版本 {0}", strVersion);
            this.labelCopyright.Text = strCopyRight;
            this.labelCompanyName.Text = strCompanyName;
            this.textBoxDescription.Text = strDesc;
        }
    }
}
