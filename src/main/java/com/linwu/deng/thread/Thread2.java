/**
 * @Title: Thread2.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月13日 下午2:48:18
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: Thread2
 * @Desc: 实现Runnable接口演示线程
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月13日 下午2:48:18
 * @version 1.0
 */
public class Thread2 implements Runnable {
	private String name;
	public Thread2(String name){
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(name+"运行"+i);
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Thread2("C")).start();//实现Runnable接口调用方式
		new Thread(new Thread2("D")).start();
	}

}
