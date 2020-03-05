using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.chart.vo
{
    public class Chart2YDataItemVo
    {
        #region Fields

        private string x;
        private double y1;
        private double y2;

        public string X { get => x; set => x = value; }
        public double Y1 { get => y1; set => y1 = value; }
        public double Y2 { get => y2; set => y2 = value; }

        #endregion
    }
}
