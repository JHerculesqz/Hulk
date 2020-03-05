using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.pgrid.vo
{
    public class RowVo
    {
        #region Const

        public static readonly string TYPE_TEXT = "text";
        public static readonly string TYPE_COMBO = "combo";
        public static readonly string TYPE_CHOICE = "choice";

        #endregion

        #region Fields

        public string name { set; get; }
        public string labelText { set; get; }
        public string type { set; get; }
        public string defaultVal { set; get; }
        public List<string> values { set; get; } = new List<string>();
        public bool isReadOnly { set; get; }
        public TextEdit textBox { set; get; }
        public ComboBoxEdit combo { set; get; }

        #endregion
    }
}
