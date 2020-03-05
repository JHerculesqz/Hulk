namespace test_core_fw_db_sqlite
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
            this.m_buttonTest4DBSqlite = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // m_buttonTest4DBSqlite
            // 
            this.m_buttonTest4DBSqlite.Location = new System.Drawing.Point(26, 65);
            this.m_buttonTest4DBSqlite.Name = "m_buttonTest4DBSqlite";
            this.m_buttonTest4DBSqlite.Size = new System.Drawing.Size(126, 23);
            this.m_buttonTest4DBSqlite.TabIndex = 0;
            this.m_buttonTest4DBSqlite.Text = "testSqlite";
            this.m_buttonTest4DBSqlite.UseVisualStyleBackColor = true;
            this.m_buttonTest4DBSqlite.Click += new System.EventHandler(this.m_buttonTest4DBSqlite_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.m_buttonTest4DBSqlite);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "testSqlite";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button m_buttonTest4DBSqlite;
    }
}

