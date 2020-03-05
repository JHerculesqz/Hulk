namespace test_core_fw_spring_express
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.m_xtraTabControl = new DevExpress.XtraTab.XtraTabControl();
            this.xtraTabPage1 = new DevExpress.XtraTab.XtraTabPage();
            this.testWarnPanel21 = new test_core_fw_spring_express.widget.warn.TestWarnPanel2();
            this.m_xtraTabPageWarn = new DevExpress.XtraTab.XtraTabPage();
            this.m_warnPanel = new test_core_fw_spring_express.widget.warn.TestWarnPanel();
            this.xtraTabPage2 = new DevExpress.XtraTab.XtraTabPage();
            this.systemLogPanel1 = new test_core_fw_spring_express.widget.log.SystemLogPanel();
            ((System.ComponentModel.ISupportInitialize)(this.m_xtraTabControl)).BeginInit();
            this.m_xtraTabControl.SuspendLayout();
            this.xtraTabPage1.SuspendLayout();
            this.m_xtraTabPageWarn.SuspendLayout();
            this.xtraTabPage2.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_xtraTabControl
            // 
            this.m_xtraTabControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.m_xtraTabControl.Location = new System.Drawing.Point(0, 0);
            this.m_xtraTabControl.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_xtraTabControl.Name = "m_xtraTabControl";
            this.m_xtraTabControl.SelectedTabPage = this.xtraTabPage1;
            this.m_xtraTabControl.Size = new System.Drawing.Size(1026, 396);
            this.m_xtraTabControl.TabIndex = 0;
            this.m_xtraTabControl.TabPages.AddRange(new DevExpress.XtraTab.XtraTabPage[] {
            this.m_xtraTabPageWarn,
            this.xtraTabPage1,
            this.xtraTabPage2});
            // 
            // xtraTabPage1
            // 
            this.xtraTabPage1.Controls.Add(this.testWarnPanel21);
            this.xtraTabPage1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.xtraTabPage1.Name = "xtraTabPage1";
            this.xtraTabPage1.Size = new System.Drawing.Size(1020, 367);
            this.xtraTabPage1.Text = "xtraTabPage1";
            // 
            // testWarnPanel21
            // 
            this.testWarnPanel21.AutoScroll = true;
            this.testWarnPanel21.Dock = System.Windows.Forms.DockStyle.Fill;
            this.testWarnPanel21.Location = new System.Drawing.Point(0, 0);
            this.testWarnPanel21.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.testWarnPanel21.Name = "testWarnPanel21";
            this.testWarnPanel21.Size = new System.Drawing.Size(1020, 367);
            this.testWarnPanel21.TabIndex = 0;
            // 
            // m_xtraTabPageWarn
            // 
            this.m_xtraTabPageWarn.Controls.Add(this.m_warnPanel);
            this.m_xtraTabPageWarn.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_xtraTabPageWarn.Name = "m_xtraTabPageWarn";
            this.m_xtraTabPageWarn.Size = new System.Drawing.Size(1020, 367);
            this.m_xtraTabPageWarn.Text = "Warn";
            // 
            // m_warnPanel
            // 
            this.m_warnPanel.Dock = System.Windows.Forms.DockStyle.Fill;
            this.m_warnPanel.Location = new System.Drawing.Point(0, 0);
            this.m_warnPanel.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_warnPanel.Name = "m_warnPanel";
            this.m_warnPanel.Size = new System.Drawing.Size(1020, 367);
            this.m_warnPanel.TabIndex = 0;
            // 
            // xtraTabPage2
            // 
            this.xtraTabPage2.Controls.Add(this.systemLogPanel1);
            this.xtraTabPage2.Name = "xtraTabPage2";
            this.xtraTabPage2.Size = new System.Drawing.Size(1020, 367);
            this.xtraTabPage2.Text = "xtraTabPage2";
            // 
            // systemLogPanel1
            // 
            this.systemLogPanel1.Location = new System.Drawing.Point(11, 12);
            this.systemLogPanel1.Name = "systemLogPanel1";
            this.systemLogPanel1.Size = new System.Drawing.Size(383, 184);
            this.systemLogPanel1.TabIndex = 0;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1026, 396);
            this.Controls.Add(this.m_xtraTabControl);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "MainForm";
            this.Text = "MainForm";
            ((System.ComponentModel.ISupportInitialize)(this.m_xtraTabControl)).EndInit();
            this.m_xtraTabControl.ResumeLayout(false);
            this.xtraTabPage1.ResumeLayout(false);
            this.m_xtraTabPageWarn.ResumeLayout(false);
            this.xtraTabPage2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private DevExpress.XtraTab.XtraTabControl m_xtraTabControl;
        private DevExpress.XtraTab.XtraTabPage m_xtraTabPageWarn;
        private widget.warn.TestWarnPanel m_warnPanel;
        private DevExpress.XtraTab.XtraTabPage xtraTabPage1;
        private widget.warn.TestWarnPanel2 testWarnPanel21;
        private DevExpress.XtraTab.XtraTabPage xtraTabPage2;
        private widget.log.SystemLogPanel systemLogPanel1;
    }
}