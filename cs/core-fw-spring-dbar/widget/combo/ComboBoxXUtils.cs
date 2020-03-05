using DevComponents.DotNetBar.Controls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_dbar.widget.combo
{
    public class ComboBoxXUtils
    {
        #region init

        public static ComboBoxEx genCombo(object oSelectItem, List<String> lstItems,
            Object oTag,
            EventHandler oSelectedValueChangedCallback)
        {
            var oCombo = new ComboBoxEx();

            oCombo.Items.AddRange(lstItems.ToArray());
            oCombo.SelectedItem = oSelectItem;
            oCombo.Tag = oTag;
            oCombo.SelectedValueChanged += oSelectedValueChangedCallback;

            return oCombo;
        }

        #endregion
    }
}
