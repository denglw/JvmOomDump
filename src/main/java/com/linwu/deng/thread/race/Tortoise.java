/**
 * @Title: Tortoise.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.race
 * @author: denglw
 * @date: 2019年5月22日 下午3:21:18
 * @version 1.0
 */

package com.linwu.deng.thread.race;

/**
 * @ClassName: Tortoise
 * @Desc: 乌龟
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月22日 下午3:21:18
 * @version 1.0
 */
public class Tortoise extends Animal {
	public Tortoise(int length){
		setName("乌龟");// Thread的方法，给线程赋值名字
		this.length = length;
	}
	@Override
	public void runing() {//重写running方法，编写乌龟的奔跑逻辑
			int dis =2;
			length -= dis;
			System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米");
			if (length <= 0) {
				length = 0;
				System.out.println("乌龟获得了胜利");
				// 让兔子不要在跑了
				if (calltoback != null) {
					System.out.println("乌龟调用calltoback叫停兔子");
					calltoback.win();
				}
				raceFlag = false;
			}
			try {
				sleep(100);//每 0.1 秒跑 2 米，不休息
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}
