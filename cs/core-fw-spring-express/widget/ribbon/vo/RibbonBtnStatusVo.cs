using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.ribbon.vo
{
    /// <summary>
    /// RibbonBtnStatusVo
    /// </summary>
    public class RibbonBtnStatusVo
    {
        #region Fields

        private string ribbonPageName;
        private string ribbonBtnName;
        private bool isEnable = true;
        private bool isVisible = true;

        public string RibbonPageName { get => ribbonPageName; set => ribbonPageName = value; }
        public string RibbonBtnName { get => ribbonBtnName; set => ribbonBtnName = value; }
        public bool IsEnable { get => isEnable; set => isEnable = value; }
        public bool IsVisible { get => isVisible; set => isVisible = value; }

        #endregion
    }
}
