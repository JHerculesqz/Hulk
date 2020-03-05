using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.chart.vo
{
    public class Chart2YDataVo : ObservableCollection<Chart2YDataItemVo>
    {
        #region addRange

        public void addRange(List<Chart2YDataItemVo> lstItemVo)
        {
            foreach (var oItemVo in lstItemVo)
            {
                this.Items.Add(oItemVo);
            }

            this.OnCollectionChanged(new NotifyCollectionChangedEventArgs(
                NotifyCollectionChangedAction.Add, lstItemVo, Items.Count - lstItemVo.Count));
        }

        #endregion

        #region removeRange

        public void removeRange(int iIndexStart, int iCount)
        {
            var lstRemoveItemVo = new List<Chart2YDataItemVo>(iCount);
            for (int i = 0; i < iCount; i++)
            {
                lstRemoveItemVo.Add(this.Items[iIndexStart]);
                Items.RemoveAt(iIndexStart);
            }
            if (iCount > 0)
            {
                OnCollectionChanged(new NotifyCollectionChangedEventArgs(
                    NotifyCollectionChangedAction.Remove, lstRemoveItemVo, iIndexStart));
            }
        }

        #endregion
    }
}
