using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.warn.vo
{
    public class WarnVo
    {
        #region Fields

        public string devType { set; get; }
        public string devName { set; get; }
        public bool isConnException { set; get; } = true;
        public List<string> WarnInfoLst { set; get; } = new List<string>();
        public Action<string> oCallback4Conn { set; get; }
        public Action<string> oCallback4ClearWarn { set; get; }

        #endregion
    }
}
