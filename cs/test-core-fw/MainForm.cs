using core_fw.component.ds.byteEx;
using core_fw.component.io.crc;
using core_fw.component.io.mq.devCmd;
using core_fw.component.io.mq.zero;
using core_fw.component.io.udp;
using core_fw.component.thread.task;
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
using test_core_fw.component.ds.str;
using test_core_fw.component.io.mq.devCmd;
using test_core_fw.widget.pgrid;
using walle.component.math;

namespace test_core_fw
{
    public partial class MainForm : Form
    {
        #region Fields



        #endregion

        #region Construction

        public MainForm()
        {
            InitializeComponent();
            _lanInit();
        }

        #endregion

        #region LombokBase

        private void m_buttonLombokBase_Click(object sender, EventArgs e)
        {
            var oTestObj = new TestObj();
            oTestObj.Name = "Shit";
            Console.WriteLine(oTestObj.ToString());
        }

        #endregion

        #region PropertyGrid

        private void m_buttonPropertyGrid_Click(object sender, EventArgs e)
        {
            new PGridForm().ShowDialog();
        }

        #endregion

        #region MQ.DevCmd

        private void m_buttonDevCmdMQInit_Click(object sender, EventArgs e)
        {
            DevCmdMQ.getInstance().init();
        }

        private void m_buttonDevCmdMQPush_Click(object sender, EventArgs e)
        {
            //push oCmdInMQ1
            var oCmdInMQ1 = new DevCmdDemo()
            {
                Id = 0,
                Type = "Type0"
            };
            DevCmdMQ.getInstance().push(oCmdInMQ1);

            //push oCmdInMQ2
            var oCmdInMQ2 = new DevCmdDemo()
            {
                Id = 1,
                Type = "Type1"
            };
            DevCmdMQ.getInstance().push(oCmdInMQ2);
        }

        #endregion

        #region dec_hex

        private void m_buttonDecHex_Click(object sender, EventArgs e)
        {
            var iDec = Convert.ToInt32(this.m_textBoxDec.Text);
            var strRes = NegativeToHexString(iDec);
            this.m_textBoxHex.Text = strRes;
        }

        /// <summary>
        /// 负数转十六进制
        /// </summary>
        /// <param name="iNumber"></param>
        /// <returns></returns>
        private string NegativeToHexString(int iNumber)
        {
            //string strResult = string.Empty;
            //if (iNumber < 0)
            //{
            //    iNumber = -iNumber;
            //    string strNegate = string.Empty;
            //    char[] binChar = Convert.ToString(iNumber, 2).PadLeft(8, '0').ToArray();
            //    foreach (char ch in binChar)
            //    {
            //        if (Convert.ToInt32(ch) == 48)
            //        {
            //            strNegate += "1";
            //        }
            //        else
            //        {
            //            strNegate += "0";
            //        }
            //    }

            //    int iComplement = Convert.ToInt32(strNegate, 2) + 1;
            //    strResult = Convert.ToString(iComplement, 16).ToUpper();
            //}
            //return strResult;
            string strResult = Convert.ToString(Convert.ToInt32(iNumber.ToString("X8"), 16));
            return strResult;
        }

        #endregion

        #region crc

        private void m_buttonCrcSmall_Click(object sender, EventArgs e)
        {
            var strReq = this.m_textBoxCrcSourceReq.Text;
            var arrReq = ByteUtilsEx.hexPadStr2HexPadArr(strReq);
            var arrCrcRes = CrcUtils.UDPModbusRtuCRC(arrReq.ToArray(), true);
            var strCrcRes = String.Join("", arrCrcRes);
            this.m_textBoxCrcRes.Text = strCrcRes;
        }

        private void m_buttonCrcBig_Click(object sender, EventArgs e)
        {
            var strReq = this.m_textBoxCrcSourceReq.Text;
            var arrReq = ByteUtilsEx.hexPadStr2HexPadArr(strReq);
            var arrCrcRes = CrcUtils.UDPModbusRtuCRC(arrReq.ToArray(), false);
            var strCrcRes = String.Join("", arrCrcRes);
            this.m_textBoxCrcRes.Text = strCrcRes;
        }

        #endregion

        #region lan

        private void _lanInit()
        {
            this.m_labelLanTip.Text = I18nUtilsEx.getStrFromApp("lan");
            this.m_comboBoxLan.SelectedItem = I18nUtilsEx.getLanName();
        }

        private void m_comboBoxLan_SelectedIndexChanged(object sender, EventArgs e)
        {
            //var strLan = I18nUtilsEx.getLanName();
            //var strSelect = (string)this.m_comboBoxLan.SelectedItem;
            //if (strSelect != strLan)
            //{
            //    I18nUtilsEx.setLanNameEx(strSelect);
            //}
            var strSelect = (string)this.m_comboBoxLan.SelectedItem;
            I18nUtilsEx.setLanNameEx(strSelect);
        }

        private void m_buttonLan_Click(object sender, EventArgs e)
        {
            Task.Run(() =>
            {
                new LanForm().ShowDialog();
            });
        }
        #endregion
    }
}
