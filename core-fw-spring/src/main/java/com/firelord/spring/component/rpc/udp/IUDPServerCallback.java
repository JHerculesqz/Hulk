package com.firelord.spring.component.rpc.udp;

/**
 * IUDPServerCallback
 */
public interface IUDPServerCallback {
    /**
     * process receive msg callback
     *
     * @param strReceiveMsg udp receive msg
     * @return process receive msg
     */
    String run(String strReceiveMsg);
}
