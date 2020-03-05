using DevExpress.XtraBars.Ribbon;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.ribbon.vo
{
    public class DevRibbonPageVo
    {
        #region Fields

        private RibbonControl ribbonControl;
        private RibbonPage ribbonPage;
        private List<DevRibbonGroupVo> children = new List<DevRibbonGroupVo>();

        [JsonIgnore()]
        public RibbonControl RibbonControl { get => ribbonControl; set => ribbonControl = value; }
        [JsonIgnore()]
        public RibbonPage RibbonPage { get => ribbonPage; set => ribbonPage = value; }
        public List<DevRibbonGroupVo> Children { get => children; set => children = value; }

        #endregion
    }
}
