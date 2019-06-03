/**
 * @Title: CallBackTest.java
 * @Desc: TODO
 * @Package: com.linwu.deng.callback
 * @author: denglw
 * @date: 2019年5月24日 下午4:42:25
 * @version 1.0
 */

package com.linwu.deng.callback;

/**
 * @ClassName: CallBackTest
 * @Desc: 测试回调函数
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月24日 下午4:42:25
 * @version 1.0
 */
public class CallBackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Li li = new Li();//Server
		Wang wang = new Wang(li);//Client
		wang.askQuestion("1 + 1 = ?");
	}

}
