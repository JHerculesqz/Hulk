using DevComponents.DotNetBar.Controls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_dbar.widget.textbox
{
    public class TextBoxXUtils
    {
        #region genTextBox

        public static TextBoxX genTextBox(String strText, Object oTag, EventHandler oLostFucsCallback)
        {
            var oTextBox = new TextBoxX();

            oTextBox.Text = strText;
            oTextBox.Tag = oTag;
            oTextBox.LostFocus += oLostFucsCallback;

            return oTextBox;
        }

        #endregion
    }
}
