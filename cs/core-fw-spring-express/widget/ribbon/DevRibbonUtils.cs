using core_fw.widget.i18n;
using core_fw_spring_express.widget.ribbon.vo;
using DevExpress.Utils.Svg;
using DevExpress.XtraBars;
using DevExpress.XtraBars.Ribbon;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using walle.component.json;

namespace core_fw_spring_express.widget.ribbon
{
    /// <summary>
    /// 潜规则：1个App中所有的RibbonPage.Name必须全局唯一
    /// </summary>
    public class DevRibbonUtils
    {
        #region Fields

        private static DevRibbonPageMapVo m_oDevRibbonPageMapVo = new DevRibbonPageMapVo();

        #endregion

        #region trans

        public static void transStart(RibbonControl oSuperParent)
        {
            oSuperParent.BeginInit();
        }

        public static void transEnd(RibbonControl oSuperParent)
        {
            oSuperParent.EndInit();
        }

        #endregion

        #region page

        public static void initGroupLazy(string strFilePath4RibbonMenuConfig,
            ItemClickEventHandler oCallback4Click, EventHandler oCallback4Popup,
            RibbonControl oRibbonControl, RibbonPage oRibbonPage)
        {
            var oPageVo = JsonUtilsEx.toObjByFilePath<DevRibbonPageVo>(
                strFilePath4RibbonMenuConfig);
            initGroupLazy(oPageVo, oCallback4Click, oCallback4Popup,
                oRibbonControl, oRibbonPage);
        }

        public static void initGroupLazy(DevRibbonPageVo oPageVo,
            ItemClickEventHandler oCallback4Click, EventHandler oCallback4Popup,
            RibbonControl oRibbonControl, RibbonPage oRibbonPage)
        {
            //update oPageVo&m_oDevRibbonPageMapVo
            oPageVo.RibbonControl = oRibbonControl;
            oPageVo.RibbonPage = oRibbonPage;
            m_oDevRibbonPageMapVo.upsertMap(oRibbonPage.Name, oPageVo);

            //transaction start
            transStart(oPageVo.RibbonControl);

            foreach (var oGroupVo in oPageVo.Children)
            {
                //initGroup
                var oGroupOrign = initGroup(oGroupVo.Name, oGroupVo.Text,
                    oPageVo.RibbonPage);

                //initBtn
                foreach (var oBtnVo in oGroupVo.Children)
                {
                    //if is simple btn
                    if (oBtnVo.Type == DevRibbonBtnVo.TYPE_SIMPLE)
                    {
                        oBtnVo.Callback4SimpleBtn = oCallback4Click;
                        initSimpleBtn(oBtnVo.Id, oBtnVo.Name, oBtnVo.Text,
                            oBtnVo.Style4SimpleBtn, oBtnVo.FilePathSvgEx,
                            oBtnVo.Callback4SimpleBtn,
                            oPageVo.RibbonControl, oGroupOrign);
                    }
                    //if is complex btn
                    else if (oBtnVo.Type == DevRibbonBtnVo.TYPE_COMPLEX)
                    {
                        var oComplexBtnOrign = initComplexBtn(oBtnVo.Id, oBtnVo.Name, oBtnVo.Text,
                            oBtnVo.Style4ComplexBtn, oBtnVo.FilePathSvgEx,
                            oPageVo.RibbonControl, oGroupOrign);

                        foreach (var oCompleBtnItemVo in oBtnVo.Children4ComplexBtn)
                        {
                            oCompleBtnItemVo.Callback = oCallback4Click;
                            initComplexBtnItem(oCompleBtnItemVo.Id, oCompleBtnItemVo.Name, oCompleBtnItemVo.Text,
                                oCompleBtnItemVo.Style, oCompleBtnItemVo.FilePathSvgEx,
                                oCompleBtnItemVo.Callback,
                                oPageVo.RibbonControl, oComplexBtnOrign);
                        }
                    }
                    //if is menu btn
                    else if (oBtnVo.Type == DevRibbonBtnVo.TYPE_MENU)
                    {
                        oBtnVo.Callback4MenuBtn = oCallback4Click;
                        var oMenuBtnOrign = initMenuBtn(oBtnVo.Id, oBtnVo.Name, oBtnVo.Text,
                            oBtnVo.Style4MenuBtn, oBtnVo.FilePathSvgEx,
                            oBtnVo.Callback4MenuBtn,
                            oPageVo.RibbonControl, oGroupOrign);

                        var oMenuItemContainerOrigin = initMenuBtnItemContainer(
                            oBtnVo.Child4MenuBtn.Name,
                            oCallback4Popup,
                            oPageVo.RibbonControl, oMenuBtnOrign);

                        foreach (var oMenuItemVo in oBtnVo.Child4MenuBtn.Children)
                        {
                            oMenuItemVo.Callback = oCallback4Click;
                            initMenuBtnItem(oMenuItemVo.Id, oMenuItemVo.Name, oMenuItemVo.Text,
                                oMenuItemVo.Style, oMenuItemVo.FilePathSvgEx,
                                oMenuItemVo.Callback,
                                oPageVo.RibbonControl, oMenuItemContainerOrigin);
                        }
                    }
                }
            }

            //transaction end
            transEnd(oPageVo.RibbonControl);
        }

