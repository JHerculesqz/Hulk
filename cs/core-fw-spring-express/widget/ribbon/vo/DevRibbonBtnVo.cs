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
    public class DevRibbonBtnVo
    {
        #region Const

        public static readonly string TYPE_SIMPLE = "TYPE_SIMPLE";
        public static readonly string TYPE_COMPLEX = "TYPE_COMPLEX";
        public static readonly string TYPE_MENU = "TYPE_MENU";

        #endregion

        #region Fields

        #region common

        private int id;
        private string name;
        private string text;
        private string type;
        private string filePathSvg;

        #endregion

        #region simpleBtn

        private RibbonItemStyles style4SimpleBtn;
        private ItemClickEventHandler callback4SimpleBtn;

        #endregion

        #region complexBtn

        private RibbonItemStyles style4ComplexBtn;
        private List<DevComplexBtnItemVo> children4ComplexBtn = new List<DevComplexBtnItemVo>();

        #endregion

        #region menuBtn

        private BarButtonStyle style4MenuBtn;
        private ItemClickEventHandler callback4MenuBtn;
        private DevMenuBtnItemContainerVo child4MenuBtn = new DevMenuBtnItemContainerVo();

        #endregion

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Text { get => text; set => text = value; }
        public string Type { get => type; set => type = value; }
        public string FilePathSvg { get => filePathSvg; set => filePathSvg = value; }
        [JsonIgnore()]
        public string FilePathSvgEx
        {
            get => Path.Combine(AppDomain.CurrentDomain.BaseDirectory, filePathSvg);
        }
        public RibbonItemStyles Style4SimpleBtn { get => style4SimpleBtn; set => style4SimpleBtn = value; }
        [JsonIgnore()]
        public ItemClickEventHandler Callback4SimpleBtn { get => callback4SimpleBtn; set => callback4SimpleBtn = value; }
        public RibbonItemStyles Style4ComplexBtn { get => style4ComplexBtn; set => style4ComplexBtn = value; }
        public List<DevComplexBtnItemVo> Children4ComplexBtn { get => children4ComplexBtn; set => children4ComplexBtn = value; }
        public BarButtonStyle Style4MenuBtn { get => style4MenuBtn; set => style4MenuBtn = value; }
        [JsonIgnore()]
        public ItemClickEventHandler Callback4MenuBtn { get => callback4MenuBtn; set => callback4MenuBtn = value; }
        public DevMenuBtnItemContainerVo Child4MenuBtn { get => child4MenuBtn; set => child4MenuBtn = value; }
        
        #endregion
    }
}
