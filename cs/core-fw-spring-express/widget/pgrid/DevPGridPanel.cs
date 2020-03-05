using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using DevExpress.XtraEditors;
using core_fw_spring_express.widget.pgrid.vo;
using core_fw_spring_express.widget.layout;
using DevExpress.XtraLayout;
using core_fw_spring_express.widget.panel;

namespace core_fw_spring_express.widget.pgrid
{
    public partial class DevPGridPanel : DevExpress.XtraEditors.XtraUserControl
    {
        #region Fields

        private LayoutControl m_oLayoutControl;
        private LayoutControlGroup m_oLayoutControlGroup;
        private Dictionary<string, RowVo> m_mapRow = new Dictionary<string, RowVo>();

        #endregion

        #region Construction

        public DevPGridPanel()
        {
            InitializeComponent();
        }

        #endregion

        #region init

        public void init(string strName, string strText, List<RowVo> lstRow4Key, Action<object, EventArgs> oCallbackPropertyChange)
        {
            this.m_mapRow.Clear();

            this.m_oLayoutControl = DevLayoutUtils.addLayout(strName, strText, this);
            DevLayoutUtils.layoutBegin(this.m_oLayoutControl);

            this.m_oLayoutControlGroup = DevLayoutUtils.addGroup(strName, strText, this.m_oLayoutControl);
            foreach (var oRowVo4Key in lstRow4Key)
            {
                if (oRowVo4Key.type == RowVo.TYPE_TEXT)
                {
                    var oTextBox = DevLayoutUtils.addItemText(oRowVo4Key.name, oRowVo4Key.labelText, oRowVo4Key.defaultVal,
                        oRowVo4Key.isReadOnly, this.m_oLayoutControl, this.m_oLayoutControlGroup);
                    oTextBox.TextChanged += new EventHandler(oCallbackPropertyChange);
                    oRowVo4Key.textBox = oTextBox;
                    oTextBox.Tag = oRowVo4Key;
                    this.m_mapRow.Add(oRowVo4Key.name, oRowVo4Key);
                }
                else if (oRowVo4Key.type == RowVo.TYPE_COMBO || oRowVo4Key.type == RowVo.TYPE_CHOICE)
                {
                    var oCombo = DevLayoutUtils.addItemCombo(oRowVo4Key.name, oRowVo4Key.labelText, oRowVo4Key.values,
                        oRowVo4Key.defaultVal, oRowVo4Key.isReadOnly, this.m_oLayoutControl, this.m_oLayoutControlGroup);
                    oCombo.SelectedValueChanged += new EventHandler(oCallbackPropertyChange);
                    oRowVo4Key.combo = oCombo;
                    oCombo.Tag = oRowVo4Key;
                    this.m_mapRow.Add(oRowVo4Key.name, oRowVo4Key);
                }
            }

            DevLayoutUtils.layoutEnd(this.m_oLayoutControl);
        }

        #endregion

        #region getValues

        public Dictionary<string, RowVo> getValues()
        {
            lock (this)
            {
                return this.m_mapRow;
            }
        }

        #endregion

        #region updateValues

        public void updateValues(List<RowVo> lstRow4Value)
        {
            lock (this)
            {
                foreach (var oRowVo4Value in lstRow4Value)
                {
                    if (this.m_mapRow.ContainsKey(oRowVo4Value.name))
                    {
                        var oRowVo4Key = this.m_mapRow[oRowVo4Value.name];
                        oRowVo4Key.defaultVal = oRowVo4Value.defaultVal;
                        if (oRowVo4Key.type == RowVo.TYPE_TEXT)
                        {
                            var oTextBox = oRowVo4Key.textBox;
                            oTextBox.Tag = oRowVo4Key;
                            oTextBox.Text = oRowVo4Key.defaultVal;
                        }
                        else if (oRowVo4Key.type == RowVo.TYPE_COMBO || oRowVo4Key.type == RowVo.TYPE_CHOICE)
                        {
                            var oCombo = oRowVo4Key.combo;
                            oCombo.Tag = oRowVo4Key;
                            oCombo.Text = oRowVo4Key.defaultVal;
                        }
                    }
                }
            }
        }

        #endregion
    }
}
