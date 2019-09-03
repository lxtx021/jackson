package com.adcc.hkp.rabbit.mq;

public interface IReciverMessage {
	/**
	 * 接收消息
	 * 
	 * @param message
	 * @return 返回true停止接收
	 */
	void reciver(byte[] message);
}
