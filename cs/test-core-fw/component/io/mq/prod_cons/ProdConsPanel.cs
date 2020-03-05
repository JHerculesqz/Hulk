using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using core_fw.component.io.mq.prod_cons;
using System.Threading;

namespace test_core_fw.component.io.mq.prod_cons
{
    public partial class ProdConsPanel : UserControl
    {
        #region Fields

        private ProdConsMQ<string> m_oMQ = new ProdConsMQ<string>();
        private ProdConsMQ2<string> m_oMQ2 = new ProdConsMQ2<string>();

        #endregion

        #region Construction

        public ProdConsPanel()
        {
            InitializeComponent();
        }

        #endregion

        #region MQ

        private void m_buttonProduct_Click(object sender, EventArgs e)
        {
            var iCount = Convert.ToInt32(this.m_textBoxProdctCount.Text);
            for (int i = 0; i < iCount; i++)
            {
                this.m_oMQ.product("产品" + i,
                    (strProduct) =>
                    {
                        Console.WriteLine("[生产线程]" + strProduct);
                        Thread.Sleep(1000);
                    });
            }
        }

        private void m_buttonConsumerStart_Click(object sender, EventArgs e)
        {
            this.m_oMQ.consumerStart((strProduct) =>
            {
                Console.WriteLine("[消费线程]" + strProduct);
                Thread.Sleep(1000);
            });
        }

        private void m_buttonConsumerPause_Click(object sender, EventArgs e)
        {
            this.m_oMQ.consumerPause();
        }

        private void m_buttonConsumerResume_Click(object sender, EventArgs e)
        {
            this.m_oMQ.consumerResume();
        }

        private void m_buttonConsumerStop_Click(object sender, EventArgs e)
        {
            this.m_oMQ.consumerStop();
        }

        #endregion

        #region MQ2

        private void m_buttonProduct2_Click(object sender, EventArgs e)
        {
            var iCount = Convert.ToInt32(this.m_textBoxProdctCount2.Text);
            for (int i = 0; i < iCount; i++)
            {
                this.m_oMQ2.product(i, "产品" + i,
                    (iIndex, strProduct) =>
                    {
                        this.m_textBoxProduct.Text += "[生产线程]" + strProduct + Environment.NewLine;
                        Thread.Sleep(10);
                    },
                    (iIndex, strProduct) =>
                    {
                        this.m_textBoxProduct.Text += "[生产线程]fail..." + strProduct + Environment.NewLine;
                    });
            }
        }

        private void m_buttonConsumerStart2_Click(object sender, EventArgs e)
        {
            this.m_oMQ2.consumerStart((strProduct) =>
            {
                this.m_textBoxConsumer.Text += "[消费线程]" + strProduct + Environment.NewLine;
                Thread.Sleep(1000);
            },
            (strProduct) =>
            {
                //this.m_textBoxConsumer.Text += "[消费线程]fail..." + strProduct + Environment.NewLine;
            });
        }

        private void m_buttonConsumerPause2_Click(object sender, EventArgs e)
        {
            this.m_oMQ2.consumerPause();
        }

        private void m_buttonConsumerResume2_Click(object sender, EventArgs e)
        {
            this.m_oMQ2.consumerResume();
        }

        private void m_buttonConsumerStop2_Click(object sender, EventArgs e)
        {
            this.m_oMQ2.consumerStop();
        }

        #endregion
    }
}
