using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace core_fw_auto.component.misc.autoit
{
    public class AutoItUtilsEx
    {
        #region sleep

        public static void sleep(int iMillSec)
        {
            Thread.Sleep(iMillSec);
        }

        #endregion

        #region trayToolbarClick

        public static int trayToolbarClick(String strMouse = "left", int iMouseClickTimes = 1, int iX = 0, int iY = 0)
        {
            IntPtr oTrayWnd = AutoIt.AutoItX.WinGetHandle("[Class:Shell_TrayWnd]");
            IntPtr oToolbar = AutoIt.AutoItX.ControlGetHandle(oTrayWnd, "[Class:ToolbarWindow32;Instance:3]");
            int iRes = AutoIt.AutoItX.ControlClick(oTrayWnd, oToolbar, strMouse, iMouseClickTimes, iX, iY);
            return iRes;
        }

        #endregion

        #region editBoxSetText

        public static int editBoxSetText(String strClassWnd, String strClassEditBox, String strText)
        {
            IntPtr oWnd = AutoIt.AutoItX.WinGetHandle(strClassWnd);
            IntPtr oEditBox = AutoIt.AutoItX.ControlGetHandle(oWnd, strClassEditBox);
            int iRes = AutoIt.AutoItX.ControlSetText(oWnd, oEditBox, strText);
            return iRes;
        }

        #endregion

        #region btnClick

        public static int btnClick(String strClassWnd, String strClassBtn)
        {
            IntPtr oWnd = AutoIt.AutoItX.WinGetHandle(strClassWnd);
            IntPtr oBtn = AutoIt.AutoItX.ControlGetHandle(oWnd, strClassBtn);
            int iRes = AutoIt.AutoItX.ControlClick(oWnd, oBtn);
            return iRes;
        }

        #endregion

        #region keyboardSend

        public static void keyboardSend(String strKey)
        {
            AutoIt.AutoItX.Send(strKey);
        }

        #endregion

        #region mouseScroll

        public static void mouseScroll(string strDirection = "up", int iScrollCount = 1)
        {
            AutoIt.AutoItX.MouseWheel(strDirection, iScrollCount);
        }

        #endregion
    }
}
