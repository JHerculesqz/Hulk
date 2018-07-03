package com.firelord.component.mxbean;

import java.lang.management.ManagementFactory;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("restriction")
public class MxBeanUtilsEx {
	// #region getPID

	public static String getPID() {
		String strJVMName = ManagementFactory.getRuntimeMXBean().getName();
		String strRes = StringUtils.split(strJVMName, "@")[0];
		return strRes;
	}

	// #endregion

	// #region ServiceMem

	public static long getServiceMemTotal() {
		Runtime oRuntime = Runtime.getRuntime();
		long iRes = oRuntime.maxMemory();
		return iRes;
	}

	public static long getServiceMemUsed() {
		Runtime oRuntime = Runtime.getRuntime();
		long iRes = oRuntime.totalMemory() - oRuntime.freeMemory();
		return iRes;
	}

	public static float getServiceMemPercent() {
		long iTotal = getServiceMemTotal();
		long iUsed = getServiceMemUsed();
		float iRes = iUsed * 100.0f / iTotal;
		return iRes;
	}

	// #endregion

	// #region VMMem

	public static long getVmMemTotal() {
		com.sun.management.OperatingSystemMXBean oMxBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
				.getOperatingSystemMXBean();
		long iRes = oMxBean.getTotalPhysicalMemorySize();
		return iRes;
	}

	public static long getVmMemUsed() {
		com.sun.management.OperatingSystemMXBean oMxBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
				.getOperatingSystemMXBean();
		long iTotal = getVmMemTotal();
		long iFree = oMxBean.getFreePhysicalMemorySize();
		long iRes = iTotal - iFree;
		return iRes;
	}

	public static float getVmPercent() {
		long iTotal = getVmMemTotal();
		long iUsed = getVmMemUsed();
		float iRes = iUsed * 100.0f / iTotal;

		return iRes;
	}

	// #endregion
}
