/**
 * @Title: LetOneStop.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.race
 * @author: denglw
 * @date: 2019年5月22日 下午3:37:27
 * @version 1.0
 */

package com.linwu.deng.thread.race;

import com.linwu.deng.thread.race.Animal.Calltoback;

/**
 * @ClassName: LetOneStop
 * @Desc: 让动物线程停止的类，这里要实现回调接口
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月22日 下午3:37:27
 * @version 1.0
 */
public class LetOneStop implements Calltoback {
	// 动物对象
	Animal an;
	// 获取动物对象，可以传入兔子或乌龟的实例
	public LetOneStop(Animal an) {
		this.an = an;
	}
	@Override
	public void win(){
		an.raceFlag = false;//通过标记法停止线程
//		an.stop();//此方法过期
	}

}
