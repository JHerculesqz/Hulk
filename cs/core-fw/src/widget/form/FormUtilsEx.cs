using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace walle.widget.form
{
    public class FormUtilsEx
    {
        #region showRightBottom

        public static void showRightBottom(Form oForm)
        {
            int x = Screen.PrimaryScreen.WorkingArea.Right - oForm.Width;
            int y = Screen.PrimaryScreen.WorkingArea.Bottom - oForm.Height;
            oForm.Location = new Point(x, y);
        }

        #endregion

        #region checkThreadFalse

        public static void checkThreadFalse()
        {
            Control.CheckForIllegalCrossThreadCalls = false;
        }

        #endregion
    }
}
