namespace test_core_fw_spring_express.widget.warn
{
    partial class TestWarnPanel
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
            this.m_simpleButtonWarnPanelV3UpdateCon = new DevExpress.XtraEditors.SimpleButton();
            this.m_simpleButtonWarnPanelV3Init = new DevExpress.XtraEditors.SimpleButton();
            this.SuspendLayout();
            // 
            // m_simpleButtonWarnPanelV3UpdateCon
            // 
            this.m_simpleButtonWarnPanelV3UpdateCon.Location = new System.Drawing.Point(85, 50);
            this.m_simpleButtonWarnPanelV3UpdateCon.Name = "m_simpleButtonWarnPanelV3UpdateCon";
            this.m_simpleButtonWarnPanelV3UpdateCon.Size = new System.Drawing.Size(87, 29);
            this.m_simpleButtonWarnPanelV3UpdateCon.TabIndex = 6;
            this.m_simpleButtonWarnPanelV3UpdateCon.Text = "update";
            this.m_simpleButtonWarnPanelV3UpdateCon.Click += new System.EventHandler(this.m_simpleButtonWarnPanelV3UpdateCon_Click);
            // 
            // m_simpleButtonWarnPanelV3Init
            // 
            this.m_simpleButtonWarnPanelV3Init.Location = new System.Drawing.Point(3, 50);
            this.m_simpleButtonWarnPanelV3Init.Name = "m_simpleButtonWarnPanelV3Init";
            this.m_simpleButtonWarnPanelV3Init.Size = new System.Drawing.Size(76, 29);
            this.m_simpleButtonWarnPanelV3Init.TabIndex = 5;
            this.m_simpleButtonWarnPanelV3Init.Text = "init";
            this.m_simpleButtonWarnPanelV3Init.Click += new System.EventHandler(this.m_simpleButtonWarnPanelV3Init_Click);
            // 
            // TestWarnPanel
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_simpleButtonWarnPanelV3UpdateCon);
            this.Controls.Add(this.m_simpleButtonWarnPanelV3Init);
            this.Name = "TestWarnPanel";
            this.Size = new System.Drawing.Size(991, 308);
            this.ResumeLayout(false);

        }

        #endregion
        private DevExpress.XtraEditors.SimpleButton m_simpleButtonWarnPanelV3UpdateCon;
        private DevExpress.XtraEditors.SimpleButton m_simpleButtonWarnPanelV3Init;
    }
}
