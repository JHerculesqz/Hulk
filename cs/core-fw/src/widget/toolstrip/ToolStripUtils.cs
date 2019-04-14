using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_csharp.src.widget.toolstrip
{
    public class ToolStripUtils
    {
        #region Fields

        private static ToolStripUtils m_oInstance;

        private bool m_bHidePwd = true;

        private List<ToolStripButton> m_lstToggleBtn = new List<ToolStripButton>();

        #endregion

        #region Construction

        private ToolStripUtils()
        {

        }

        public static ToolStripUtils getInstance()
        {
            if (null == m_oInstance)
            {
                m_oInstance = new ToolStripUtils();
            }

            return m_oInstance;
        }

        #endregion

        #region toggleHide

        public void toggleHide(ToolStripTextBox oToolStripTextBox)
        {
            if (this.m_bHidePwd)
            {
                oToolStripTextBox.TextBox.PasswordChar = '*';
            }
            else
            {
                oToolStripTextBox.TextBox.PasswordChar = new char();
            }

            this.m_bHidePwd = !this.m_bHidePwd;
        }

        #endregion

        #region toggle

        public void init4Toggle(params ToolStripButton[] arrToolStripButton)
        {
            this.m_lstToggleBtn.AddRange(arrToolStripButton);
        }

        public void toggle(ToolStripButton oSender)
        {
            foreach (ToolStripButton oBtn in this.m_lstToggleBtn)
            {
                if (oBtn.Name == oSender.Name)
                {
                    oBtn.Checked = !oBtn.Checked;
                }
                else
                {
                    oBtn.Checked = false;
                }
            }
        }

        #endregion

        #region getSelectToolStripBtn

        public ToolStripButton getSelectToolStripBtn()
        {
            for (var iIndex = 0; iIndex < this.m_lstToggleBtn.Count; iIndex++)
            {
                var oBtn = this.m_lstToggleBtn[iIndex];
                if (oBtn.Checked)
                {
                    return oBtn;
                }
            }

            return null;
        }

        public int getSelectToolStripBtnIndex()
        {
            for (var iIndex = 0; iIndex < this.m_lstToggleBtn.Count; iIndex++)
            {
                var oBtn = this.m_lstToggleBtn[iIndex];
                if (oBtn.Checked)
                {
                    return iIndex;
                }
            }

            return -1;
        }

        #endregion

        #region addComboItems

        public void addComboItem(ToolStripComboBox oToolStripCombo, List<String> lstItems)
        {
            foreach (var strItem in lstItems)
            {
                oToolStripCombo.Items.Add(strItem);
            }
        }

        #endregion
    }
}
