namespace core_fw_spring_express.widget.accordion
{
    partial class AccordionItem
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
            this.m_labelName = new System.Windows.Forms.Label();
            this.m_panelColor = new System.Windows.Forms.Panel();
            this.SuspendLayout();
            // 
            // m_labelName
            // 
            this.m_labelName.AutoSize = true;
            this.m_labelName.Location = new System.Drawing.Point(38, 10);
            this.m_labelName.Name = "m_labelName";
            this.m_labelName.Size = new System.Drawing.Size(47, 18);
            this.m_labelName.TabIndex = 3;
            this.m_labelName.Text = "Name";
            this.m_labelName.MouseDown += new System.Windows.Forms.MouseEventHandler(this.AccordionItem_MouseDown);
            // 
            // m_panelColor
            // 
            this.m_panelColor.Location = new System.Drawing.Point(4, 7);
            this.m_panelColor.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.m_panelColor.Name = "m_panelColor";
            this.m_panelColor.Size = new System.Drawing.Size(25, 25);
            this.m_panelColor.TabIndex = 2;
            this.m_panelColor.MouseDown += new System.Windows.Forms.MouseEventHandler(this.AccordionItem_MouseDown);
            // 
            // AccordionItem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_labelName);
            this.Controls.Add(this.m_panelColor);
            this.Name = "AccordionItem";
            this.Size = new System.Drawing.Size(190, 40);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.AccordionItem_MouseDown);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label m_labelName;
        private System.Windows.Forms.Panel m_panelColor;
    }
}
