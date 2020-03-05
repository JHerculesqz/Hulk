using DevExpress.XtraBars;
using DevExpress.XtraBars.Ribbon;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace core_fw_spring_express.widget.ribbon.vo
{
    public class DevComplexBtnItemVo
    {
        #region Fields
        
        private int id;
        private string name;
        private string text;
        private RibbonItemStyles style;
        private string filePathSvg;
        private ItemClickEventHandler callback;

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Text { get => text; set => text = value; }
        public RibbonItemStyles Style { get => style; set => style = value; }
        public string FilePathSvg { get => filePathSvg; set => filePathSvg = value; }
        [JsonIgnore()]
        public string FilePathSvgEx
        {
            get => Path.Combine(AppDomain.CurrentDomain.BaseDirectory, filePathSvg);
        }
        [JsonIgnore()]
        public ItemClickEventHandler Callback { get => callback; set => callback = value; }

        #endregion
    }
}
