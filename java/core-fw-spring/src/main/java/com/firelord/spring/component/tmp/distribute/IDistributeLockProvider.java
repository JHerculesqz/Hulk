package com.firelord.spring.component.tmp.distribute;

public interface IDistributeLockProvider {
	boolean isTimeout();

	void lock();

	void unlock();
}
