using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using walle.component.date;

namespace walle.component.license
{
    public class LicenseUtilsEx
    {
        #region check

        public static bool check(string strTimeExpire)
        {
            string strNow = DateUtilsEx.getWebsiteDatetime("http://www.baidu.com");
            if (string.IsNullOrEmpty(strNow))
            {
                return false;
            }
            else
            {
                if (DateUtilsEx.isExpire(strNow, strTimeExpire))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }

        #endregion
    }
}
