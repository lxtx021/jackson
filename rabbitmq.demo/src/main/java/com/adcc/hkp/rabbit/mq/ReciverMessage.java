package com.adcc.hkp.rabbit.mq;

public class ReciverMessage implements IReciverMessage{

	@Override
	public void reciver(byte[] message) {

		System.out.println(message);
		
	}

}
