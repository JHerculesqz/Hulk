using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using core_fw.widget.grid;
using core_fw.widget.grid.vo;
using DevExpress.XtraGrid.Columns;

namespace test_core_fw.widget.grid
{
    public partial class GridControl : UserControl
    {
        #region Fields

        private GridPanel m_oGridPanel;

        #endregion

        public GridControl()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.m_oGridPanel = new GridPanel();
            this.m_oGridPanel.init(this.panel1, true, true);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            List<ColumnVo> lstColVo = new List<ColumnVo>();

            ColumnVo oColumnVo1 = new ColumnVo();
            oColumnVo1.ColName = "ID";
            oColumnVo1.ColText = "属性名称";
            oColumnVo1.Width = 120;
            lstColVo.Add(oColumnVo1);
            ColumnVo oColumnVo2 = new ColumnVo();
            oColumnVo2.ColName = "Name";
            oColumnVo2.ColText = "属性值";
            oColumnVo2.Width = 200;
            lstColVo.Add(oColumnVo2);
            ColumnVo oColumnVo3 = new ColumnVo();
            oColumnVo3.ColName = GridPanel.OP_EDIT;
            oColumnVo3.ColText = "编辑";
            oColumnVo3.ColType = "link";
            oColumnVo3.Width = 80;
            lstColVo.Add(oColumnVo3);
            ColumnVo oColumnVo4 = new ColumnVo();
            oColumnVo4.ColName = GridPanel.OP_DEL;
            oColumnVo4.ColText = "删除";
            oColumnVo4.ColType = "link";
            oColumnVo4.Width = 80;
            lstColVo.Add(oColumnVo4);
            this.m_oGridPanel.setCols(lstColVo);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            List<RowVo> lstRowVo = new List<RowVo>();
            for (int i = 0; i < 2; i++)
            {
                RowVo oRowVo = new RowVo();
                oRowVo.Cells.Add("Row" + i + "Col1");
                oRowVo.Cells.Add("Row" + i + "Col2");
                oRowVo.Cells.Add("编辑");
                oRowVo.Cells.Add("删除");
                lstRowVo.Add(oRowVo);
            }
            this.m_oGridPanel.clearAndAddRows(lstRowVo);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            RowVo oRowVo = new RowVo();
            oRowVo.Cells.Add("RowAddCol1");
            oRowVo.Cells.Add("RowAddCol2");
            oRowVo.Cells.Add("编辑");
            oRowVo.Cells.Add("删除");
            this.m_oGridPanel.clearAndAddRow(oRowVo);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            List<RowVo> lstRowVo = new List<RowVo>();
            for (int i = 0; i < 2; i++)
            {
                RowVo oRowVo = new RowVo();
                oRowVo.Cells.Add("Row" + i + "Col1");
                oRowVo.Cells.Add("Row" + i + "Col2");
                oRowVo.Cells.Add("编辑");
                oRowVo.Cells.Add("删除");
                lstRowVo.Add(oRowVo);
            }
            this.m_oGridPanel.appendRows(lstRowVo);
        }

        private void button7_Click(object sender, EventArgs e)
        {
            RowVo oRowVo = new RowVo();
            oRowVo.Cells.Add("RowAddCol1");
            oRowVo.Cells.Add("RowAddCol2");
            oRowVo.Cells.Add("编辑");
            oRowVo.Cells.Add("删除");
            this.m_oGridPanel.appendRow(oRowVo);
        }

        private void button8_Click(object sender, EventArgs e)
        {
            this.m_oGridPanel.clearRow();
        }
    }
}
