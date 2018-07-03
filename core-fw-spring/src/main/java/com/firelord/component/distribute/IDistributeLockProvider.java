package com.firelord.component.distribute;

public interface IDistributeLockProvider {
	boolean isTimeout();

	void lock();

	void unlock();
}
