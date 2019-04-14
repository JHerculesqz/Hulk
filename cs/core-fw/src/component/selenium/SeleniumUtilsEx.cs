using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using walle.component.serial;

namespace walle.component.selenium
{
    public class SeleniumUtilsEx
    {
        #region chromeDriver

        public static IWebDriver initChromeDriver(int iTimeoutSec)
        {
            IWebDriver oIWebDriver = new ChromeDriver();

            var oTimeSpan = new TimeSpan(10000000 * iTimeoutSec);
            oIWebDriver.Manage().Timeouts().ImplicitWait = oTimeSpan;

            return oIWebDriver;
        }

        public static void killChromeDriver(IWebDriver oIWebDriver)
        {
            if (oIWebDriver != null)
            {
                oIWebDriver.Quit();
            }
        }

        #endregion

        #region toUrl

        public static void toUrl(String strUrl, IWebDriver oIWebDriver)
        {
            oIWebDriver.Manage().Window.Maximize();
            oIWebDriver.Navigate().GoToUrl(strUrl);
        }

        #endregion

        #region cookies

        public static void delAllCookies(IWebDriver oIWebDriver)
        {
            oIWebDriver.Manage().Cookies.DeleteAllCookies();
        }

        public static ReadOnlyCollection<Cookie> getAllCookies(IWebDriver oIWebDriver)
        {
            ReadOnlyCollection<Cookie> lstRes = oIWebDriver.Manage().Cookies.AllCookies;
            return lstRes;
        }

        public static byte[] getAllCookies4Byte(IWebDriver oIWebDriver)
        {
            ReadOnlyCollection<Cookie> lstCookie = oIWebDriver.Manage().Cookies.AllCookies;

            List<Dictionary<string, object>> lstCookieEx = new List<Dictionary<string, object>>();
            foreach (var oCookie in lstCookie)
            {
                var mapCookie = new Dictionary<string, object>();
                mapCookie.Add("domain", oCookie.Domain);
                mapCookie.Add("expiry", oCookie.Expiry);
                mapCookie.Add("name", oCookie.Name);
                mapCookie.Add("path", oCookie.Path);
                mapCookie.Add("Secure", oCookie.Secure);
                mapCookie.Add("value", oCookie.Value);

                lstCookieEx.Add(mapCookie);
            }

            var arrRes = SerialUtilsEx.serializeObject(lstCookieEx);
            return arrRes;
        }

        public static void addCookieByByte(byte[] arrByte, IWebDriver oIWebDriver)
        {
            var lstCookieEx = (List<Dictionary<string, object>>)SerialUtilsEx.deserializeObject(arrByte);

            foreach (var mapCookie in lstCookieEx)
            {
                var oCookie = Cookie.FromDictionary(mapCookie);
                ICookieJar oICookieJar = oIWebDriver.Manage().Cookies;
                oICookieJar.AddCookie(oCookie);
            }
        }

        #endregion

        #region navi

        public static void refresh(IWebDriver oIWebDriver)
        {
            oIWebDriver.Navigate().Refresh();
        }

        #endregion

        #region find

        public static IWebElement findBy(By oBy, IWebDriver oIWebDriver)
        {
            IWebElement oEle = oIWebDriver.FindElement(oBy);
            return oEle;
        }

        public static ReadOnlyCollection<IWebElement> findLstBy(By oBy, IWebDriver oIWebDriver)
        {
            var lstEle = oIWebDriver.FindElements(oBy);
            return lstEle;
        }

        public static IWebElement findByAttr(string strAttrKey, string strAttrVal, ReadOnlyCollection<IWebElement> lstEle)
        {
            foreach (var oEle in lstEle)
            {
                if (oEle.GetAttribute(strAttrKey) != null)
                {
                    if (oEle.GetAttribute(strAttrKey).Equals(strAttrVal))
                    {
                        return oEle;
                    }
                }
            }

            return null;
        }

        public static IWebElement findByText(string strText, ReadOnlyCollection<IWebElement> lstEle)
        {
            foreach (var oEle in lstEle)
            {
                if (oEle.Text.Equals(strText))
                {
                    return oEle;
                }
            }

            return null;
        }

        #endregion
    }
}
