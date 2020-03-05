using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using core_fw.component.io.usb;

namespace test_core_fw.component.io.usb
{
    public partial class UsbDemo : UserControl
    {
        public UsbDemo()
        {
            InitializeComponent();
            CheckForIllegalCrossThreadCalls = false;
            UsbUtils hUSB = new UsbUtils(0x1000, 0x2016, DataReceived);
        }
        private void DataReceived(int key)
        {
            StringBuilder sb = new StringBuilder();
            sb.Append(" 键值:");
            for (int i = 0; i < 32; i++)
            {
                if ((key & 0x0001 << i) != 0)
                {
                    sb.Append(i + 1);
                }
            }
            sb.Append(Environment.NewLine);
            richTextBox1.AppendText(sb.ToString());
        }
    }
}
