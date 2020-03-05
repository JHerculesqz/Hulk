using core_fw.component.ds.id;
using core_fw.component.thread.timer;
using System;
using System.Diagnostics;
using System.Drawing;
using System.Threading;
using System.Windows.Forms;
using walle.widget.form;

namespace test_core_fw_spring_express.widget.warn
{
    public partial class TestWarnPanel2 : UserControl
    {
        public TestWarnPanel2()
        {
            InitializeComponent();

            this.DoubleBuffered = true;//设置本窗体
            SetStyle(ControlStyles.UserPaint, true);
            SetStyle(ControlStyles.AllPaintingInWmPaint, true); // 禁止擦除背景.
            SetStyle(ControlStyles.DoubleBuffer, true); // 双缓冲

            _init();
        }
        private void _init()
        {
            var o = new Stopwatch();
            o.Start();
            for (int i = 0; i < 50; i++)
            {
                var oLabel = new Label();
                oLabel.Name = "label" + i;
                oLabel.Text = "label" + i;
                oLabel.Location = new Point(10, 20 * i);
                this.Controls.Add(oLabel);

                var oTextBox = new TextBox();
                oTextBox.Name = "name" + i;
                oTextBox.Text = "text" + i;
                oTextBox.Location = new Point(50, 20 * i);
                this.Controls.Add(oTextBox);
            }
            o.Stop();
            Console.WriteLine("TEXT:" + o.ElapsedMilliseconds);
            o.Start();
            for (int i = 50; i < 100; i++)
            {
                var oCombo = new ComboBox();
                oCombo.Name = "name" + i;
                oCombo.Text = "1";
                oCombo.Items.Add("1");
                oCombo.Items.Add("2");
                oCombo.Items.Add("3");
                oCombo.Location = new Point(10, 20 * i);
                this.Controls.Add(oCombo);
            }
            o.Stop();
            Console.WriteLine("COMBO:" + o.ElapsedMilliseconds);

            var oSchedulerUtils = new SchedulerUtils();
            oSchedulerUtils.startAsync(100, 100, false, () =>
            {
                FormUtilsEx.invoke4Control(this, () =>
                {
                    var o1 = new Stopwatch();
                    o1.Start();
                    for (int i = 0; i < 50; i++)
                    {
                        var oTextBox = this.Controls.Find("name" + i, false)[0];
                        oTextBox.Text = IDUtilsEx.gen();
                    }
                    o1.Stop();
                    Console.WriteLine("REFRESH:" + o1.ElapsedMilliseconds);
                });
            });

            var oSchedulerUtils2 = new SchedulerUtils();
            oSchedulerUtils2.startAsync(100, 100, false, () =>
            {
                FormUtilsEx.invoke4Control(this, () =>
                {
                    this.simpleButton1.Text = IDUtilsEx.gen();
                });
            });
        }
        private void button1_Click(object sender, EventArgs e)
        {
            if (this.button1.Text == "a")
            {
                this.button1.Text = "b";
            }
            else
            {
                this.button1.Text = "a";
            }
        }

        private void simpleButton1_Click(object sender, EventArgs e)
        {
            if (this.simpleButton1.Text == "a")
            {
                this.simpleButton1.Text = "b";
            }
            else
            {
                this.simpleButton1.Text = "a";
            }
        }
    }
}
