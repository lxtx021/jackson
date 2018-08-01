package com.lxtx.base.future;

/**
 * 多线程Future 模式类似于Ajax
 * 主线程跑着呢，新启一个子线程，通过子线程执行完，返回结果
 * @author jackson
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数");
		System.out.println("请求发送成功!");
		System.out.println("做其他的事情...");
		
		String result = data.getRequest();
		System.out.println(result);
		
	}
}
