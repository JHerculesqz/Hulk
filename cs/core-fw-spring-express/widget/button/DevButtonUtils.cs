using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.control
{
    public class DevButtonUtils
    {
        #region disableDelay

        public static void disableDelay(SimpleButton oBtn, int iTimeMS)
        {
            oBtn.Enabled = false;
            Thread.Sleep(iTimeMS);
            oBtn.Enabled = true;
        }

        #endregion
    }
}
