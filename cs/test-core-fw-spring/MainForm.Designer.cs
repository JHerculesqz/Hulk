namespace test_core_fw_spring
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
            this.m_buttonIOC = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // m_buttonIOC
            // 
            this.m_buttonIOC.Location = new System.Drawing.Point(22, 12);
            this.m_buttonIOC.Name = "m_buttonIOC";
            this.m_buttonIOC.Size = new System.Drawing.Size(75, 23);
            this.m_buttonIOC.TabIndex = 0;
            this.m_buttonIOC.Text = "IOC";
            this.m_buttonIOC.UseVisualStyleBackColor = true;
            this.m_buttonIOC.Click += new System.EventHandler(this.m_buttonIOC_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.m_buttonIOC);
            this.Name = "MainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "test-core-fw-spring";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button m_buttonIOC;
    }
}

