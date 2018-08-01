package com.lxtx.base.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class UseExecutors {

	public static void main(String[] args) {
		
//		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		//cache fixed single
		ExecutorService pool = Executors.newCachedThreadPool();
		// ewThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());



		
		
		
	}
}
