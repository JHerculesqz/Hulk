using DevExpress.XtraBars;
using DevExpress.XtraEditors.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.bar
{
    public class BarEditItemUtils
    {
        #region init

        public static void init(BarEditItem oBarEditItem, string strDefaultVal)
        {
            oBarEditItem.EditValue = strDefaultVal;
        }

        #endregion
    }
}
