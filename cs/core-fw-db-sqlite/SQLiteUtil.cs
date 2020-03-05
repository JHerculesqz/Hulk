using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Common;
using System.Data.SQLite;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw.sqlite
{
    /// <summary>
    /// SQLiteUtil
    /// </summary>
    public class SQLiteUtil
    {
        #region Fields

        private static string m_strDBName;

        #endregion

        #region createDB

        /// <summary>
        /// create database
        /// </summary>
        /// <param name="strDBName">db name</param>
        public static void createDB(string strDBName)
        {
            m_strDBName = strDBName;

            //判断数据文件是否存在
            bool dbExist = File.Exists(m_strDBName);
            if (!dbExist)
            {
                SQLiteHelper.CreateFile(m_strDBName);
            }
        }

        #endregion

        #region createDT

        /// <summary>
        /// create table
        /// </summary>
        /// <param name="strTableName">table name</param>
        /// <param name="strCreateTableSql">create table sql</param>
        /// <returns>true:create success</returns>
        public static bool createDT(string strTableName, string strCreateTableSql)
        {
            using (IDbConnection conn = SQLiteHelper.CreateConnection(m_strDBName))
            {
                var strSelectSql = "SELECT count(*) FROM sqlite_master WHERE type = 'table' AND name = @TableName";
                Dictionary<string, object> parameters = new Dictionary<string, object>();
                parameters.Add("TableName", strTableName);
                object ob = SQLiteHelper.ExecuteScalar((SQLiteConnection)conn, strSelectSql, parameters);
                long tableCount = Convert.ToInt64(ob);
                if (tableCount == 0)
                {
                    int iRes = SQLiteHelper.ExecuteNonQuery((SQLiteConnection)conn, strCreateTableSql, parameters);
                    return iRes > 0;
                }
                return true;
            }
        }

        #endregion

        #region getDBCC

        /// <summary>
        /// get database connection
        /// </summary>
        /// <returns>IDbConnection</returns>
        public static IDbConnection getDBCC()
        {
            return SQLiteHelper.CreateConnection(m_strDBName);
        }

        #endregion

        #region getDBTS

        /// <summary>
        /// get database trans
        /// </summary>
        /// <returns>IDbTransaction</returns>
        public static IDbTransaction getDBTS()
        {
            IDbConnection oIDbConnection = SQLiteHelper.CreateConnection(m_strDBName);
            IDbTransaction trans = oIDbConnection.BeginTransaction();
            return trans;
        }

        #endregion

        #region exec

        /// <summary>
        /// exec sql
        /// </summary>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>record count</returns>
        public static int execSQL(string sql, Dictionary<string, object> parameters)
        {
            using (IDbConnection conn = SQLiteHelper.CreateConnection(m_strDBName))
            {
                return SQLiteHelper.ExecuteNonQuery((SQLiteConnection)conn, sql, parameters);
            }
        }

        /// <summary>
        /// exec sql
        /// </summary>
        /// <param name="conn"></param>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>record count</returns>
        public static int execSQL(IDbConnection conn, string sql, 
            Dictionary<string, object> parameters)
        {
            return SQLiteHelper.ExecuteNonQuery((SQLiteConnection)conn, sql, parameters);
        }

        /// <summary>
        /// exec trans
        /// </summary>
        /// <param name="oAction">SQLiteTransaction callback</param>
        public static void execQueryTrans(Action<SQLiteTransaction> oAction)
        {
            using (SQLiteConnection conn = SQLiteHelper.CreateConnection(m_strDBName))
            {
                conn.Open();
                DbTransaction trans = conn.BeginTransaction();
                try
                {
                    oAction((SQLiteTransaction)trans);
                    trans.Commit();
                }
                catch
                {
                    trans.Rollback();
                    throw;
                }
            }
        }

        /// <summary>
        /// exec trans callback
        /// </summary>
        /// <param name="oSQLiteTransaction">SQLiteTransaction</param>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>record count</returns>
        public static int execQueryTransCallBack(SQLiteTransaction oSQLiteTransaction, string sql,
            Dictionary<string, object> parameters)
        {
            return SQLiteHelper.ExecuteNonQuery(oSQLiteTransaction, sql, parameters);
        }

        #endregion

        #region query

        /// <summary>
        /// query dataset
        /// </summary>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>DataSet</returns>
        public static DataSet execDataset(string sql, Dictionary<string, object> parameters)
        {
            using (IDbConnection conn = SQLiteHelper.CreateConnection(m_strDBName))
            {
                return SQLiteHelper.ExecuteDataSet((SQLiteConnection)conn, sql, parameters);
            }
        }

        /// <summary>
        /// query datatable
        /// </summary>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>DataTable</returns>
        public static DataTable execDataTable(string sql, Dictionary<string, object> parameters)
        {
            DataTable dt = new DataTable();
            using (IDbConnection conn = SQLiteHelper.CreateConnection(m_strDBName))
            {
                using (IDataReader oIDataReader = SQLiteHelper.ExecuteReader((SQLiteConnection)conn, sql, parameters))
                {
                    dt.Load(oIDataReader);
                }
            }
            return dt;
        }

        /// <summary>
        /// query first cell
        /// </summary>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>object</returns>
        public static object execScalar(string sql, Dictionary<string, object> parameters)
        {
            using (IDbConnection conn = SQLiteHelper.CreateConnection(m_strDBName))
            {
                return execScalar(conn, sql, parameters);
            }
        }

        /// <summary>
        /// query first cell
        /// </summary>
        /// <param name="conn">db connection</param>
        /// <param name="sql">sql</param>
        /// <param name="parameters">parameters</param>
        /// <returns>object</returns>
        public static object execScalar(IDbConnection conn, string sql, Dictionary<string, object> parameters)
        {
            return execScalar(conn, sql, parameters);
        }

        #endregion
    }
}
