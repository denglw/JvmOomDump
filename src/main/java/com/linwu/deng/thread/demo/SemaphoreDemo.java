/**
 * @Title: SemaphoreDemo.java
 * @Desc: 应用场景：用于流量控制，限流
 * @Package: com.linwu.deng.thread.demo
 * @author: denglw
 * @date: 2019年5月16日 下午4:49:22
 * @version 1.0
 */

package com.linwu.deng.thread.demo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreDemo
 * @Desc: 信号量 Semaphore 应用场景：用于流量控制，限流
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月16日 下午4:49:22
 * @version 1.0
 */
public class SemaphoreDemo {

	class MyTask implements Runnable{
		private Semaphore semaphore;// 信号量
		private int user;// 第几个用户
		public MyTask(Semaphore semaphore,int user){
			this.semaphore = semaphore;
			this.user = user;
		}
		@Override
		public void run() {
			try {
				semaphore.acquire();// 获取信号量许可，才能占用窗口
				// 运行到这里说明获取到了许可，可以去买票了
                System.out.println("用户"+ user + "进入窗口，准备买票...");
                Random random = new Random();
                Thread.sleep(random.nextInt(10000)); // 模拟买票时间
                System.out.println("用户"+ user + "买票完成，准备离开...");
                Thread.sleep(random.nextInt(10000));
                System.out.println("用户"+ user + "离开售票窗口...");
                semaphore.release();// 释放信号量许可证
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void execute(){
		 // 定义窗口个数
        final Semaphore s = new Semaphore(2);
        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 模拟20个用户
        for(int i=1;i<=20;i++){
        	threadPool.execute(new MyTask(s,i));
        }
        // 关闭线程池
        threadPool.shutdown();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
		semaphoreDemo.execute();
	}

}
