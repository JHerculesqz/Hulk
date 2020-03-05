namespace test_core_fw
{
    partial class LanForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(LanForm));
            this.m_labelLanTip = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // m_labelLanTip
            // 
            resources.ApplyResources(this.m_labelLanTip, "m_labelLanTip");
            this.m_labelLanTip.Name = "m_labelLanTip";
            // 
            // LanForm
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_labelLanTip);
            this.Name = "LanForm";
            this.Load += new System.EventHandler(this.LanForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label m_labelLanTip;
    }
}