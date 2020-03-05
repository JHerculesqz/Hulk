using DevExpress.XtraBars.Ribbon;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.ribbon.vo
{
    public class DevRibbonGroupVo
    {
        #region Fields

        private string name;
        private string text;
        private List<DevRibbonBtnVo> children = new List<DevRibbonBtnVo>();

        public string Name { get => name; set => name = value; }
        public string Text { get => text; set => text = value; }
        public List<DevRibbonBtnVo> Children { get => children; set => children = value; }

        #endregion
    }
}
