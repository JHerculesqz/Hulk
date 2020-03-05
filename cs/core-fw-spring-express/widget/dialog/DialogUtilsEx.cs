using DevExpress.XtraEditors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.dialog
{
    public class DialogUtilsEx
    {
        public static void initOpenFile(string strFilter, Action<string> oActionCallback, bool bMut = false)
        {
            var openFileDialog = new XtraOpenFileDialog();
            openFileDialog.Filter = strFilter;
            openFileDialog.Multiselect = bMut;
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                var strFile = openFileDialog.FileName;
                oActionCallback(strFile);
            }
        }

        public static void initSaveFile(string strDefaulteFileName, string strFilter, string strDefaultExt, Action<string> oActionCallback)
        {
            var saveFileDialog = new XtraSaveFileDialog();
            saveFileDialog.Filter = strFilter;//设置文件类型
            saveFileDialog.FileName = strDefaulteFileName;//设置默认文件名
            saveFileDialog.DefaultExt = strDefaultExt;//设置默认格式（可以不设）
            saveFileDialog.AddExtension = true;//设置自动在文件名中添加扩展名
            if (saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                oActionCallback(saveFileDialog.FileName);
            }
        }
    }
}
