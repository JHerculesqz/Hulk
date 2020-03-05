namespace core_fw_spring_express.widget.warn
{
    partial class WarnItemControlV2
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(WarnItemControlV2));
            this.m_labelControlMsg = new DevExpress.XtraEditors.LabelControl();
            this.m_panelControl = new DevExpress.XtraEditors.PanelControl();
            this.m_simpleButton = new DevExpress.XtraEditors.SimpleButton();
            ((System.ComponentModel.ISupportInitialize)(this.m_panelControl)).BeginInit();
            this.m_panelControl.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_labelControlMsg
            // 
            this.m_labelControlMsg.Appearance.Font = new System.Drawing.Font("Tahoma", 12F);
            this.m_labelControlMsg.Appearance.ForeColor = System.Drawing.Color.Red;
            this.m_labelControlMsg.Appearance.Options.UseFont = true;
            this.m_labelControlMsg.Appearance.Options.UseForeColor = true;
            this.m_labelControlMsg.Location = new System.Drawing.Point(163, 8);
            this.m_labelControlMsg.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.m_labelControlMsg.Name = "m_labelControlMsg";
            this.m_labelControlMsg.Size = new System.Drawing.Size(65, 19);
            this.m_labelControlMsg.TabIndex = 1;
            this.m_labelControlMsg.Text = "WarnMsg";
            // 
            // m_panelControl
            // 
            this.m_panelControl.AutoSize = true;
            this.m_panelControl.BorderStyle = DevExpress.XtraEditors.Controls.BorderStyles.Simple;
            this.m_panelControl.Controls.Add(this.m_simpleButton);
            this.m_panelControl.Controls.Add(this.m_labelControlMsg);
            this.m_panelControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.m_panelControl.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.m_panelControl.Location = new System.Drawing.Point(0, 0);
            this.m_panelControl.Name = "m_panelControl";
            this.m_panelControl.Size = new System.Drawing.Size(693, 40);
            this.m_panelControl.TabIndex = 4;
            // 
            // m_simpleButton
            // 
            this.m_simpleButton.Appearance.Font = new System.Drawing.Font("Tahoma", 12F);
            this.m_simpleButton.Appearance.ForeColor = System.Drawing.Color.Red;
            this.m_simpleButton.Appearance.Options.UseFont = true;
            this.m_simpleButton.Appearance.Options.UseForeColor = true;
            this.m_simpleButton.ButtonStyle = DevExpress.XtraEditors.Controls.BorderStyles.HotFlat;
            this.m_simpleButton.ImageOptions.Image = ((System.Drawing.Image)(resources.GetObject("m_simpleButton.ImageOptions.Image")));
            this.m_simpleButton.Location = new System.Drawing.Point(58, 6);
            this.m_simpleButton.Name = "m_simpleButton";
            this.m_simpleButton.Size = new System.Drawing.Size(85, 23);
            this.m_simpleButton.TabIndex = 2;
            this.m_simpleButton.Text = "name";
            this.m_simpleButton.Click += new System.EventHandler(this.m_simpleButton_Click);
            // 
            // WarnItemControlV2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_panelControl);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "WarnItemControlV2";
            this.Size = new System.Drawing.Size(693, 40);
            ((System.ComponentModel.ISupportInitialize)(this.m_panelControl)).EndInit();
            this.m_panelControl.ResumeLayout(false);
            this.m_panelControl.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private DevExpress.XtraEditors.LabelControl m_labelControlMsg;
        private DevExpress.XtraEditors.PanelControl m_panelControl;
        private DevExpress.XtraEditors.SimpleButton m_simpleButton;
    }
}
