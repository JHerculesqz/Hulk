using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace walle.component.file
{
    public class FileUtilsEx
    {
        #region openFolder

        public static void openFolder(String strFolderPath)
        {
            if (Directory.Exists(strFolderPath))
            {
                Process.Start("explorer", strFolderPath);
            }
        }

        #endregion

        #region findFile

        public static String findFile(String strFolderPath, String strFileName)
        {
            String strRes = "";

            List<String> lstFilePath = Directory.GetFiles(strFolderPath).ToList();

            foreach (var strFilePath in lstFilePath)
            {
                if (strFilePath.Contains(strFileName))
                {
                    strRes = strFilePath;
                    break;
                }
            }

            return strRes;
        }

        #endregion

        #region exists

        public static bool exists(String strFilePath)
        {
            return File.Exists(strFilePath);
        }

        #endregion

        #region folderExists

        public static bool folderExists(String strFolderPath)
        {
            return Directory.Exists(strFolderPath);
        }

        #endregion

        #region read

        public static byte[] readAllBytes(string strFile)
        {
            byte[] arrContent = null;
            if (!string.IsNullOrEmpty(strFile))
            {
                arrContent = File.ReadAllBytes(strFile);
            }
            return arrContent;
        }

        #endregion

        #region write

        public static void writeContent(string strContent, string strFile)
        {
            File.WriteAllText(strFile, strContent,Encoding.UTF8);
        }

        public static void writeAllBytes(byte[] arrContent, string strFile)
        {
             File.WriteAllBytes(strFile, arrContent);
          
        }

        #endregion
    }
}