        #endregion

        #region group

        public static RibbonPageGroup initGroup(string strName, string strText,
            RibbonPage oPage)
        {
            var oGroup = new RibbonPageGroup();

            //set props
            oGroup.Name = strName;
            var strLan = I18nUtilsEx.getStrFromApp(strName);
            oGroup.Text = String.IsNullOrEmpty(strLan)
                                                ? strText
                                                : strLan;
            //add to parent
            oPage.Groups.Add(oGroup);

            return oGroup;
        }

        #endregion

        #region simpleBtn

        public static BarButtonItem initSimpleBtn(int strId, string strName, string strText,
            RibbonItemStyles eStyle, string strFilePathSvg,
            ItemClickEventHandler oCallback4Click,
            RibbonControl oParentSuper, RibbonPageGroup oParent4Group)
        {
            var oButton = new BarButtonItem();

            //set props
            oButton.Id = strId;
            oButton.Name = strName;
            var strLan = I18nUtilsEx.getStrFromApp(strName);
            oButton.Caption = String.IsNullOrEmpty(strLan)
                                                ? strText
                                                : strLan;
            oButton.RibbonStyle = eStyle;
            oButton.ImageOptions.SvgImage = SvgImage.FromFile(strFilePathSvg);
            oButton.ItemClick += oCallback4Click;

            //add to parent
            oParentSuper.Items.Add(oButton);
            oParent4Group.ItemLinks.Add(oButton);

            return oButton;
        }

        #endregion

        #region complexBtn

        public static BarSubItem initComplexBtn(int strId, string strName, string strText,
            RibbonItemStyles eStyle, string strFilePathSvg,
            RibbonControl oParentSuper, RibbonPageGroup oParent4Group)
        {
            var oComplexBtn = new BarSubItem();

            //set props
            oComplexBtn.Id = strId;
            oComplexBtn.Name = strName;
            var strLan = I18nUtilsEx.getStrFromApp(strName);
            oComplexBtn.Caption = String.IsNullOrEmpty(strLan)
                                                ? strText
                                                : strLan;
            oComplexBtn.RibbonStyle = eStyle;
            oComplexBtn.ImageOptions.SvgImage = SvgImage.FromFile(strFilePathSvg);

            //add to parent
            oParentSuper.Items.Add(oComplexBtn);
            oParent4Group.ItemLinks.Add(oComplexBtn);

            return oComplexBtn;
        }

        public static BarButtonItem initComplexBtnItem(int strId, string strName, string strText,
            RibbonItemStyles eStyle, string strFilePathSvg,
            ItemClickEventHandler oCallback4Click,
            RibbonControl oParentSuper, BarSubItem oParent4ComplexBtn)
        {
            var oComplexBtnItem = new BarButtonItem();

            //set props
            oComplexBtnItem.Id = strId;
            oComplexBtnItem.Name = strName;
            var strLan = I18nUtilsEx.getStrFromApp(strName);
            oComplexBtnItem.Caption = String.IsNullOrEmpty(strLan)
                                                ? strText
                                                : strLan;
            oComplexBtnItem.RibbonStyle = eStyle;
            oComplexBtnItem.ImageOptions.SvgImage = SvgImage.FromFile(strFilePathSvg);
            oComplexBtnItem.ItemClick += oCallback4Click;

            //add to parent
            oParentSuper.Items.Add(oComplexBtnItem);
            oParent4ComplexBtn.LinksPersistInfo.Add(new LinkPersistInfo(oComplexBtnItem));

            return oComplexBtnItem;
        }

        #endregion

        #region menuBtn

