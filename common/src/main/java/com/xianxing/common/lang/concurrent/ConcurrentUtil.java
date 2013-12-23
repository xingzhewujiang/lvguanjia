package com.xianxing.common.lang.concurrent;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtil {

	private static ExecutorService executor = null;
	private static ConcurrentUtil instance = null;

	private ConcurrentUtil(){
		init();
	}
	
	private static void init() {
		int corePoolSize = 5;
		int maxPoolSize = 10;
		int queueSize = 100;
		executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize), new ThreadFactory() {

			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setName("poll" + r.getClass().getName() + t.getId());
				t.setDaemon(true);
				return t;
			}
		}, new RejectedExecutionHandler() {

			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				System.err.println("poll" + r.getClass().getName() +  " rejected!");
			}

		});
		
	}
	
	public static ConcurrentUtil getInstance() {
		if (instance == null) {
			instance = new ConcurrentUtil();
		}
		return instance;
	}
	
	public <T> List<Future<T>> submit(List<Callable<T>> tasks, int timeoutForMilliSeconds) {
		  List<Future<T>> futures = null;
          try {
              futures = executor.invokeAll(tasks, timeoutForMilliSeconds, TimeUnit.MILLISECONDS);
          } catch (Exception e) {
             e.printStackTrace();
          }
          return futures;
	}
	
	public <T> Future<T>submit(Callable<T> task) {
		  Future<T> future = null;
        try {
            future = executor.submit(task);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return future;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
