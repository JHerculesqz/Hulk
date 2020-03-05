using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_dbar.widget
{
    public class LabelUtils
    {
        #region setParent

        public static void setParent(Label oLabel, Control oParent)
        {
            oLabel.Parent = oParent;
        }

        public static void setParent(List<Label> lstLabel, Control oParent)
        {
            foreach (var oLabel in lstLabel)
            {
                setParent(oLabel, oParent);
            }
        }

        #endregion
    }
}
