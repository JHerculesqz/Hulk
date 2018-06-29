package com.firelord.component.date;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

import jodd.datetime.JDateTime;

public class DateUtilsEx {
	// #region Const

	private static final String DEFAULT_TIME_ZONE = "GMT";
	public static final int TIMEZONE_0 = 0;
	public static final int TIMEZONE_8 = 8;

	public static final String FORMAT0 = "";
	public static final String FORMAT1 = "YYYYMMDD_hhmmss";
	public static final String FORMAT2 = "YYYY-MM-DD hh:mm:ss";
	public static final String FORMAT3 = "YYYY-MM-DD";
	public static final String FORMAT4 = "YYYYMMDDhhmmss";
	public static final String FORMAT5 = "YYYYMMDD_hhmmssmss";

	// #endregion

	// #region common

	private static TimeZone _getTimeZone(int iTimeZoneIndex) {
		// 1.get timezoneId
		String strTimeZoneId = DEFAULT_TIME_ZONE;
		if (iTimeZoneIndex > 0) {
			strTimeZoneId = DEFAULT_TIME_ZONE + "+" + iTimeZoneIndex;
		} else if (iTimeZoneIndex < 0) {
			strTimeZoneId = DEFAULT_TIME_ZONE + iTimeZoneIndex;
		}
		TimeZone oTimeZone = TimeZone.getTimeZone(strTimeZoneId);
		return oTimeZone;
	}

	private static void _setTimeZoneId(int iTimeZoneIndex, JDateTime oJDateTime) {
		TimeZone oTimeZone = _getTimeZone(iTimeZoneIndex);

		// 2.get JDateTime
		oJDateTime.setTimeZone(oTimeZone);
	}

	private static JDateTime _initJDateTime(int iTimeZoneIndex, String strDate) {
		JDateTime oJDateTime = new JDateTime();

		// 1._setTimeZoneId
		_setTimeZoneId(iTimeZoneIndex, oJDateTime);

		// 2.set Date
		oJDateTime.parse(strDate);

		return oJDateTime;
	}

	public static JDateTime _initJDateTime(int iTimeZoneIndex, Date oDate) {
		JDateTime oJDateTime = new JDateTime();

		// 1._setTimeZoneId
		_setTimeZoneId(iTimeZoneIndex, oJDateTime);

		// 2.set Date
		oJDateTime.setDateTime(oDate);

		return oJDateTime;
	}

	private static JDateTime _initJDateTime(int iTimeZoneIndex, long iDate) {
		JDateTime oJDateTime = new JDateTime();

		// 1._setTimeZoneId
		_setTimeZoneId(iTimeZoneIndex, oJDateTime);

		// 2.set Date
		oJDateTime.setTimeInMillis(iDate);

		return oJDateTime;
	}

	// #endregion

	// #region now

	public static String now(int iTimeZoneIndex, String strFormat) {
		JDateTime oNow = new JDateTime();

		// 1._setTimeZoneId
		_setTimeZoneId(iTimeZoneIndex, oNow);

		// 2.setDate
		oNow.setDateTime(new Date());

		// 3.res
		String strRes = strFormat.equals("") ? oNow.toString() : oNow.toString(strFormat);
		return strRes;
	}

	// #endregion

	// #region nowByLong

	public static long nowByLong(int iTimeZoneIndex) {
		JDateTime oNow = new JDateTime();

		// 1._setTimeZoneId
		_setTimeZoneId(iTimeZoneIndex, oNow);

		// 2.setDate
		oNow.setDateTime(new Date());

		// 3.res
		long iRes = oNow.getTimeInMillis();
		return iRes;
	}

	// #endregion

	// #region isExpire

	public static boolean isExpire(String strDate, int iTimeZoneIndex) {
		boolean bRes = false;

		JDateTime oDate = _initJDateTime(iTimeZoneIndex, strDate);
		JDateTime oNow = _initJDateTime(iTimeZoneIndex, new Date());
		int iRes = oNow.compareDateTo(oDate);
		if (1 == iRes) {
			bRes = true;
		}

		return bRes;
	}

	public static boolean isExpire(Date oDateSrc, int iTimeZoneIndex) {
		boolean bRes = false;

		JDateTime oDate = _initJDateTime(iTimeZoneIndex, oDateSrc);
		JDateTime oNow = _initJDateTime(iTimeZoneIndex, new Date());
		int iRes = oNow.compareDateTo(oDate);
		if (1 == iRes) {
			bRes = true;
		}

		return bRes;
	}

