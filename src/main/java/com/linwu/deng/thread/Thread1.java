/**
 * @Title: Thread1.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月13日 下午2:29:48
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: Thread1
 * @Desc: 继承Thread类演示线程
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月13日 下午2:29:48
 * @version 1.0
 */
public class Thread1 extends Thread {
	private String name;
	public Thread1(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(name +"运行"+i);
			try {
				sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread1 th1 = new Thread1("A");//继承Thread类的调用方式
		Thread1 th2 = new Thread1("B");
		th1.start();
		th2.start();
	}

}
