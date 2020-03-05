namespace core_fw_spring_express.widget.warn
{
    partial class WarnControlV2
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
            this.m_simpleButtonWarnNum = new DevExpress.XtraEditors.SimpleButton();
            this.SuspendLayout();
            // 
            // m_simpleButtonWarnNum
            // 
            this.m_simpleButtonWarnNum.Appearance.Font = new System.Drawing.Font("Tahoma", 20F);
            this.m_simpleButtonWarnNum.Appearance.ForeColor = System.Drawing.Color.Red;
            this.m_simpleButtonWarnNum.Appearance.GradientMode = System.Drawing.Drawing2D.LinearGradientMode.ForwardDiagonal;
            this.m_simpleButtonWarnNum.Appearance.Options.UseFont = true;
            this.m_simpleButtonWarnNum.Appearance.Options.UseForeColor = true;
            this.m_simpleButtonWarnNum.ButtonStyle = DevExpress.XtraEditors.Controls.BorderStyles.Simple;
            this.m_simpleButtonWarnNum.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.m_simpleButtonWarnNum.Location = new System.Drawing.Point(3, 3);
            this.m_simpleButtonWarnNum.Margin = new System.Windows.Forms.Padding(0);
            this.m_simpleButtonWarnNum.Name = "m_simpleButtonWarnNum";
            this.m_simpleButtonWarnNum.Size = new System.Drawing.Size(45, 42);
            this.m_simpleButtonWarnNum.TabIndex = 0;
            this.m_simpleButtonWarnNum.Text = "0";
            this.m_simpleButtonWarnNum.DoubleClick += new System.EventHandler(this.m_simpleButtonWarnNum_DoubleClick);
            this.m_simpleButtonWarnNum.MouseDown += new System.Windows.Forms.MouseEventHandler(this.m_simpleButtonWarnNum_MouseDown);
            this.m_simpleButtonWarnNum.MouseMove += new System.Windows.Forms.MouseEventHandler(this.m_simpleButtonWarnNum_MouseMove);
            // 
            // WarnControlV2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 14F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.Controls.Add(this.m_simpleButtonWarnNum);
            this.Name = "WarnControlV2";
            this.Size = new System.Drawing.Size(48, 45);
            this.ResumeLayout(false);

        }

        #endregion

        private DevExpress.XtraEditors.SimpleButton m_simpleButtonWarnNum;
    }
}
