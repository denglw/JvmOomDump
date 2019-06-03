/**
 * @Title: ThreadPoolTest.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月17日 下午3:25:29
 * @version 1.0
 */

package com.linwu.deng.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolTest
 * @Desc: TODO
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月17日 下午3:25:29
 * @version 1.0
 */
public class ThreadPoolTest implements Runnable{

	private String name;
	public ThreadPoolTest(String name){
		this.name = "thread "+name;
	}
	@Override
	public void run() {
		System.out.println( name +" Start. Time = "+new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String toString(){
        return this.name;
    }

	/**
	 * @1、主线程的执行与线程池里的线程分开，有可能主线程结束了，但是线程池还在运行
       @2、放入线程池的线程并不一定会按其放入的先后而顺序执行
	 */
	public static void main(String[] args) {
		System.out.println("Main: Starting at: "+ new Date());
//		ExecutorService exec = Executors.newCachedThreadPool();//创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
//		ExecutorService exec = Executors.newFixedThreadPool(5);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		ScheduledExecutorService ScheduledExec = Executors.newScheduledThreadPool(10);
		for(int i=0;i<10; i++){
//			exec.execute(new ThreadPoolTest(String.valueOf(i)));
			ScheduledExec.schedule(new ThreadPoolTest(String.valueOf(i)), 10, TimeUnit.SECONDS);//延迟10秒执);
		}
		exec.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
//		exec.shutdownNow();//立即关闭线程池
		ScheduledExec.shutdown();
		System.out.println("Main: Finished all threads at"+ new Date());
	}

}
