namespace test_core_fw.component.misc.log
{
    partial class SysLogUtilsForm
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
            this.m_buttonTest = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // m_buttonTest
            // 
            this.m_buttonTest.Location = new System.Drawing.Point(12, 12);
            this.m_buttonTest.Name = "m_buttonTest";
            this.m_buttonTest.Size = new System.Drawing.Size(78, 24);
            this.m_buttonTest.TabIndex = 0;
            this.m_buttonTest.Text = "测试";
            this.m_buttonTest.UseVisualStyleBackColor = true;
            this.m_buttonTest.Click += new System.EventHandler(this.m_buttonTest_Click);
            // 
            // SysLogUtilsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(613, 274);
            this.Controls.Add(this.m_buttonTest);
            this.Name = "SysLogUtilsForm";
            this.Text = "SysLogUtilsForm";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button m_buttonTest;
    }
}