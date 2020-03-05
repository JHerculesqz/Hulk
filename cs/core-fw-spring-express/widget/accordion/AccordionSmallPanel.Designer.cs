namespace core_fw_spring_express.widget.accordion
{
    partial class AccordionSmallPanel
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
            this.m_splitContainer = new System.Windows.Forms.SplitContainer();
            this.m_simpleButtonCurLayer = new DevExpress.XtraEditors.SimpleButton();
            ((System.ComponentModel.ISupportInitialize)(this.m_splitContainer)).BeginInit();
            this.m_splitContainer.Panel1.SuspendLayout();
            this.m_splitContainer.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_splitContainer
            // 
            this.m_splitContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.m_splitContainer.FixedPanel = System.Windows.Forms.FixedPanel.Panel1;
            this.m_splitContainer.IsSplitterFixed = true;
            this.m_splitContainer.Location = new System.Drawing.Point(0, 0);
            this.m_splitContainer.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.m_splitContainer.Name = "m_splitContainer";
            // 
            // m_splitContainer.Panel1
            // 
            this.m_splitContainer.Panel1.Controls.Add(this.m_simpleButtonCurLayer);
            this.m_splitContainer.Size = new System.Drawing.Size(639, 43);
            this.m_splitContainer.SplitterDistance = 110;
            this.m_splitContainer.SplitterWidth = 5;
            this.m_splitContainer.TabIndex = 15;
            // 
            // m_simpleButtonCurLayer
            // 
            this.m_simpleButtonCurLayer.Location = new System.Drawing.Point(8, 6);
            this.m_simpleButtonCurLayer.Name = "m_simpleButtonCurLayer";
            this.m_simpleButtonCurLayer.Size = new System.Drawing.Size(94, 30);
            this.m_simpleButtonCurLayer.TabIndex = 12;
            this.m_simpleButtonCurLayer.Text = "图层N";
            this.m_simpleButtonCurLayer.Click += new System.EventHandler(this.m_simpleButtonCurLayer_Click);
            // 
            // AccordionSmallPanel
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_splitContainer);
            this.Name = "AccordionSmallPanel";
            this.Size = new System.Drawing.Size(639, 43);
            this.m_splitContainer.Panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.m_splitContainer)).EndInit();
            this.m_splitContainer.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer m_splitContainer;
        private DevExpress.XtraEditors.SimpleButton m_simpleButtonCurLayer;
    }
}
