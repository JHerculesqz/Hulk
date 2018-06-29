package com.firelord.component.process;

import java.io.IOException;
import java.io.InputStream;

import com.firelord.component.log.LogUtilsEx;

public class ProcessUtilsEx {
	// #region Const

	private static final boolean IS_DEBUG = false;

	// #endregion

	// #region save for research...

	// // #region Fields
	//
	// // #region Construction
	//
	// private static ProcessUtilsEx m_oInstance;
	//
	// public synchronized static ProcessUtilsEx getInstance() {
	// if (null == m_oInstance) {
	// m_oInstance = new ProcessUtilsEx();
	// }
	// return m_oInstance;
	// }
	//
	// // #endregion
	//
	// // #region basicInfo
	//
	// private String m_strDirPathRoot;
	//
	// private List<ProcessCommand> m_lstCmd = new ArrayList<ProcessCommand>();
	//
	// private IProcessCallback m_oIProcessCallback;
	//
	// // #endregion
	//
	// // #region transientInfo
	//
	// @Setter
	// @Getter
	// private boolean isRunning = false;
	//
	// @Setter
	// @Getter
	// private int resultCode = 0;
	//
	// private StringBuffer allResult = new StringBuffer();
	//
	// // #endregion
	//
	// // #endregion
	//
	// // #region init
	//
	// public void init(IProcessCallback oIProcessCallback, String
	// strDirPathRoot, String... lstCmd) {
	// this.m_oIProcessCallback = oIProcessCallback;
	//
	// this.m_strDirPathRoot = strDirPathRoot;
	//
	// for (String strCmd : lstCmd) {
	// ProcessCommand oProcessCommand = new ProcessCommand();
	// if (m_strDirPathRoot != null) {
	// oProcessCommand.setDirectory(m_strDirPathRoot);
	// }
	// oProcessCommand.setCommand(strCmd);
	// m_lstCmd.add(oProcessCommand);
	// }
	// }
	//
	// // #endregion
	//
	// // #region start
	//
	// public void start() {
	// this.isRunning = true;
	//
	// for (ProcessCommand oProcessCommand : m_lstCmd) {
	// ProcessBuilder oProcessBuilder = new ProcessBuilder();
	//
	// if (m_strDirPathRoot != null) {
	// oProcessBuilder.directory(new File(oProcessCommand.getDirectory()));
	// }
	// oProcessBuilder.redirectErrorStream(false);
	// oProcessBuilder.command(oProcessCommand.getCommand());
	// try {
	// exec(oProcessBuilder.start());
	// } catch (InterruptedException e) {
	// LogUtilsEx.log("[ProcessProvider]err..." + e.getMessage(), IS_DEBUG);
	// } catch (IOException e) {
	// LogUtilsEx.log("[ProcessProvider]err..." + e.getMessage(), IS_DEBUG);
	// }
	// }
	// }
	//
	// private void exec(final Process oProcess) throws InterruptedException {
	// BufferedReader oBufferedReaderStdout = new BufferedReader(new
	// InputStreamReader(oProcess.getInputStream()));
	// BufferedReader oBufferedReaderStderr = new BufferedReader(new
	// InputStreamReader(oProcess.getErrorStream()));
	// Thread execThread = new Thread() {
	// public void run() {
	// try {
	// String strTmp1 = oBufferedReaderStdout.readLine();
	// String strTmp2 = oBufferedReaderStderr.readLine();
	// while (strTmp1 != null || strTmp2 != null) {
	// if (strTmp1 != null) {
	// allResult.append(strTmp1 + "\n");
	// m_oIProcessCallback.onNewStdoutListener(strTmp1);
	// }
	// if (strTmp2 != null) {
	// allResult.append(strTmp2 + "\n");
	// m_oIProcessCallback.onNewStderrListener(strTmp2);
	// }
	// }
	// } catch (IOException e) {
	// LogUtilsEx.log("[ProcessUtilsEx]ex..." + e.getMessage(), IS_DEBUG);
	// }
	// resultCode = oProcess.exitValue();
	// }
	// };
	// execThread.start();
	// execThread.join();
	// isRunning = false;
	// m_oIProcessCallback.onProcessFinish(resultCode);
	// }
	//
	// // #endregion
	//
	// // #region destroy
	//
	// public void destroy() {
	// m_strDirPathRoot = null;
	// m_lstCmd.clear();
	// m_oIProcessCallback = null;
	// isRunning = false;
	// resultCode = 0;
	// allResult = new StringBuffer();
	// }
	//
	// // #endregion