        public static BarButtonItem initMenuBtn(int strId, string strName, string strText,
            BarButtonStyle eStyle, string strFilePathSvg,
            ItemClickEventHandler oCallback4Click,
            RibbonControl oParentSuper, RibbonPageGroup oParent4Group)
        {
            var oMenuBtn = new BarButtonItem();

            //set props
            oMenuBtn.Id = strId;
            oMenuBtn.Name = strName;
            var strLan = I18nUtilsEx.getStrFromApp(strName);
            oMenuBtn.Caption = String.IsNullOrEmpty(strLan)
                                                ? strText
                                                : strLan;
            oMenuBtn.ButtonStyle = eStyle;
            oMenuBtn.ImageOptions.SvgImage = SvgImage.FromFile(strFilePathSvg);
            oMenuBtn.ItemClick += oCallback4Click;

            //add to parent
            oParentSuper.Items.Add(oMenuBtn);
            oParent4Group.ItemLinks.Add(oMenuBtn);

            return oMenuBtn;
        }

        public static PopupMenu initMenuBtnItemContainer(string strName,
            EventHandler oCallback4Popup,
            RibbonControl oParentSuper, BarButtonItem oParent4MenuBtn)
        {
            var oMenuBtnItemContainer = new PopupMenu();

            //set props
            oMenuBtnItemContainer.Name = strName;
            oMenuBtnItemContainer.Popup += oCallback4Popup;

            //add to parent
            oMenuBtnItemContainer.Ribbon = oParentSuper;
            oParent4MenuBtn.DropDownControl = oMenuBtnItemContainer;

            return oMenuBtnItemContainer;
        }

        public static BarButtonItem initMenuBtnItem(int strId, string strName, string strText,
            RibbonItemStyles eStyle, string strFilePathSvg,
            ItemClickEventHandler oCallback4Click,
            RibbonControl oParentSuper, PopupMenu oParent4MenuBtnItemContainer)
        {
            var oMenuItem = new BarButtonItem();

            //set props
            oMenuItem.Id = strId;
            oMenuItem.Name = strName;
            var strLan = I18nUtilsEx.getStrFromApp(strName);
            oMenuItem.Caption = String.IsNullOrEmpty(strLan)
                                                ? strText
                                                : strLan;
            oMenuItem.RibbonStyle = eStyle;
            oMenuItem.ImageOptions.SvgImage = SvgImage.FromFile(strFilePathSvg);
            oMenuItem.ItemClick += oCallback4Click;

            //add to parent
            oParentSuper.Items.Add(oMenuItem);
            oParent4MenuBtnItemContainer.ItemLinks.Add(oMenuItem);

            return oMenuItem;
        }

        #endregion

        #region updateRibbonBtnItemStatus

        public static void updateRibbonBtnItemStatus(List<RibbonBtnStatusVo> lstRibbonBtnStatusVo)
        {
            foreach (var oRibbonBtnStatusVo in lstRibbonBtnStatusVo)
            {
                if (m_oDevRibbonPageMapVo.MapPageVo.ContainsKey(oRibbonBtnStatusVo.RibbonPageName))
                {
                    //get oDevRibbonPageVo
                    var oDevRibbonPageVo = m_oDevRibbonPageMapVo.MapPageVo[oRibbonBtnStatusVo.RibbonPageName];

                    //iter, update Enable and Visible
                    foreach (RibbonPageGroup oGroupOrign in oDevRibbonPageVo.RibbonPage.Groups)
                    {
                        foreach (var oBarItem in oGroupOrign.ItemLinks)
                        {
                            //if is SimpleBtn/MenuBtn
                            if (oBarItem is BarButtonItemLink)
                            {
                                var oBarItemEx = (oBarItem as BarButtonItemLink).Item;
                                if (oBarItemEx.Name == oRibbonBtnStatusVo.RibbonBtnName)
                                {
                                    oBarItemEx.Enabled = oRibbonBtnStatusVo.IsEnable;
                                    oBarItemEx.Visibility = oRibbonBtnStatusVo.IsVisible ? BarItemVisibility.Always :
                                        BarItemVisibility.Never;
                                }
                            }
                            //if is ComplexBtn
                            else if (oBarItem is BarSubItemLink)
                            {
                                var oBarItemEx = (oBarItem as BarSubItemLink).Item;
                                if (oBarItemEx.Name == oRibbonBtnStatusVo.RibbonBtnName)
                                {
                                    oBarItemEx.Enabled = oRibbonBtnStatusVo.IsEnable;
                                    oBarItemEx.Visibility = oRibbonBtnStatusVo.IsVisible ? BarItemVisibility.Always :
                                        BarItemVisibility.Never;
                                }
                            }
                        }
                    }
                }
            }
        }

        #endregion
    }
}
