using DevExpress.XtraBars;
using DevExpress.XtraBars.Ribbon;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.ribbon.vo
{
    public class DevMenuBtnItemContainerVo
    {
        #region Fields
        
        private string name;
        private List<DevMenuBtnItemVo> children = new List<DevMenuBtnItemVo>();

        public string Name { get => name; set => name = value; }
        public List<DevMenuBtnItemVo> Children { get => children; set => children = value; }

        #endregion
    }
}
