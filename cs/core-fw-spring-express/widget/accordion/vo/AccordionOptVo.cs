using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.accordion.vo
{
    public class AccordionOptVo
    {
        #region Fields

        public string id { set; get; }

        public int x { set; get; }
        public int y { set; get; }
        public int w { set; get; }
        public int h { set; get; }
        public Color color { set; get; }

        public string name { set; get; }

        public object buObj { set; get; }

        public ContextMenuStrip contextMenuStrip { set; get; }

        public Action<object, MouseEventArgs> callbackMouseLeftClick { set; get; }
        public Action<object, MouseEventArgs> callbackMouseRightClick { set; get; }

        #endregion
    }
}
