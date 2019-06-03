/**
 * @Title: VolatileNoAtomic.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月16日 上午10:29:03
 * @version 1.0
 */

package com.linwu.deng.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: VolatileNoAtomic
 * @Desc: Volatile可见性，非原子性
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月16日 上午10:29:03
 * @version 1.0
 */
public class VolatileNoAtomic extends Thread {
	// 需要10个线程同时共享count  static修饰关键字，存放在静态区，只会存放一次，所有线程都会共享
//	private volatile static int count = 0;//非原子性操作
	private static AtomicInteger count = new AtomicInteger(0);//原子性操作

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
//        	count++;
        	count.incrementAndGet();
        }
        System.out.println(getName()+","+count);
    }

    public static void main(String[] args) {
        // 创建10个线程
        VolatileNoAtomic[] vaList = new VolatileNoAtomic[10];
        for (int i = 0; i < vaList.length; i++) {
            vaList[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < vaList.length; i++) {
            vaList[i].start();
        }
    }

}
