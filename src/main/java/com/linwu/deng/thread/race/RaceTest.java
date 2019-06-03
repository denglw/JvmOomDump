/**
 * @Title: RaceTest.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.race
 * @author: denglw
 * @date: 2019年5月22日 下午4:07:48
 * @version 1.0
 */

package com.linwu.deng.thread.race;

/**
 * @ClassName: RaceTest
 * @Desc: 龟兔赛跑：2000米
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月22日 下午4:07:48
 * @version 1.0
 */
public class RaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 40;//比赛长度 2000
		// 实例化乌龟和兔子
		Tortoise tortoise = new Tortoise(length);
		Rabbit rabbit = new Rabbit(length);
		// 回调方法的使用，谁先调用calltoback方法，另一个就不跑了
		LetOneStop letOneStop1 = new LetOneStop(tortoise);
		// 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
		rabbit.calltoback = letOneStop1;
		LetOneStop letOneStop2 = new LetOneStop(rabbit);
		// 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
		tortoise.calltoback = letOneStop2;
		// 开始跑
		tortoise.start();
		rabbit.start();

	}

}
