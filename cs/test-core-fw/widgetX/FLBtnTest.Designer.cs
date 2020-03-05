namespace test_core_fw.widgetX
{
    partial class FLBtnTest
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
            this.flBtn1 = new core_fw.widgetX.btn.FLBtn();
            this.SuspendLayout();
            // 
            // flBtn1
            // 
            this.flBtn1.BackColor = System.Drawing.Color.Transparent;
            this.flBtn1.BtnBGColor = System.Drawing.Color.Transparent;
            this.flBtn1.BtnFont = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Pixel, ((byte)(134)));
            this.flBtn1.BtnFontColor = System.Drawing.Color.FromArgb(((int)(((byte)(169)))), ((int)(((byte)(169)))), ((int)(((byte)(169)))));
            this.flBtn1.BtnText = "FLBtn";
            this.flBtn1.ConerRadius = 4;
            this.flBtn1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.flBtn1.EnabledMouseEffect = true;
            this.flBtn1.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(56)))), ((int)(((byte)(56)))), ((int)(((byte)(56)))));
            this.flBtn1.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Pixel);
            this.flBtn1.ForeColor = System.Drawing.SystemColors.ControlText;
            this.flBtn1.IsRadius = true;
            this.flBtn1.IsShowRect = false;
            this.flBtn1.IsShowTips = false;
            this.flBtn1.Location = new System.Drawing.Point(9, 9);
            this.flBtn1.Margin = new System.Windows.Forms.Padding(0);
            this.flBtn1.Name = "flBtn1";
            this.flBtn1.RectColor = System.Drawing.Color.FromArgb(((int)(((byte)(56)))), ((int)(((byte)(56)))), ((int)(((byte)(56)))));
            this.flBtn1.RectWidth = 1;
            this.flBtn1.Size = new System.Drawing.Size(75, 23);
            this.flBtn1.TabIndex = 0;
            this.flBtn1.TabStop = false;
            this.flBtn1.TipsColor = System.Drawing.Color.FromArgb(((int)(((byte)(235)))), ((int)(((byte)(56)))), ((int)(((byte)(56)))));
            this.flBtn1.TipsText = "99";
            // 
            // FLBtnTest
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(600, 360);
            this.Controls.Add(this.flBtn1);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "FLBtnTest";
            this.Text = "FLBtnTest";
            this.ResumeLayout(false);

        }

        #endregion

        private core_fw.widgetX.btn.FLBtn flBtn1;
    }
}