using System;

namespace test_core_fw
{
    partial class MainForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.udpDemo1 = new test_core_fw.component.io.udp.UDPDemo();
            this.m_groupBoxDevCmdMQ = new System.Windows.Forms.GroupBox();
            this.m_buttonDevCmdMQInit = new System.Windows.Forms.Button();
            this.m_buttonDevCmdMQPush = new System.Windows.Forms.Button();
            this.m_buttonPropertyGrid = new System.Windows.Forms.Button();
            this.m_buttonLombokBase = new System.Windows.Forms.Button();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.m_comboBoxLan = new System.Windows.Forms.ComboBox();
            this.m_buttonLan = new System.Windows.Forms.Button();
            this.m_labelLanTip = new System.Windows.Forms.Label();
            this.m_groupBoxCrc = new System.Windows.Forms.GroupBox();
            this.m_textBoxCrcSourceReq = new System.Windows.Forms.TextBox();
            this.m_buttonCrcBig = new System.Windows.Forms.Button();
            this.m_textBoxCrcRes = new System.Windows.Forms.TextBox();
            this.m_buttonCrcSmall = new System.Windows.Forms.Button();
            this.m_textBoxHex = new System.Windows.Forms.TextBox();
            this.m_buttonDecHex = new System.Windows.Forms.Button();
            this.m_textBoxDec = new System.Windows.Forms.TextBox();
            this.tabPage5 = new System.Windows.Forms.TabPage();
            this.usbDemo1 = new test_core_fw.component.io.usb.UsbDemo();
            this.tabPage6 = new System.Windows.Forms.TabPage();
            this.gridControl1 = new test_core_fw.widget.grid.GridControl();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.m_groupBoxDevCmdMQ.SuspendLayout();
            this.tabPage4.SuspendLayout();
            this.m_groupBoxCrc.SuspendLayout();
            this.tabPage5.SuspendLayout();
            this.tabPage6.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Controls.Add(this.tabPage4);
            this.tabControl1.Controls.Add(this.tabPage5);
            this.tabControl1.Controls.Add(this.tabPage6);
            resources.ApplyResources(this.tabControl1, "tabControl1");
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.udpDemo1);
            this.tabPage1.Controls.Add(this.m_groupBoxDevCmdMQ);
            this.tabPage1.Controls.Add(this.m_buttonPropertyGrid);
            this.tabPage1.Controls.Add(this.m_buttonLombokBase);
            resources.ApplyResources(this.tabPage1, "tabPage1");
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // udpDemo1
            // 
            resources.ApplyResources(this.udpDemo1, "udpDemo1");
            this.udpDemo1.Name = "udpDemo1";
            // 
            // m_groupBoxDevCmdMQ
            // 
            this.m_groupBoxDevCmdMQ.Controls.Add(this.m_buttonDevCmdMQInit);
            this.m_groupBoxDevCmdMQ.Controls.Add(this.m_buttonDevCmdMQPush);
            resources.ApplyResources(this.m_groupBoxDevCmdMQ, "m_groupBoxDevCmdMQ");
            this.m_groupBoxDevCmdMQ.Name = "m_groupBoxDevCmdMQ";
            this.m_groupBoxDevCmdMQ.TabStop = false;
            // 
            // m_buttonDevCmdMQInit
            // 
            resources.ApplyResources(this.m_buttonDevCmdMQInit, "m_buttonDevCmdMQInit");
            this.m_buttonDevCmdMQInit.Name = "m_buttonDevCmdMQInit";
            this.m_buttonDevCmdMQInit.UseVisualStyleBackColor = true;
            // 
            // m_buttonDevCmdMQPush
            // 
            resources.ApplyResources(this.m_buttonDevCmdMQPush, "m_buttonDevCmdMQPush");
            this.m_buttonDevCmdMQPush.Name = "m_buttonDevCmdMQPush";
            this.m_buttonDevCmdMQPush.UseVisualStyleBackColor = true;
            // 
            // m_buttonPropertyGrid
            // 
            resources.ApplyResources(this.m_buttonPropertyGrid, "m_buttonPropertyGrid");
            this.m_buttonPropertyGrid.Name = "m_buttonPropertyGrid";
            this.m_buttonPropertyGrid.UseVisualStyleBackColor = true;
            // 
            // m_buttonLombokBase
            // 
            resources.ApplyResources(this.m_buttonLombokBase, "m_buttonLombokBase");
            this.m_buttonLombokBase.Name = "m_buttonLombokBase";
            this.m_buttonLombokBase.UseVisualStyleBackColor = true;
            // 
            // tabPage2
            // 
            resources.ApplyResources(this.tabPage2, "tabPage2");
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // tabPage3
            // 
            resources.ApplyResources(this.tabPage3, "tabPage3");
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.m_comboBoxLan);
            this.tabPage4.Controls.Add(this.m_buttonLan);
            this.tabPage4.Controls.Add(this.m_labelLanTip);
            this.tabPage4.Controls.Add(this.m_groupBoxCrc);
            this.tabPage4.Controls.Add(this.m_textBoxHex);
            this.tabPage4.Controls.Add(this.m_buttonDecHex);
            this.tabPage4.Controls.Add(this.m_textBoxDec);
            resources.ApplyResources(this.tabPage4, "tabPage4");
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.UseVisualStyleBackColor = true;
            // 
            // m_comboBoxLan
            // 
            this.m_comboBoxLan.FormattingEnabled = true;
            this.m_comboBoxLan.Items.AddRange(new object[] {
            resources.GetString("m_comboBoxLan.Items"),
            resources.GetString("m_comboBoxLan.Items1")});
            resources.ApplyResources(this.m_comboBoxLan, "m_comboBoxLan");
            this.m_comboBoxLan.Name = "m_comboBoxLan";
            this.m_comboBoxLan.SelectedIndexChanged += new System.EventHandler(this.m_comboBoxLan_SelectedIndexChanged);
            // 
            // m_buttonLan
            // 
            resources.ApplyResources(this.m_buttonLan, "m_buttonLan");
            this.m_buttonLan.Name = "m_buttonLan";
            this.m_buttonLan.UseVisualStyleBackColor = true;
            this.m_buttonLan.Click += new System.EventHandler(this.m_buttonLan_Click);
            // 
            // m_labelLanTip
            // 
            resources.ApplyResources(this.m_labelLanTip, "m_labelLanTip");
            this.m_labelLanTip.Name = "m_labelLanTip";
            // 
            // m_groupBoxCrc
            // 
            this.m_groupBoxCrc.Controls.Add(this.m_textBoxCrcSourceReq);
            this.m_groupBoxCrc.Controls.Add(this.m_buttonCrcBig);
            this.m_groupBoxCrc.Controls.Add(this.m_textBoxCrcRes);
            this.m_groupBoxCrc.Controls.Add(this.m_buttonCrcSmall);
            resources.ApplyResources(this.m_groupBoxCrc, "m_groupBoxCrc");
            this.m_groupBoxCrc.Name = "m_groupBoxCrc";
            this.m_groupBoxCrc.TabStop = false;
            // 
            // m_textBoxCrcSourceReq
            // 
            resources.ApplyResources(this.m_textBoxCrcSourceReq, "m_textBoxCrcSourceReq");
            this.m_textBoxCrcSourceReq.Name = "m_textBoxCrcSourceReq";
            // 
            // m_buttonCrcBig
            // 
            resources.ApplyResources(this.m_buttonCrcBig, "m_buttonCrcBig");
            this.m_buttonCrcBig.Name = "m_buttonCrcBig";
            this.m_buttonCrcBig.UseVisualStyleBackColor = true;
            this.m_buttonCrcBig.Click += new System.EventHandler(this.m_buttonCrcBig_Click);
            // 
            // m_textBoxCrcRes
            // 
            resources.ApplyResources(this.m_textBoxCrcRes, "m_textBoxCrcRes");
            this.m_textBoxCrcRes.Name = "m_textBoxCrcRes";
            // 
            // m_buttonCrcSmall
            // 
            resources.ApplyResources(this.m_buttonCrcSmall, "m_buttonCrcSmall");
            this.m_buttonCrcSmall.Name = "m_buttonCrcSmall";
            this.m_buttonCrcSmall.UseVisualStyleBackColor = true;
            this.m_buttonCrcSmall.Click += new System.EventHandler(this.m_buttonCrcSmall_Click);
            // 
            // m_textBoxHex
            // 
            resources.ApplyResources(this.m_textBoxHex, "m_textBoxHex");
            this.m_textBoxHex.Name = "m_textBoxHex";
            // 
            // m_buttonDecHex
            // 
            resources.ApplyResources(this.m_buttonDecHex, "m_buttonDecHex");
            this.m_buttonDecHex.Name = "m_buttonDecHex";
            this.m_buttonDecHex.UseVisualStyleBackColor = true;
            this.m_buttonDecHex.Click += new System.EventHandler(this.m_buttonDecHex_Click);
            // 
            // m_textBoxDec
            // 
            resources.ApplyResources(this.m_textBoxDec, "m_textBoxDec");
            this.m_textBoxDec.Name = "m_textBoxDec";
            // 
            // tabPage5
            // 
            this.tabPage5.Controls.Add(this.usbDemo1);
            resources.ApplyResources(this.tabPage5, "tabPage5");
            this.tabPage5.Name = "tabPage5";
            this.tabPage5.UseVisualStyleBackColor = true;
            // 
            // usbDemo1
            // 
            resources.ApplyResources(this.usbDemo1, "usbDemo1");
            this.usbDemo1.Name = "usbDemo1";
            // 
            // tabPage6
            // 
            this.tabPage6.Controls.Add(this.gridControl1);
            resources.ApplyResources(this.tabPage6, "tabPage6");
            this.tabPage6.Name = "tabPage6";
            this.tabPage6.UseVisualStyleBackColor = true;
            // 
            // gridControl1
            // 
            resources.ApplyResources(this.gridControl1, "gridControl1");
            this.gridControl1.Name = "gridControl1";
            // 
            // MainForm
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.tabControl1);
            this.Name = "MainForm";
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.m_groupBoxDevCmdMQ.ResumeLayout(false);
            this.tabPage4.ResumeLayout(false);
            this.tabPage4.PerformLayout();
            this.m_groupBoxCrc.ResumeLayout(false);
            this.m_groupBoxCrc.PerformLayout();
            this.tabPage5.ResumeLayout(false);
            this.tabPage6.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.GroupBox m_groupBoxDevCmdMQ;
        private System.Windows.Forms.Button m_buttonDevCmdMQInit;
        private System.Windows.Forms.Button m_buttonDevCmdMQPush;
        private System.Windows.Forms.Button m_buttonPropertyGrid;
        private System.Windows.Forms.Button m_buttonLombokBase;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.Button m_buttonDecHex;
        private System.Windows.Forms.TextBox m_textBoxDec;
        private System.Windows.Forms.TextBox m_textBoxHex;
        private component.io.udp.UDPDemo udpDemo1;
        private System.Windows.Forms.GroupBox m_groupBoxCrc;
        private System.Windows.Forms.TextBox m_textBoxCrcSourceReq;
        private System.Windows.Forms.Button m_buttonCrcBig;
        private System.Windows.Forms.TextBox m_textBoxCrcRes;
        private System.Windows.Forms.Button m_buttonCrcSmall;
        private System.Windows.Forms.TabPage tabPage5;
        private component.io.usb.UsbDemo usbDemo1;
        private System.Windows.Forms.Label m_labelLanTip;
        private System.Windows.Forms.Button m_buttonLan;
        private System.Windows.Forms.ComboBox m_comboBoxLan;
        private System.Windows.Forms.TabPage tabPage6;
        private widget.grid.GridControl gridControl1;
    }
}

