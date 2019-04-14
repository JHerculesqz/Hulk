using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace walle.component.process
{
    public class ProcessUtilsEx
    {
        public static void run(string strFilePath, string strArgs)
        {
            Process p = new Process();
            p.StartInfo.FileName = strFilePath;
            p.StartInfo.Arguments = strArgs;
            p.StartInfo.UseShellExecute = false;
            p.StartInfo.RedirectStandardInput = true;
            p.StartInfo.RedirectStandardOutput = true;
            p.StartInfo.CreateNoWindow = false;
            p.Start();
        }
    }
}
