/**
 * @Title: ThreadYield.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月15日 上午10:27:21
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: ThreadYield
 * @Desc: yield()方法
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月15日 上午10:27:21
 * @version 1.0
 */
public class ThreadYield extends Thread {
	public ThreadYield(String name){
		super(name);
	}
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i ==30) {
                this.yield();
            }
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadYield yt1 = new ThreadYield("张三");
		ThreadYield yt2 = new ThreadYield("李四");
		yt1.start();
		yt2.start();
	}

}
