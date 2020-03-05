using core_fw.sqlite;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace test_core_fw_db_sqlite
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void m_buttonTest4DBSqlite_Click(object sender, EventArgs e)
        {
            //1.创建数据库
            SQLiteUtil.createDB("testSqlite.db");
            //2.创建表
            var strCreateTableSql = @"CREATE TABLE tbl_Config 
                (ModelName TEXT,
                NodePath TEXT,
                NodeValue TEXT,
                UpdateTime DATETIME,
                PRIMARY KEY (ModelName,NodePath));";
            SQLiteUtil.createDT("tbl_Config", strCreateTableSql);
            //3.插入数据
            var strUpsertSql = "REPLACE INTO tbl_Config(ModelName,NodePath,NodeValue,UpdateTime)" +
                                          "VALUES(@ModelName,@NodePath,@NodeValue,@UpdateTime)";
            Dictionary<string, object> oUpsertParams = new Dictionary<string, object>();
            oUpsertParams.Add("ModelName", "ModelName");
            oUpsertParams.Add("NodePath", "NodePath");
            oUpsertParams.Add("NodeValue", Convert.ToString("NodeValue"));
            oUpsertParams.Add("UpdateTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
            SQLiteUtil.execSQL(strUpsertSql, oUpsertParams);
            //4.查询
            var strSelectSql = "SELECT ModelName,NodePath,NodeValue,UpdateTime FROM tbl_Config " +
                "WHERE ModelName=@ModelName AND NodePath=@NodePath";
            Dictionary<string, object> oSelectParams = new Dictionary<string, object>();
            oSelectParams.Add("ModelName", "ModelName");
            oSelectParams.Add("NodePath", "NodePath");
            DataTable dt = SQLiteUtil.execDataTable(strSelectSql, oSelectParams);
            if (dt.Rows.Count > 0)
            {
                Console.WriteLine(dt.Rows[0]["NodeValue"]);
            }

            //5.batch insert
            SQLiteUtil.execQueryTrans((oTrans) =>
            {
                for (int i = 0; i < 10; i++)
                {
                    var strBatchCreateSql = "REPLACE INTO tbl_Config(ModelName,NodePath,NodeValue,UpdateTime)" +
                                                  "VALUES(@ModelName,@NodePath,@NodeValue,@UpdateTime)";
                    Dictionary<string, object> ups = new Dictionary<string, object>();
                    ups.Add("ModelName", "ModelName");
                    ups.Add("NodePath", "ModelName/NodePath" + i);
                    ups.Add("NodeValue", Convert.ToString(i));
                    ups.Add("UpdateTime", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
                    SQLiteUtil.execQueryTransCallBack(oTrans, strBatchCreateSql, ups);
                }
            });

            //6.batch select
            var strBatchSelectSql = "SELECT ModelName,NodePath,NodeValue,UpdateTime FROM tbl_Config " +
                "WHERE ModelName=@ModelName";
            Dictionary<string, object> oBatchSelectParams = new Dictionary<string, object>();
            oBatchSelectParams.Add("ModelName", "ModelName");
            DataTable dtBatch = SQLiteUtil.execDataTable(strBatchSelectSql, oBatchSelectParams);
            if (dtBatch.Rows.Count > 0)
            {
                foreach (DataRow oRows in dtBatch.Rows)
                {
                    Console.WriteLine(oRows["NodeValue"]);
                }
               
            }
        }
    }
}
