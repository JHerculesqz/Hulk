using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace walle.component.date
{
    public class DateUtilsEx
    {
        #region Const

        public static String TEMPLATE1 = "yyyy-MM-dd HH:mm:ss.fff";
        public static String TEMPLATE2 = "yyyy-MM-dd_HHmmss";

        #endregion

        #region isExpire

        public static bool isExpire(String strTimeStart, String strTimeEnd)
        {
            DateTime oTimeStart = DateTime.Parse(strTimeStart);
            DateTime oTimeEnd = DateTime.Parse(strTimeEnd);
            int iRes = DateTime.Compare(oTimeEnd, oTimeStart);
            if (iRes >= 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        #endregion

        #region generateTime

        public static String generateTime(String strTime, double iSecond, String strTemplate)
        {
            DateTime oTime = DateTime.Parse(strTime);
            oTime = oTime.AddSeconds(iSecond);
            String strRes = oTime.ToString(strTemplate);
            return strRes;
        }

        public static String generateTime4UTC(String strTime, double iSecond, String strTemplate)
        {
            DateTime oTime = DateTime.Parse(strTime);
            DateTime oTime4UTC = TimeZoneInfo.ConvertTimeToUtc(oTime);
            oTime4UTC = oTime4UTC.AddSeconds(iSecond);
            String strRes = oTime4UTC.ToString(strTemplate);
            return strRes;
        }

        #endregion

        #region now

        public static string now(String strTemplate)
        {
            DateTime oNow = DateTime.Now;
            String strRes = oNow.ToString(strTemplate);
            return strRes;
        }

        public static string now4UTC(String strTemplate)
        {
            DateTime oNow = DateTime.Now;
            DateTime oNow4UTC = TimeZoneInfo.ConvertTimeToUtc(oNow);
            String strRes = oNow4UTC.ToString(strTemplate);
            return strRes;
        }

        #endregion

        #region format

        public static String format(String strTime, String strTemplate)
        {
            DateTime oTime = DateTime.Parse(strTime);
            String strRes = oTime.ToString(strTemplate);
            return strRes;
        }

        #endregion

        #region getWebsiteDatetime

        public static String getWebsiteDatetime(String strUrl)
        {
            WebRequest request = null;
            WebResponse response = null;
            WebHeaderCollection headerCollection = null;
            string datetime = string.Empty;
            try
            {
                request = WebRequest.Create(strUrl);
                request.Timeout = 3000;
                request.Credentials = CredentialCache.DefaultCredentials;
                response = (WebResponse)request.GetResponse();
                headerCollection = response.Headers;
                foreach (var h in headerCollection.AllKeys)
                {
                    if (h == "Date")
                    {
                        datetime = headerCollection[h];
                    }
                }
                return datetime;
            }
            catch (Exception)
            {
                return datetime;
            }
            finally
            {
                if (request != null)
                {
                    request.Abort();
                }
                if (response != null)
                {
                    response.Close();
                }
                if (headerCollection != null)
                {
                    headerCollection.Clear();
                }
            }
        }

        #endregion

        #region getFirstDayOfMonth

        public static DateTime getFirstDayOfMonth()
        {
            DateTime now = DateTime.Now;
            DateTime d1 = new DateTime(now.Year, now.Month, 1);
            return d1;
        }

        public static DateTime getLastDayOfMonth()
        {
            DateTime now = DateTime.Now;
            DateTime d1 = new DateTime(now.Year, now.Month, 1);
            DateTime d2 = d1.AddMonths(1).AddDays(-1);
            return d2;
        }

        #endregion
    }
}
