package com.firelord.component.process.provider;

public interface IProcessCallback {
	void onNewStdoutListener(String strNewStdout);

	void onNewStderrListener(String strNewStderr);

	void onProcessFinish(int iResultCode);
}
