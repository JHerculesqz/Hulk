using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_csharp.src.component.color
{
    public class ColorUtils
    {
        #region genColor

        public static Color genColor(String strHex)
        {
            return ColorTranslator.FromHtml(strHex);
        }

        #endregion
    }
}
