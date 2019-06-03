/**
 * @Title: CallBack.java
 * @Desc: TODO
 * @Package: com.linwu.deng.callback
 * @author: denglw
 * @date: 2019年5月24日 下午4:15:53
 * @version 1.0
 */

package com.linwu.deng.callback;

/**
 * @ClassName: CallBack
 * @Desc: 这是一个回调接口
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月24日 下午4:15:53
 * @version 1.0
 */
public interface CallBack {
	/**
	 * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数
	 * @param result 是答案
	 */
	public void solve(String result);
}
