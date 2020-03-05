namespace test_core_fw.widgetX
{
    partial class FLControlBaseTest
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
            this.flControlBase1 = new core_fw.widgetX.FLControlBase();
            this.SuspendLayout();
            // 
            // flControlBase1
            // 
            this.flControlBase1.ConerRadius = 24;
            this.flControlBase1.FillColor = System.Drawing.Color.Transparent;
            this.flControlBase1.IsRadius = true;
            this.flControlBase1.IsShowRect = true;
            this.flControlBase1.Location = new System.Drawing.Point(12, 12);
            this.flControlBase1.Name = "flControlBase1";
            this.flControlBase1.RectColor = System.Drawing.Color.FromArgb(((int)(((byte)(220)))), ((int)(((byte)(220)))), ((int)(((byte)(220)))));
            this.flControlBase1.RectWidth = 1;
            this.flControlBase1.Size = new System.Drawing.Size(408, 143);
            this.flControlBase1.TabIndex = 0;
            // 
            // FLControlBaseTest
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.flControlBase1);
            this.Name = "FLControlBaseTest";
            this.Text = "FLControlBaseTest";
            this.ResumeLayout(false);

        }

        #endregion

        private core_fw.widgetX.FLControlBase flControlBase1;
    }
}