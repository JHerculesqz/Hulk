using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_csharp.src.widget.combo
{
    public class ComboUtilsEx
    {
        #region init

        public static void init(ComboBox oComboBox, Object[] arrItems, 
            string strDisplayName, string strValueName, int iSelectIndex)
        {
            oComboBox.Items.Clear();
            oComboBox.Items.AddRange(arrItems);
            oComboBox.DisplayMember = strDisplayName;// "text";
            oComboBox.ValueMember = strValueName;// "value";
            oComboBox.SelectedIndex = iSelectIndex;// 0;
        }

        #endregion
    }
}
