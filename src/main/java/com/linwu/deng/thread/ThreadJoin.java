/**
 * @Title: ThreadJoin.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月15日 上午9:48:51
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: ThreadJoin
 * @Desc: join()调用后，主线程需要等待子线程执行完后再执行结束
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月15日 上午9:48:52
 * @version 1.0
 */
public class ThreadJoin extends Thread {
	private String name;
	public ThreadJoin(String name){
		super(name);
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
		for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
		Thread1 mTh1=new Thread1("A");
		Thread1 mTh2=new Thread1("B");
		mTh1.start();
		mTh2.start();
		try {
			mTh1.join();
			mTh2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
	}

}
