/**
 * @Title: ThreadLocaDemo.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月23日 下午5:44:24
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: ThreadLocaDemo
 * @Desc: TODO
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月23日 下午5:44:24
 * @version 1.0
 */
public class ThreadLocaDemo extends Thread{

	private Res res;
	 
	public ThreadLocaDemo(Res res) {
		this.res = res;
	}
 
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
		}
 
	}
 
	public static void main(String[] args) {
		Res res = new Res();
		ThreadLocaDemo threadLocaDemo1 = new ThreadLocaDemo(res);
		ThreadLocaDemo threadLocaDemo2 = new ThreadLocaDemo(res);
		ThreadLocaDemo threadLocaDemo3 = new ThreadLocaDemo(res);
		threadLocaDemo1.start();
		threadLocaDemo2.start();
		threadLocaDemo3.start();
	}

}

class Res{
	// 生成序列号共享变量
	public static Integer count = 0;
	public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	public Integer getNum() {
		int count = threadLocal.get() + 1;
		threadLocal.set(count);
		return count;
	}

}
