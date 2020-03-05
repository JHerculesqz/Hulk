using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.accordion.vo
{
    public class AccordionOptSetVo
    {
        #region Fields

        public string selectAccordiontemID { set; get; }

        public List<AccordionOptVo> items { set; get; } = new List<AccordionOptVo>();

        public Action<object, EventArgs> callback4Btn{set;get;}

        #endregion
    }
}
