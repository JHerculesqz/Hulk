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
    public partial class AccordionPanel : DevExpress.XtraEditors.XtraUserControl
    {
        #region Fields

        public AccordionItem selectAccordionItem { set; get; }

        #endregion

        #region Constrcution

        public AccordionPanel()
        {
            InitializeComponent();
        }

        #endregion

        #region init

        public void init(AccordionOptSetVo oAccordionOptSetVo)
        {
            //clear
            this.Controls.Clear();

            //add UI list
            foreach (var oAccordionOptVo in oAccordionOptSetVo.items)
            {
                var oAccordionItem = new AccordionItem(oAccordionOptVo, this);
                if (oAccordionOptVo.id == oAccordionOptSetVo.selectAccordiontemID)
                {
                    //select new
                    oAccordionItem.selectView();
                }
            }
        }

        #endregion

        #region setAccordionItemVisible

        public void setAccordionItemVisible<T>(bool bIsVisible, Func<T, bool> oCallbackIsMatch)
        {
            foreach (var oControl in this.Controls)
            {
                var oAccordionItem = (AccordionItem)oControl;
                if (oCallbackIsMatch((T)oAccordionItem.Tag))
                {
                    oAccordionItem.Visible = bIsVisible;
                }
            }
        }

        #endregion
    }
}
