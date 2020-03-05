using core_fw_spring_express.widget.chart.vo;
using DevExpress.XtraCharts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.chart
{
    public class ChartUtilsEx
    {
        #region initData

        public static void init2YData(Chart2YDataVo oDataVo, ChartControl oChart)
        {
            oChart.BeginInit();
            oChart.DataSource = oDataVo;
            oChart.EndInit();
        }

        #endregion
    }
}
