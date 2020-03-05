using core_fw_spring_express.widget.usercontrol;
using DevExpress.XtraEditors;
using DevExpress.XtraLayout;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace core_fw_spring_express.widget.layout
{
    public class DevLayoutUtils
    {
        #region Const

        public static readonly string NAME_LAYOUT = "LAYOUT_";
        public static readonly string NAME_ROOT = "ROOT_";
        public static readonly string NAME_GROUP = "GROUP_";
        public static readonly string NAME_ITEM_CONTAINER = "ITEM_CONTAINER_";
        public static readonly string NAME_ITEM_COMBO = "COMBO_";
        public static readonly string NAME_ITEM_TEXT = "TEXTBOX_";

        #endregion

        #region addLayout

        public static LayoutControl addLayout(string strName, string strText, Control oParent)
        {
            //clear
            foreach (Control oChildControl in oParent.Controls)
            {
                oChildControl.Dispose();
            }
            oParent.Controls.Clear();

            var oRoot = new LayoutControlGroup();
            oRoot.Name = NAME_ROOT + strName;
            oRoot.EnableIndentsWithoutBorders = DevExpress.Utils.DefaultBoolean.True;
            oRoot.GroupBordersVisible = false;
            oRoot.TextVisible = false;

            var oLayout = new LayoutControl();
            oLayout.Name = NAME_LAYOUT + strName;
            oLayout.Text = strText;
            oLayout.Dock = DockStyle.Fill;
            oLayout.Root = oRoot;
            oParent.Controls.Add(oLayout);

            return oLayout;
        }

        public static void layoutBegin(LayoutControl oLayout)
        {
            ((System.ComponentModel.ISupportInitialize)(oLayout)).BeginInit();
        }

        public static void layoutEnd(LayoutControl oLayout)
        {
            ((System.ComponentModel.ISupportInitialize)(oLayout)).EndInit();
        }

        #endregion

        #region addGroup

        public static LayoutControlGroup addGroup(string strName, string strText, LayoutControl oParent)
        {
            var oGroup = new LayoutControlGroup();

            oGroup.Name = NAME_GROUP + strName;
            oGroup.Text = strText;
            oParent.Root.Items.AddRange(new DevExpress.XtraLayout.BaseLayoutItem[] { oGroup });

            return oGroup;
        }

        #endregion

        #region addItem

        public static ComboBoxEdit addItemCombo(string strName, string strLabelText, List<string> lstValues, string strDefaultVal,
            bool bIsReadOnly, LayoutControl oParent, LayoutControlGroup oGroup = null)
        {
            var oCombo = new ComboBoxEdit();
            ((System.ComponentModel.ISupportInitialize)(oCombo.Properties)).BeginInit();
            oCombo.Name = NAME_ITEM_COMBO + strName;
            oCombo.Enabled = !bIsReadOnly;
            oCombo.Properties.Buttons.AddRange(new DevExpress.XtraEditors.Controls.EditorButton[] {
            new DevExpress.XtraEditors.Controls.EditorButton(DevExpress.XtraEditors.Controls.ButtonPredefines.Combo)});
            oCombo.Properties.Items.AddRange(lstValues);
            oCombo.SelectedItem = strDefaultVal;
            oCombo.StyleController = oParent;
            oParent.Controls.Add(oCombo);
            ((System.ComponentModel.ISupportInitialize)(oCombo.Properties)).EndInit();

            var oItemContainer = new LayoutControlItem();
            oItemContainer.Name = NAME_ITEM_CONTAINER + strName;
            oItemContainer.Text = strLabelText;
            oItemContainer.Control = oCombo;
            if (null == oGroup)
            {
                oParent.Root.Items.AddRange(new BaseLayoutItem[] { oItemContainer });
            }
            else
            {
                oGroup.Items.AddRange(new BaseLayoutItem[] { oItemContainer });
            }

            return oCombo;
        }

        public static TextEdit addItemText(string strName, string strLabelText, string strDefaultVal, bool bIsReadOnly,
            LayoutControl oParent, LayoutControlGroup oGroup = null)
        {
            var oTextEdit = new TextEdit();
            oTextEdit.Name = NAME_ITEM_TEXT + strName;
            oTextEdit.Text = strDefaultVal;
            oTextEdit.Enabled = !bIsReadOnly;
            oTextEdit.StyleController = oParent;
            oParent.Controls.Add(oTextEdit);

            var oItemContainer = new LayoutControlItem();
            oItemContainer.Name = NAME_ITEM_CONTAINER + strName;
            oItemContainer.Text = strLabelText;
            oItemContainer.Control = oTextEdit;
            if (null == oGroup)
            {
                oParent.Root.Items.AddRange(new BaseLayoutItem[] { oItemContainer });
            }
            else
            {
                oGroup.Items.AddRange(new BaseLayoutItem[] { oItemContainer });
            }

            return oTextEdit;
        }

        #endregion

        #region getHeight

        public static int getHeight(int iRowCount)
        {
            return iRowCount * 27;
        }

        #endregion
    }
}
