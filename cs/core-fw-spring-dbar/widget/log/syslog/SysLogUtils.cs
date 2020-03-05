using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_dbar.widget.log.syslog
{
    public class SysLogUtils
    {
        #region debug

        public static void debug(String strLog)
        {
            Console.WriteLine(strLog);
        }

        #endregion
    }
}
