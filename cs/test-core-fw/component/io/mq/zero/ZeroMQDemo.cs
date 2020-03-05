using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using core_fw.component.io.mq.zero;
using System.IO;

namespace test_core_fw.component.io.mq.zero
{
    public partial class ZeroMQDemo : UserControl
    {
        #region Const

        #endregion

        #region Fields

        private ZeroMQUtils m_oZeroMQUtils4Server = new ZeroMQUtils();
        private ZeroMQUtils m_oZeroMQUtils4Client = new ZeroMQUtils();
        private ZeroMQUtils m_oZeroMQUtils4ClientLazy = new ZeroMQUtils();

        #endregion

        #region Construction

        public ZeroMQDemo()
        {
            InitializeComponent();
        }

        #endregion

        #region init

        private void m_buttonZeroMQInit4Server_Click(object sender, EventArgs e)
        {
            //var strConnStrSend = this.m_textBoxZeroMQConnStrSend4Server.Text;
            //var strConnStrRecv = this.m_textBoxZeroMQConnStrRecv4Server.Text;
            //this.m_oZeroMQUtils4Server.init(strConnStrSend, strConnStrRecv);
            //this.m_oZeroMQUtils4Server.listen((strMsg) =>
            //{
            //    var strRes = "[Server]" + strMsg;
            //    Console.WriteLine(strRes);
            //    return strRes;
            //});
        }

        private void m_buttonZeroMQInit4Client_Click(object sender, EventArgs e)
        {
            var strConnStrSend = this.m_textBoxZeroMQConnStrSend4Client.Text;
            var strConnStrRecv = this.m_textBoxZeroMQConnStrRecv4Client.Text;
            //this.m_oZeroMQUtils4Client.init(strConnStrSend, strConnStrRecv);
            this.m_oZeroMQUtils4Client.listen((strMsg) =>
            {
                var strRes = "[Client]" + strMsg;
                return strRes;
            });
        }

        #endregion

        #region send

        private void m_buttonZeroMQSend4Client_Click(object sender, EventArgs e)
        {
            var strMsg = this.m_textBoxZeroMQSend4Client.Text;
            var strMsgRecv = this.m_oZeroMQUtils4Client.send(strMsg);
            this.m_textBoxZeroMQSendResp4Client.Text += strMsgRecv +
                Environment.NewLine;
        }

        #endregion

        #region close

        private void m_buttonZeroMQDestroy4Server_Click(object sender, EventArgs e)
        {
            this.m_oZeroMQUtils4Server.destroy();
        }

        private void m_buttonZeroMQDestroy4Client_Click(object sender, EventArgs e)
        {
            this.m_oZeroMQUtils4Client.destroy();
        }

        #endregion

        #region initLazy

        private void m_buttonZeroMQInit4ClientLazy_Click(object sender, EventArgs e)
        {
            var strFilePath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory,
                @"data\zmq\test-core-fw-zmq");
            //this.m_oZeroMQUtils4ClientLazy.initLazy(strFilePath, "",
            //    this.m_textBoxZeroMQConnStrSend4ClientLazy.Text,
            //    this.m_textBoxZeroMQConnStrRecv4ClientLazy.Text,
            //    "heart beat",
            //    (strRecvMsg) =>
            //    {
            //        Console.WriteLine("[Client]recv " + strRecvMsg);
            //        return "";
            //    });
        }

        private void m_buttonZeroMQDestroy4ClientLazy_Click(object sender, EventArgs e)
        {
            this.m_oZeroMQUtils4ClientLazy.destroy();
        }

        private void m_buttonZeroMQSend4ClientLazy_Click(object sender, EventArgs e)
        {
            var strRecvMsg = this.m_oZeroMQUtils4ClientLazy.send(
                this.m_textBoxZeroMQSend4ClientLazy.Text);
            this.m_textBoxZeroMQSendResp4ClientLazy.Text += strRecvMsg +
                Environment.NewLine;
        }

        #endregion
    }
}
