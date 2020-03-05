using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using core_fw.component.io.udp.client;
using System.Threading;
using core_fw.component.io.udp;
using core_fw.component.ds.byteEx;
using System.Net.Sockets;
using System.Net;
using core_fw.component.io.udp.server;
using core_fw.component.ds.id;
using core_fw.component.io.mq.retry;
using core_fw.component.io.mq.retry.vo;
using walle.component.date;

namespace test_core_fw.component.io.udp
{
    public partial class UDPDemo : UserControl
    {
        #region Const

        private static String IP_REMOTE = "127.0.0.1";
        private static int PORT_REMOTE = 501;
        private static String IP_LOCAL = "127.0.0.1";
        private static int PORT_LOCAL_SEND = 500;
        private static int PORT_LOCAL_RECV = 502;

        #endregion

        #region Fields

        private UDPClientUtils m_oUDPClientUtils = new UDPClientUtils();
        private UDPServerUtils m_oUDPServerUtils = new UDPServerUtils();

        private RetryMQ m_oRetryMQ = new RetryMQ();

        #endregion

        #region Construction

        public UDPDemo()
        {
            InitializeComponent();
        }

        #endregion

        #region client.init

        private void m_buttonInit4Client_Click(object sender, EventArgs e)
        {
            //var strIPLocal = this.m_textBoxIP4Send.Text;
            //var iPortLocal4Send = Convert.ToInt32(this.m_textBoxPort4Send.Text);
            //this.m_oUDPClientUtils.init(strIPLocal, iPortLocal4Send);
            //MessageBox.Show("init ok...");
            MessageBox.Show("deprecated...");
        }

        #endregion

        #region client.destroy

        private void m_buttonDestroy4Client_Click(object sender, EventArgs e)
        {
            //this.m_oUDPClientUtils.destroy();
            //MessageBox.Show("destroy ok...");
            MessageBox.Show("deprecated...");
        }

        #endregion

        #region client.sendAsync

        private void m_buttonSendAsync4Client_Click(object sender, EventArgs e)
        {
            var strIPRemote = this.m_textBoxIPRemote4Send.Text;
            var iPortRemote = Convert.ToInt32(this.m_textBoxPortRemote4Send.Text);
            var strMsg = this.m_textBoxSendAsync4Client.Text;
            byte[] arrMsg = ByteUtilsEx.aciiToDefaultEncodeByteArr(strMsg);
            this.m_oUDPClientUtils.sendAsync2(strIPRemote, iPortRemote, arrMsg,
                (arrByte) =>
                {
                    var strRes = ByteUtilsEx.defaultEncodeByteArrToAciiStr(arrByte);
                    Console.WriteLine("[UDPClientUtils]" + strRes);
                },
                (strErrMsg) =>
                {
                    Console.WriteLine(strErrMsg);
                },
                (strErrMsg) =>
                {
                    Console.WriteLine(strErrMsg);
                });
        }

        #endregion

        #region client.parallelTest

        private void m_buttonParallelTest4Client_Click(object sender, EventArgs e)
        {
            Task.Run(() =>
            {
                var strIPRemote = this.m_textBoxIPRemote4Send.Text;
                var iPortRemote = Convert.ToInt32(this.m_textBoxPortRemote4Send.Text);
                var strMsg = this.m_textBoxSendAsync4Client.Text;
                byte[] arrMsg = ByteUtilsEx.aciiToDefaultEncodeByteArr(strMsg);
                var iCount = Convert.ToInt32(this.m_textBoxParallelTest4Client.Text);
                Parallel.For(0, iCount, item =>
                {
                    this.m_oUDPClientUtils.sendAsync2(strIPRemote, iPortRemote, arrMsg,
                        (arrByte) =>
                        {
                            var strRes = ByteUtilsEx.defaultEncodeByteArrToAciiStr(arrByte);
                            Console.WriteLine("[UDPClientUtils]" + strRes);
                        },
                        (strErrMsg) =>
                        {
                            Console.WriteLine(strErrMsg);
                        },
                        (strErrMsg) =>
                        {
                            Console.WriteLine(strErrMsg);
                        });
                });
            });
        }

        #endregion

        #region client.retryMQTest

        private void m_buttonRetryMQInit_Click(object sender, EventArgs e)
        {
            this.m_oRetryMQ.init();
            MessageBox.Show("init ok");
        }

        private void m_buttonRetryMQTest_Click(object sender, EventArgs e)
        {
            Task.Run(() =>
            {
                var iCount = Convert.ToInt64(this.m_textBoxRetryMQTest.Text);
                Parallel.For(0, iCount, (iIndex) =>
                {
                    //invokeDoSth
                    var strIPRemote = this.m_textBoxIPRemote4Send.Text;
                    var iPortRemote = Convert.ToInt32(this.m_textBoxPortRemote4Send.Text);
                    var iMsgID = IDUtilsEx.getInstance().newIdEx();
                    var strMsgName = "name" + iMsgID;
                    var oTaskInput = iMsgID.ToString();
                    byte[] arrTaskInput = ByteUtilsEx.aciiToDefaultEncodeByteArr(oTaskInput);
                    this.m_oRetryMQ.add(iMsgID, strMsgName, oTaskInput, () =>
                    {
                        this.m_oUDPClientUtils.sendAsync2(strIPRemote, iPortRemote, arrTaskInput,
                            (arrByte) =>
                            {
                                //invokeDoSthFinish
                                var iMsgIDResp = Convert.ToInt64(ByteUtilsEx.defaultEncodeByteArrToAciiStr(arrByte));
                                this.m_oRetryMQ.update(iMsgIDResp,
                                    (oMsgVo) =>
                                    {
                                        var oTaskOutput = ByteUtilsEx.defaultEncodeByteArrToAciiStr(arrByte);
                                        var oOutVo = new GenTaskOutputCallbackOutVo()
                                        {
                                            IsOK = true,
                                            taskOutput = oTaskOutput
                                        };
                                        return oOutVo;
                                    },
                                    (oMsgVoUpdate)=>
                                    {
                                        Console.WriteLine("update ui...");
                                    });
                            },
                            (strErrMsg) =>
                            {
                                throw new Exception(strErrMsg);
                            },
                            (strErrMsg) =>
                            {
                                throw new Exception(strErrMsg);
                            });
                    });
                });
            });
        }

        private void m_buttonRetryMQTestDebug_Click(object sender, EventArgs e)
        {
            this.m_oRetryMQ.debugShow();
        }

        #endregion

        #region server.init

        private void m_buttonInit4Server_Click(object sender, EventArgs e)
        {
            var strIPLocal = this.m_textBoxIP4Server.Text;
            var iPortLocal4Recv = Convert.ToInt32(this.m_textBoxPort4Server.Text);
            this.m_oUDPServerUtils.init(strIPLocal, iPortLocal4Recv,
                (strMsg) =>
                {
                    Console.WriteLine("[UDPServerUtils]" + strMsg);
                    return strMsg;
                },
                (strErrMsg) =>
                {
                    Console.WriteLine(strErrMsg);
                });
            MessageBox.Show("init ok...");
        }

        #endregion

        #region server.destroy

        private void m_buttonKill4Server_Click(object sender, EventArgs e)
        {
            this.m_oUDPServerUtils.destroy();
            MessageBox.Show("destroy ok...");
        }

        #endregion
    }
}
