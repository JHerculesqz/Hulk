using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace core_fw_csharp.src.component.thread
{
    public class ThreadUtilsEx
    {
        #region start

        public static void start(Action oCallback)
        {
            Thread oThread = new Thread(() =>
            {
                oCallback();
            });
            oThread.Start();
        }

        #endregion
    }
}
