/**
 * @Title: CyclicBarrierDemo.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.demo
 * @author: denglw
 * @date: 2019年5月16日 下午5:33:00
 * @version 1.0
 */

package com.linwu.deng.thread.demo;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CyclicBarrierDemo
 * @Desc: 同步屏障 CyclicBarrier 
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月16日 下午5:33:00
 * @version 1.0
 */
public class CyclicBarrierDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 final CyclicBarrier cb = new CyclicBarrier(3,new Runnable(){
			@Override
			public void run() {
				// 在吃饭之前做点别的事情
                System.out.println("人员全部到齐了，拍照留念...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		// 线程池 
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 模拟3个用户
		for(int i=0;i<3;i++){
			final int user = i+1;
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						// 模拟每个人来的时间各不一样
						Thread.sleep(new Random().nextInt(10000));
						System.out.println(user+"到达聚餐地点，当前已有"+ (cb.getNumberWaiting()+1) +"人到达");
						// 设置屏障 等待，只有当线程都到达之后，才能往下面走
                        cb.await();
                        if(user==3){
                        	System.out.println("人员全部到齐了，开始吃饭...");
                        }
                        Thread.sleep((long)Math.random()*20000);
                        System.out.println(user+"吃完饭了，准备回家...");
                        // CyclicBarrier 可以重复使用 doSomething
                        
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			threadPool.execute(r);
		}
		threadPool.shutdown();
	}

}
