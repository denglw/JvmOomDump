/**
 * @Title: Rabbit.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.race
 * @author: denglw
 * @date: 2019年5月22日 下午2:57:04
 * @version 1.0
 */

package com.linwu.deng.thread.race;

/**
 * @ClassName: Rabbit
 * @Desc: 兔子
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月22日 下午2:57:04
 * @version 1.0
 */
public class Rabbit extends Animal {
	public Rabbit(int length){
		setName("兔子");
		this.length = length;
	}
	private int raceLength =length ;//赛跑长度
	@Override
	public void runing(){//重写running方法，编写兔子的奔跑逻辑
			int dis = 5;//兔子速度
			length -= dis;
			System.out.println("兔子跑了" + dis + "米，距离终点还有" + length + "米");
			if (length <= 0) {
				length = 0;
				System.out.println("兔子获得了胜利");
				raceFlag = false;
				// 给回调对象赋值，让乌龟不要再跑了
				if (calltoback != null) {
					System.out.println("兔子调用calltoback");
					calltoback.win();
				}
			}
			try {
				if ((raceLength - length) % 20 == 0) {// 每20米休息一次,休息时间是1秒
					sleep(1000);
				} else {//每0.1秒跑5米
					sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
