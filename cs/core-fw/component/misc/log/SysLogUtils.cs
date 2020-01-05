using NLog;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw.component.misc.log
{
    /// <summary>
    /// SysLogUtils.cs
    /// </summary>
    public class SysLogUtils
    {
        #region Const

        public const string LEVEL_FATAL = "Fatal";
        public const string LEVEL_ERROR = "Error";
        public const string LEVEL_WARN = "Warn";
        public const string LEVEL_INFO = "Info";
        public const string LEVEL_DEBUG = "Debug";
        public const string LEVEL_TRACE = "Trace";

        private const string TEMPLATE_FILELOG = "[{0}]{1}";
        private const string TEMPLATE_USERLOG = "[{0}u]{1}";

        #endregion

        #region Fields

        private static Logger m_oLogger = LogManager.GetCurrentClassLogger();

        #endregion

        #region sysLog

        /// <summary>
        /// fatal log
        /// </summary>
        /// <param name="strBuModuleName">bu module name</param>
        /// <param name="strMsg">log content</param>
        public static void fatal4Sys(string strBuModuleName, string strMsg)
        {
            m_oLogger.Fatal(TEMPLATE_FILELOG, strBuModuleName, strMsg);
        }

        /// <summary>
        /// error log
        /// </summary>
        /// <param name="strBuModuleName">bu module name</param>
        /// <param name="strMsg">log content</param>
        public static void error4Sys(string strBuModuleName, string strMsg)
        {
            m_oLogger.Error(TEMPLATE_FILELOG, strBuModuleName, strMsg);
        }

        /// <summary>
        /// warn log
        /// </summary>
        /// <param name="strBuModuleName">bu module name</param>
        /// <param name="strMsg">log content</param>
        public static void warn4Sys(string strBuModuleName, string strMsg)
        {
            m_oLogger.Warn(TEMPLATE_FILELOG, strBuModuleName, strMsg);
        }

        /// <summary>
        /// info log
        /// </summary>
        /// <param name="strBuModuleName">bu module name</param>
        /// <param name="strMsg">log content</param>
        public static void info4Sys(string strBuModuleName, string strMsg)
        {
            m_oLogger.Info(TEMPLATE_FILELOG, strBuModuleName, strMsg);
        }

        /// <summary>
        /// debug log
        /// </summary>
        /// <param name="strBuModuleName">bu module name</param>
        /// <param name="strMsg">log content</param>
        public static void debug4Sys(string strBuModuleName, string strMsg)
        {
            m_oLogger.Debug(TEMPLATE_FILELOG, strBuModuleName, strMsg);
        }

        /// <summary>
        /// trace log
        /// </summary>
        /// <param name="strBuModuleName">bu module name</param>
        /// <param name="strMsg">log content</param>
        public static void trace4Sys(string strBuModuleName, string strMsg)
        {
            m_oLogger.Trace(TEMPLATE_FILELOG, strBuModuleName, strMsg);
        }

        #endregion
    }
}
