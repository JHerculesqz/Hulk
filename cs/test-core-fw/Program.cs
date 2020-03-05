using core_fw.widget.i18n;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using test_core_fw.component.io.path;
using test_core_fw.component.misc.log;
using test_core_fw.widget.splash;
using test_core_fw.widgetX;
using walle.widget.form;

namespace test_core_fw
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main()
        {
            I18nUtilsEx.init4I18N();
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            //Application.Run(new SysLogUtilsForm());
            Application.Run(new PathForm());
            //Application.Run(new MainForm());
            //Application.Run(new FLControlBaseTest());
            //Application.Run(new FLBtnTest());
        }
    }
}
