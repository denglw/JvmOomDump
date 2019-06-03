/**
 * @Title: Animal.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.race
 * @author: denglw
 * @date: 2019年5月22日 下午2:27:44
 * @version 1.0
 */

package com.linwu.deng.thread.race;

/**
 * @ClassName: Animal
 * @Desc: 龟兔赛跑的线程问题
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月22日 下午2:27:44
 * @version 1.0
 */
public abstract class Animal extends Thread {
	public int length ;//比赛长度 2000
	public volatile boolean raceFlag = true;//线程停止标志位
	public abstract void runing();
	@Override
	public void run(){
		super.run();
		while(length>0 && raceFlag){//同时满足：没有到达终点且没有被叫停
			runing();
		}
	}
	// 在需要回调数据的地方（两个子类需要），声明一个接口
	public static interface Calltoback {
		public void win();
	}
	// 2.创建接口对象
	public Calltoback calltoback;
	
}
