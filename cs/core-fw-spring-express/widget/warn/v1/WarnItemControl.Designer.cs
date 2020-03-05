namespace core_fw_spring_express.widget.warn
{
    partial class WarnItemControl
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            DevExpress.XtraBars.Docking2010.WindowsUIButtonImageOptions windowsUIButtonImageOptions1 = new DevExpress.XtraBars.Docking2010.WindowsUIButtonImageOptions();
            this.m_labelControlMsg = new DevExpress.XtraEditors.LabelControl();
            this.m_winUIButtonStatus = new DevExpress.XtraBars.Docking2010.WindowsUIButtonPanel();
            this.m_panelControl = new DevExpress.XtraEditors.PanelControl();
            ((System.ComponentModel.ISupportInitialize)(this.m_panelControl)).BeginInit();
            this.SuspendLayout();
            // 
            // m_labelControlMsg
            // 
            this.m_labelControlMsg.Location = new System.Drawing.Point(14, 75);
            this.m_labelControlMsg.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_labelControlMsg.Name = "m_labelControlMsg";
            this.m_labelControlMsg.Size = new System.Drawing.Size(50, 14);
            this.m_labelControlMsg.TabIndex = 1;
            this.m_labelControlMsg.Text = "WarnMsg";
            // 
            // m_winUIButtonStatus
            // 
            this.m_winUIButtonStatus.Buttons.AddRange(new DevExpress.XtraEditors.ButtonPanel.IBaseButton[] {
            new DevExpress.XtraBars.Docking2010.WindowsUIButton("NAME", true, windowsUIButtonImageOptions1, DevExpress.XtraBars.Docking2010.ButtonStyle.PushButton, "", -1, true, null, true, false, true, null, -1, false)});
            this.m_winUIButtonStatus.Location = new System.Drawing.Point(14, 8);
            this.m_winUIButtonStatus.Name = "m_winUIButtonStatus";
            this.m_winUIButtonStatus.Size = new System.Drawing.Size(75, 63);
            this.m_winUIButtonStatus.TabIndex = 3;
            this.m_winUIButtonStatus.Text = "windowsUIButtonPanel1";
            this.m_winUIButtonStatus.ButtonClick += new DevExpress.XtraBars.Docking2010.ButtonEventHandler(this.m_winUIButtonStatus_ButtonClick);
            // 
            // m_panelControl
            // 
            this.m_panelControl.BorderStyle = DevExpress.XtraEditors.Controls.BorderStyles.Simple;
            this.m_panelControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.m_panelControl.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.m_panelControl.Location = new System.Drawing.Point(0, 0);
            this.m_panelControl.Name = "m_panelControl";
            this.m_panelControl.Size = new System.Drawing.Size(106, 106);
            this.m_panelControl.TabIndex = 4;
            // 
            // WarnItemControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_winUIButtonStatus);
            this.Controls.Add(this.m_labelControlMsg);
            this.Controls.Add(this.m_panelControl);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "WarnItemControl";
            this.Size = new System.Drawing.Size(106, 106);
            ((System.ComponentModel.ISupportInitialize)(this.m_panelControl)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private DevExpress.XtraEditors.LabelControl m_labelControlMsg;
        private DevExpress.XtraBars.Docking2010.WindowsUIButtonPanel m_winUIButtonStatus;
        private DevExpress.XtraEditors.PanelControl m_panelControl;
    }
}
