namespace core_fw_spring_express.widget.warn.v3
{
    partial class WarnPanelV3
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(WarnPanelV3));
            this.m_barManagerWarnDetails = new DevExpress.XtraBars.BarManager();
            this.barDockControlTop = new DevExpress.XtraBars.BarDockControl();
            this.barDockControlBottom = new DevExpress.XtraBars.BarDockControl();
            this.barDockControlLeft = new DevExpress.XtraBars.BarDockControl();
            this.barDockControlRight = new DevExpress.XtraBars.BarDockControl();
            this.m_labelControlWarnMsg = new DevExpress.XtraEditors.LabelControl();
            this.m_panelControl = new DevExpress.XtraEditors.PanelControl();
            this.m_popupControlContainerWarnDetails = new DevExpress.XtraBars.PopupControlContainer();
            this.m_dropDownButtonWarn = new DevExpress.XtraEditors.DropDownButton();
            ((System.ComponentModel.ISupportInitialize)(this.m_barManagerWarnDetails)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.m_panelControl)).BeginInit();
            this.m_panelControl.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.m_popupControlContainerWarnDetails)).BeginInit();
            this.m_popupControlContainerWarnDetails.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_barManagerWarnDetails
            // 
            this.m_barManagerWarnDetails.DockControls.Add(this.barDockControlTop);
            this.m_barManagerWarnDetails.DockControls.Add(this.barDockControlBottom);
            this.m_barManagerWarnDetails.DockControls.Add(this.barDockControlLeft);
            this.m_barManagerWarnDetails.DockControls.Add(this.barDockControlRight);
            this.m_barManagerWarnDetails.Form = this;
            // 
            // barDockControlTop
            // 
            this.barDockControlTop.CausesValidation = false;
            this.barDockControlTop.Dock = System.Windows.Forms.DockStyle.Top;
            this.barDockControlTop.Location = new System.Drawing.Point(0, 0);
            this.barDockControlTop.Manager = this.m_barManagerWarnDetails;
            this.barDockControlTop.Size = new System.Drawing.Size(620, 0);
            // 
            // barDockControlBottom
            // 
            this.barDockControlBottom.CausesValidation = false;
            this.barDockControlBottom.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.barDockControlBottom.Location = new System.Drawing.Point(0, 125);
            this.barDockControlBottom.Manager = this.m_barManagerWarnDetails;
            this.barDockControlBottom.Size = new System.Drawing.Size(620, 0);
            // 
            // barDockControlLeft
            // 
            this.barDockControlLeft.CausesValidation = false;
            this.barDockControlLeft.Dock = System.Windows.Forms.DockStyle.Left;
            this.barDockControlLeft.Location = new System.Drawing.Point(0, 0);
            this.barDockControlLeft.Manager = this.m_barManagerWarnDetails;
            this.barDockControlLeft.Size = new System.Drawing.Size(0, 125);
            // 
            // barDockControlRight
            // 
            this.barDockControlRight.CausesValidation = false;
            this.barDockControlRight.Dock = System.Windows.Forms.DockStyle.Right;
            this.barDockControlRight.Location = new System.Drawing.Point(620, 0);
            this.barDockControlRight.Manager = this.m_barManagerWarnDetails;
            this.barDockControlRight.Size = new System.Drawing.Size(0, 125);
            // 
            // m_labelControlWarnMsg
            // 
            this.m_labelControlWarnMsg.Location = new System.Drawing.Point(8, 6);
            this.m_labelControlWarnMsg.Name = "m_labelControlWarnMsg";
            this.m_labelControlWarnMsg.Size = new System.Drawing.Size(225, 18);
            this.m_labelControlWarnMsg.TabIndex = 0;
            this.m_labelControlWarnMsg.Text = ".............................................";
            // 
            // m_panelControl
            // 
            this.m_panelControl.Controls.Add(this.m_popupControlContainerWarnDetails);
            this.m_panelControl.Controls.Add(this.m_dropDownButtonWarn);
            this.m_panelControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.m_panelControl.Location = new System.Drawing.Point(0, 0);
            this.m_panelControl.Name = "m_panelControl";
            this.m_panelControl.Size = new System.Drawing.Size(620, 125);
            this.m_panelControl.TabIndex = 2;
            // 
            // m_popupControlContainerWarnDetails
            // 
            this.m_popupControlContainerWarnDetails.AutoSize = true;
            this.m_popupControlContainerWarnDetails.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.m_popupControlContainerWarnDetails.BorderStyle = DevExpress.XtraEditors.Controls.BorderStyles.NoBorder;
            this.m_popupControlContainerWarnDetails.Controls.Add(this.m_labelControlWarnMsg);
            this.m_popupControlContainerWarnDetails.Location = new System.Drawing.Point(365, 40);
            this.m_popupControlContainerWarnDetails.Manager = this.m_barManagerWarnDetails;
            this.m_popupControlContainerWarnDetails.Name = "m_popupControlContainerWarnDetails";
            this.m_popupControlContainerWarnDetails.Size = new System.Drawing.Size(236, 27);
            this.m_popupControlContainerWarnDetails.TabIndex = 6;
            this.m_popupControlContainerWarnDetails.Visible = false;
            // 
            // m_dropDownButtonWarn
            // 
            this.m_dropDownButtonWarn.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.m_dropDownButtonWarn.DropDownArrowStyle = DevExpress.XtraEditors.DropDownArrowStyle.Hide;
            this.m_dropDownButtonWarn.DropDownControl = this.m_popupControlContainerWarnDetails;
            this.m_dropDownButtonWarn.ImageOptions.Image = ((System.Drawing.Image)(resources.GetObject("m_dropDownButtonWarn.ImageOptions.Image")));
            this.m_dropDownButtonWarn.Location = new System.Drawing.Point(497, 5);
            this.m_dropDownButtonWarn.Name = "m_dropDownButtonWarn";
            this.m_dropDownButtonWarn.Size = new System.Drawing.Size(118, 29);
            this.m_dropDownButtonWarn.TabIndex = 5;
            this.m_dropDownButtonWarn.Text = "告警(0)";
            // 
            // WarnPanelV3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.m_panelControl);
            this.Controls.Add(this.barDockControlLeft);
            this.Controls.Add(this.barDockControlRight);
            this.Controls.Add(this.barDockControlBottom);
            this.Controls.Add(this.barDockControlTop);
            this.Name = "WarnPanelV3";
            this.Size = new System.Drawing.Size(620, 125);
            ((System.ComponentModel.ISupportInitialize)(this.m_barManagerWarnDetails)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.m_panelControl)).EndInit();
            this.m_panelControl.ResumeLayout(false);
            this.m_panelControl.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.m_popupControlContainerWarnDetails)).EndInit();
            this.m_popupControlContainerWarnDetails.ResumeLayout(false);
            this.m_popupControlContainerWarnDetails.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private DevExpress.XtraEditors.PanelControl m_panelControl;
        private DevExpress.XtraEditors.DropDownButton m_dropDownButtonWarn;
        private DevExpress.XtraEditors.LabelControl m_labelControlWarnMsg;
        private DevExpress.XtraBars.BarManager m_barManagerWarnDetails;
        private DevExpress.XtraBars.BarDockControl barDockControlTop;
        private DevExpress.XtraBars.BarDockControl barDockControlBottom;
        private DevExpress.XtraBars.BarDockControl barDockControlLeft;
        private DevExpress.XtraBars.BarDockControl barDockControlRight;
        private DevExpress.XtraBars.PopupControlContainer m_popupControlContainerWarnDetails;
    }
}