	public static boolean isExpire(String strDate, long iExpireInterval, int iTimeZoneIndex) {
		boolean bRes = false;

		JDateTime oDate = _initJDateTime(iTimeZoneIndex, strDate);
		JDateTime oNow = _initJDateTime(iTimeZoneIndex, new Date());
		if (oNow.getTimeInMillis() - oDate.getTimeInMillis() > iExpireInterval) {
			bRes = true;
		}

		return bRes;
	}

	// #endregion

	// #region isExpireDay

	public static boolean isExpireDay(String strDate, int iExpireDay, int iTimeZoneIndex) {
		boolean bRes = false;

		JDateTime oDate = _initJDateTime(iTimeZoneIndex, strDate);
		JDateTime oNow = _initJDateTime(iTimeZoneIndex, new Date());

		if (oNow.daysBetween(oDate) > iExpireDay) {
			bRes = true;
		}

		return bRes;
	}

	// #endregion

	// #region addMs

	public static Date addMs(int iMs4Add, int iTimeZoneIndex) {
		JDateTime oNow = _initJDateTime(iTimeZoneIndex, new Date());
		oNow.addMillisecond(iMs4Add);
		return oNow.convertToDate();
	}

	// #endregion

	// #region addDay

	public static Date addDay(int iDay4Add, int iTimeZoneIndex) {
		JDateTime oNow = _initJDateTime(iTimeZoneIndex, new Date());
		oNow.addDay(iDay4Add);
		return oNow.convertToDate();
	}

	// #endregion

	// #region timezone

	public static long transByTimezone(long iDateSrc, int iTimeZoneIndex) {
		JDateTime oDateSrc = _initJDateTime(0, iDateSrc);
		JDateTime oDateDst = oDateSrc.changeTimeZone(_getTimeZone(iTimeZoneIndex));
		return oDateDst.getTimeInMillis();
	}

	public static String transByTimezoneEx(String strDateSrc, int iTimeZoneIndex) {
		JDateTime oDateSrc = _initJDateTime(0, strDateSrc);
		JDateTime oDateDst = oDateSrc.changeTimeZone(_getTimeZone(iTimeZoneIndex));
		return oDateDst.toString(FORMAT2);
	}

	// #endregion

	// #region sort

	public static TreeSet<String> sort(List<String> lstDate) {
		TreeSet<String> oRes = new TreeSet<String>();

		for (String strDate : lstDate) {
			oRes.add(strDate);
		}

		return oRes;
	}

	// #endregion

	// #region parseByDay

	public static String parseByDay(String strTime, int iTimezoneIndex) {
		JDateTime oJDateTime = _initJDateTime(iTimezoneIndex, strTime);
		String strDay = oJDateTime.toString(FORMAT3);

		return strDay;
	}

	// #endregion

	// #region sub

	public static long sub(String strTime1, String strTime2, int iTimezoneIndex) {
		JDateTime oJDateTime1 = _initJDateTime(iTimezoneIndex, strTime1);
		JDateTime oJDateTime2 = _initJDateTime(iTimezoneIndex, strTime2);
		long iRes = oJDateTime1.getTimeInMillis() - oJDateTime2.getTimeInMillis();
		return iRes;
	}

	// #endregion

	// #region isToday

	public static boolean isToday(String strTime1, int iTimezoneIndex) {
		JDateTime oJDateTime1 = _initJDateTime(iTimezoneIndex, strTime1);
		JDateTime oJDateTime2 = _initJDateTime(iTimezoneIndex, now(iTimezoneIndex, FORMAT0));
		if (0 == oJDateTime2.daysBetween(oJDateTime1)) {
			return true;
		} else {
			return false;
		}
	}

	// #endregion

	// #region compareDay

	public static boolean compareDay(String strTimeSrc, String strTimeDst, int iTimezoneIndex) {
		JDateTime oJDateTime1 = _initJDateTime(iTimezoneIndex, strTimeSrc);
		JDateTime oJDateTime2 = _initJDateTime(iTimezoneIndex, strTimeDst);

		int iRes = oJDateTime1.compareTo(oJDateTime2);

		return iRes > 0 ? true : false;
	}

	// #endregion
}
