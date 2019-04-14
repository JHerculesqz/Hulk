using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace core_fw_csharp.src.component.str
{
    public class StrUtilsEx
    {
        #region toUrlParams

        public static string toUrlParams(object obj)
        {
            StringBuilder oSb = new StringBuilder();
            PropertyInfo[] arrPropertyInfo = obj.GetType().GetProperties();
            foreach (var oPropertyInfo in arrPropertyInfo)
            {
                if (!string.IsNullOrEmpty(oSb.ToString()))
                {
                    oSb.Append("&");
                }
                var oValue = oPropertyInfo.GetValue(obj, null);
                oSb.Append(oPropertyInfo.Name);
                oSb.Append("=");
                oSb.Append(null==oValue ? "":HttpUtility.UrlEncode(oValue.ToString()));
            }

            return oSb.ToString();
        }

        #endregion
    }
}
