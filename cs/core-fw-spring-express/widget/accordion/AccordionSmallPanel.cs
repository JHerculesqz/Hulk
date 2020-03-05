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

namespace core_fw_spring_express.widget.accordion
{
    public partial class AccordionSmallPanel : DevExpress.XtraEditors.XtraUserControl
    {
        #region Fields

        private AccordionOptSetVo m_oAccordionOptSetVo;

        #endregion

        #region Construction

        public AccordionSmallPanel()
        {
            InitializeComponent();
        }

        #endregion

        #region init

        public void init(AccordionOptSetVo oAccordionOptSetVo)
        {
            this.m_oAccordionOptSetVo = oAccordionOptSetVo;

            //clear
            this.m_splitContainer.Panel2.Controls.Clear();

            //add UI list
            foreach (var oAccordionOptVo in oAccordionOptSetVo.items)
            {
                var oPanel = new Panel();
                oPanel.Name = oAccordionOptVo.id;
                oPanel.BackColor = oAccordionOptVo.color;
                oPanel.Location = new Point(oAccordionOptVo.x, oAccordionOptVo.y);
                oPanel.Size = new Size(oAccordionOptVo.w, oAccordionOptVo.h);
                oPanel.Tag = oAccordionOptVo.buObj;
                oPanel.ContextMenuStrip = oAccordionOptVo.contextMenuStrip;
                oPanel.MouseClick += (sender, e) =>
                {
                    //if left click
                    if (e.Button == MouseButtons.Left)
                    {
                        oAccordionOptVo.callbackMouseLeftClick(sender, e);
                    }
                    //if right click
                    else
                    {
                        oAccordionOptVo.callbackMouseRightClick(sender, e);
                    }
                };
                this.m_splitContainer.Panel2.Controls.Add(oPanel);

                if (oAccordionOptVo.id == oAccordionOptSetVo.selectAccordiontemID)
                {
                    this.updateCurSelectView(oAccordionOptVo.id, oAccordionOptVo.name);
                }
            }
        }

        #endregion

        #region curSelectView

        public void updateCurSelectView(string strId, string strName)
        {
            this.m_simpleButtonCurLayer.Tag = strId;
            this.m_simpleButtonCurLayer.Text = strName;
        }

        #endregion

        #region button

        private void m_simpleButtonCurLayer_Click(object sender, EventArgs e)
        {
            if (this.m_oAccordionOptSetVo.callback4Btn != null)
            {
                this.m_oAccordionOptSetVo.callback4Btn(sender, e);
            }
        }

        #endregion
    }
}
