package com.lxtx.base.masterworker;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Master  Worker 并行计算
 * 多个线程同时执行，通过Master 记录每个子线程的执行结果，状态
 * 在主线程中统一返回result
 * @author jackson
 */
public class Main {

	public static void main(String[] args) {
		// 获取当前系统cpu 的内核数量
		System.out.println(Runtime.getRuntime().availableProcessors());
		Master master = new Master(new Worker(), Runtime.getRuntime().availableProcessors());
//		ConcurrentLinkedQueue
		Random r = new Random();
		for(int i = 1; i <= 100; i++){
			Task t = new Task();
			t.setId(i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		master.execute();
		long start = System.currentTimeMillis();
		
		while(true){
			if(master.isComplete()){
				long end = System.currentTimeMillis() - start;
				int priceResult = master.getResult();
				System.out.println("最终结果：" + priceResult + ", 执行时间：" + end);
				break;
			}
		}
		
	}
}