	// #endregion

	// #region execSimple

	public static String execSimple(String strCmd, String strCmdArgs) {
		StringBuilder strRes = new StringBuilder();

		try {
			ProcessBuilder oProcessBuilder = new ProcessBuilder(strCmd, strCmdArgs);
			Process oProcess = oProcessBuilder.start();
			InputStream oInputStream = oProcess.getInputStream();
			int iCharCode;
			while ((iCharCode = oInputStream.read()) != -1) {
				strRes.append((char) iCharCode);
			}
			oProcess.waitFor();
		} catch (Exception ex) {
			LogUtilsEx.log("[ProcessUtilsEx.execSimple]ex..." + ex.getMessage(), IS_DEBUG);
		}

		return strRes.toString();
	}

	// #endregion

	// #region kill

	/**
	 * TODO:待验证
	 * 
	 * @param strProcessName
	 */
	public static void killProcessByName(String strProcessName) {
		try {
			String strCmd = String.format("taskkill /f /im %s", strProcessName);
			Runtime.getRuntime().exec(strCmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO:待验证
	 * 
	 * @param strProcessName
	 */
	public static void killProcessByNameExcludeName(String strProcessName, String strExcludeProcessTitle) {
		try {
			String strCmd = String.format(
					"cmd.exe /c for /f \"tokens=2 delims= \" %%i in ('tasklist /v ^|find \"%s\"') do (taskkill /f /t /fi \"pid ne %%i\" /im %s)",
					strExcludeProcessTitle, strProcessName);
			Process oProcess = Runtime.getRuntime().exec(strCmd);
			// InputStream oInputStream = oProcess.getErrorStream();
			// InputStreamReader oInputStreamReader = new
			// InputStreamReader(oInputStream);
			// BufferedReader oBufferedReader = new
			// BufferedReader(oInputStreamReader);
			// String strLine = null;
			// while ((strLine = oBufferedReader.readLine()) != null) {
			// System.out.println("[ProcessUtilsEx.killProcessByName]error
			// stream..." + strLine);
			// }
			int iReturnCode = oProcess.waitFor();
			LogUtilsEx.log("[ProcessUtilsEx.killProcessByName]exit code..." + iReturnCode, IS_DEBUG);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void killProcessByNameExcludePID(String strProcessName, String strExcludeProcessID) {
		try {
			String strCmd = String.format("taskkill /f /t /fi \"pid ne %s\" /im %s", strExcludeProcessID,
					strProcessName);
			Process oProcess = Runtime.getRuntime().exec(strCmd);
			int iReturnCode = oProcess.waitFor();
			LogUtilsEx.log("[ProcessUtilsEx.killProcessByPID]exit code..." + iReturnCode, IS_DEBUG);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// #endregion

	// #region runByShellAsyn

	/**
	 * runByShell 新打开一个控制台窗口执行传入的命令
	 * 
	 * @param strCmd
	 * @param strArgs
	 * @return
	 */
	public static void runByShellAsyn(String strCmd, String strArgs) {
		try {
			// 1.gen strExecCmd
			String strExecCmd = String.format("cmd /k start %s %s", strCmd, strArgs);
			// 2.start Process
			Runtime.getRuntime().exec(strExecCmd);
		} catch (IOException e) {
			LogUtilsEx.log("[ProcessUtilsEx.runBat]ex..." + e.getMessage(), IS_DEBUG);
		}
	}

	// #endregion

	// #region runByShellSyn

	/**
	 * TODO：待验证
	 * 
	 * @param strCmd
	 * @param strArgs
	 */
	public static void runByShellSyn(String strCmd, String strArgs) {
		try {
			// 1.gen strExecCmd
			String strExecCmd = String.format("cmd /c %s %s", strCmd, strArgs);
			// 2.start Process
			Process oProcess = Runtime.getRuntime().exec(strExecCmd);
			oProcess.waitFor();
			System.out.println("exit ....");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// #endregion
}
