namespace core_fw_spring_express.widget.about
{
    partial class AboutFormEx2
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AboutFormEx2));
            this.m_labelControlProductName = new DevExpress.XtraEditors.LabelControl();
            this.m_labelControlVer = new DevExpress.XtraEditors.LabelControl();
            this.m_labelControlCopyRight = new DevExpress.XtraEditors.LabelControl();
            this.m_pictureEdit = new DevExpress.XtraEditors.PictureEdit();
            ((System.ComponentModel.ISupportInitialize)(this.m_pictureEdit.Properties)).BeginInit();
            this.SuspendLayout();
            // 
            // m_labelControlProductName
            // 
            this.m_labelControlProductName.Appearance.Font = new System.Drawing.Font("微软雅黑", 20F);
            this.m_labelControlProductName.Appearance.Options.UseFont = true;
            this.m_labelControlProductName.Location = new System.Drawing.Point(115, 12);
            this.m_labelControlProductName.Name = "m_labelControlProductName";
            this.m_labelControlProductName.Size = new System.Drawing.Size(136, 45);
            this.m_labelControlProductName.TabIndex = 1;
            this.m_labelControlProductName.Text = "产品名称";
            // 
            // m_labelControlVer
            // 
            this.m_labelControlVer.Location = new System.Drawing.Point(256, 36);
            this.m_labelControlVer.Name = "m_labelControlVer";
            this.m_labelControlVer.Size = new System.Drawing.Size(30, 18);
            this.m_labelControlVer.TabIndex = 1;
            this.m_labelControlVer.Text = "版本";
            // 
            // m_labelControlCopyRight
            // 
            this.m_labelControlCopyRight.Location = new System.Drawing.Point(115, 74);
            this.m_labelControlCopyRight.Name = "m_labelControlCopyRight";
            this.m_labelControlCopyRight.Size = new System.Drawing.Size(273, 18);
            this.m_labelControlCopyRight.TabIndex = 1;
            this.m_labelControlCopyRight.Text = "@2014-2017 AU3TECH.All Right Reserved";
            // 
            // m_pictureEdit
            // 
            this.m_pictureEdit.EditValue = ((object)(resources.GetObject("m_pictureEdit.EditValue")));
            this.m_pictureEdit.Location = new System.Drawing.Point(12, 12);
            this.m_pictureEdit.Name = "m_pictureEdit";
            this.m_pictureEdit.Properties.ShowCameraMenuItem = DevExpress.XtraEditors.Controls.CameraMenuItemVisibility.Auto;
            this.m_pictureEdit.Size = new System.Drawing.Size(90, 90);
            this.m_pictureEdit.TabIndex = 0;
            // 
            // AboutFormEx2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(416, 111);
            this.Controls.Add(this.m_labelControlCopyRight);
            this.Controls.Add(this.m_labelControlVer);
            this.Controls.Add(this.m_labelControlProductName);
            this.Controls.Add(this.m_pictureEdit);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "AboutFormEx2";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "关于";
            ((System.ComponentModel.ISupportInitialize)(this.m_pictureEdit.Properties)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private DevExpress.XtraEditors.LabelControl m_labelControlProductName;
        private DevExpress.XtraEditors.LabelControl m_labelControlVer;
        private DevExpress.XtraEditors.LabelControl m_labelControlCopyRight;
        private DevExpress.XtraEditors.PictureEdit m_pictureEdit;
    }
}