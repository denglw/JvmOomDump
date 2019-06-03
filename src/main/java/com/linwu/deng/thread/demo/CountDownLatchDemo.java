/**
 * @Title: CountDownLatchDemo.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.demo
 * @author: denglw
 * @date: 2019年5月17日 下午2:09:05
 * @version 1.0
 */

package com.linwu.deng.thread.demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchDemo
 * @Desc: CountDownLatch倒计时器
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月17日 下午2:09:05
 * @version 1.0
 */
public class CountDownLatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 定义倒计时器
		final CountDownLatch latch = new CountDownLatch(3);
		// 模拟一个子任务B
		new Thread(){
			@Override
			public void run() {
				try {
					// 模拟任务执行时间
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("子任务B"+Thread.currentThread().getName()+"正在执行");
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("子任务B"+Thread.currentThread().getName()+"执行完毕");
					// 倒计时减掉1
                    latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		
		// 模拟一个子任务C
		new Thread(){
			@Override
			public void run() {
				try {
					// 模拟任务执行时间
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("子任务C"+Thread.currentThread().getName()+"正在执行");
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("子任务C"+Thread.currentThread().getName()+"执行完毕");
					// 倒计时减掉1
                    latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		
		// 模拟一个子任务D
		new Thread(){
			@Override
			public void run() {
				try {
					// 模拟任务执行时间
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("子任务D"+Thread.currentThread().getName()+"正在执行");
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("子任务D"+Thread.currentThread().getName()+"执行完毕");
					// 倒计时减掉1
                    latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		
		// main 线程为主任务A
		System.out.println("等待3个子任务执行完毕"+Thread.currentThread().getName()+"主任务才开始执行");
		try {
			latch.await();
			 System.out.println("说明BCD三个子任务已经执行完毕");
			// 继续执行主任务
	        System.out.println("继续执行主任务："+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
