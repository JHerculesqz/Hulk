using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using DevExpress.XtraEditors;

namespace core_fw_spring_express.widget.about
{
    public partial class AboutFormEx2 : DevExpress.XtraEditors.XtraForm
    {
        #region Construction

        public AboutFormEx2(string strTitle, string strProductName, string strVersion, string strCopyRight, string strFilePathImg)
        {
            InitializeComponent();
            this.Text = String.Format("{0}", strTitle);
            this.m_labelControlProductName.Text = strProductName;
            this.m_labelControlVer.Text = String.Format("{0}", strVersion);
            this.m_labelControlCopyRight.Text = strCopyRight;
            this.m_pictureEdit.Image = Image.FromFile(strFilePathImg);
        }

        #endregion
    }
}