using DevComponents.DotNetBar.Controls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_dbar.widget.chekcbox
{
    public class CheckBoxXUtils
    {
        #region genCheckBox

        public static CheckBoxX genCheckBox(bool bChecked, Object oTag,
            EventHandler oCheckedChangedCallback)
        {
            var oCheckBox = new CheckBoxX();
            oCheckBox.Checked = bChecked;
            oCheckBox.Tag = oTag;
            oCheckBox.CheckedChanged += oCheckedChangedCallback;
            return oCheckBox;
        }

        #endregion
    }
}
