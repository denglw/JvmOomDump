/**
 * @Title: ExchangerDemo.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.demo
 * @author: denglw
 * @date: 2019年5月16日 下午5:58:30
 * @version 1.0
 */

package com.linwu.deng.thread.demo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExchangerDemo
 * @Desc: Exchanger 两个线程交换数据
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月16日 下午5:58:30
 * @version 1.0
 */
public class ExchangerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 定义交换器，交换String 类型的数据，当然是可以为任意类型
		final Exchanger<String> exchanger = new Exchanger<>();
		// 定义线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 绑架者A
		threadPool.execute(new Runnable(){
			@Override
			public void run() {
				try {
					// 准备人质
					String renzhi = "B";
					String money = exchanger.exchange(renzhi);
					System.out.println("绑架者用B交换回："+money);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		// 家属C
		threadPool.execute(new Runnable(){
			@Override
			public void run() {
				try {
					// 准备1000万
					String money = "1000万";
					String renzhi = exchanger.exchange(money);
					System.out.println("C用1000万交换回："+renzhi);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		threadPool.shutdown();
	}

}
