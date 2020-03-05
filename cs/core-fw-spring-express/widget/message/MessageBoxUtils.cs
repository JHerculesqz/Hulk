using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.message
{
    public class MessageBoxUtils
    {
        #region show

        public static void show(string strMsg)
        {
            XtraMessageBox.Show(strMsg);
        }

        #endregion
    }
}
