using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using DevExpress.XtraEditors;
using core_fw_spring_express.widget.accordion.vo;
using core_fw.widget.color;

namespace core_fw_spring_express.widget.accordion
{
    public partial class AccordionItem : DevExpress.XtraEditors.XtraUserControl
    {
        #region Fields

        private AccordionOptVo m_oAccordionOptVo;
        private AccordionPanel m_oParentAccordionPanel;

        #endregion

        #region Construction

        public AccordionItem(AccordionOptVo oAccordionOptVo, AccordionPanel oAccordionPanel)
        {
            InitializeComponent();

            this.m_oAccordionOptVo = oAccordionOptVo;
            this.m_oParentAccordionPanel = oAccordionPanel;

            //this
            this.Location = new Point(oAccordionOptVo.x, oAccordionOptVo.y);
            this.Size = new Size(oAccordionOptVo.w, oAccordionOptVo.h);
            this.Tag = oAccordionOptVo.buObj;

            //colorPanel
            this.m_panelColor.BackColor = oAccordionOptVo.color;

            //label
            this.m_labelName.Text = oAccordionOptVo.name;

            //contextMenu
            this.ContextMenuStrip = oAccordionOptVo.contextMenuStrip;

            //parent
            this.m_oParentAccordionPanel.Controls.Add(this);
        }

        #endregion

        #region mouseDown

        private void AccordionItem_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                selectView();
                this.m_oAccordionOptVo.callbackMouseLeftClick(this, e);
            }
            else if (e.Button == MouseButtons.Right)
            {
                this.m_oAccordionOptVo.callbackMouseRightClick(sender, e);
            }
        }

        #endregion

        #region selectView

        public void selectView()
        {
            //if old exists,unselect old
            if (null != this.m_oParentAccordionPanel.selectAccordionItem)
            {
                this.m_oParentAccordionPanel.selectAccordionItem.unselectView();
            }

            //select new
            //this.BorderStyle = BorderStyle.FixedSingle;
            this.BackColor = Color.DimGray;//ColorUtils.genColor("#3F3F3F"); 

            //update old
            this.m_oParentAccordionPanel.selectAccordionItem = this;
        }

        public void unselectView()
        {
            //this.BorderStyle = BorderStyle.None;
            this.BackColor = Color.FromArgb(255, 88, 88, 88) ;//ColorUtils.genColor("#595959"); ;
        }

        #endregion

        #region updateNameAndColorCode

        public void updateNameAndColorCode(string strName, string strColorCode)
        {
            this.m_labelName.Text = strName;
            this.m_panelColor.BackColor = ColorUtils.genColor(strColorCode);
        }

        #endregion
    }
}
