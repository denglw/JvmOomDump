/**
 * @Title: Li.java
 * @Desc: TODO
 * @Package: com.linwu.deng.callback
 * @author: denglw
 * @date: 2019年5月24日 下午4:20:51
 * @version 1.0
 */

package com.linwu.deng.callback;

/**
 * @ClassName: Li
 * @Desc: 这个是小李
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月24日 下午4:20:51
 * @version 1.0
 */
public class Li {
	/**
	 * 
	 * @param callback 回调接口
	 * @param question 小王问的问题
	 */
	public void executeMessage(CallBack callBack,String question){
		System.out.println("小王问的问题--->" + question);
		//模拟小李办自己的事情需要很长时间
		for(int i=0; i<10000;i++){
			
		}
		/**
		 * 小李办完自己的事情之后想到了答案是2
		 */
		String result = "答案是2";
		
		/**
		 * 于是就打电话告诉小王，调用小王中的方法
		 * 这就相当于B类反过来调用A的方法D
		 */
		callBack.solve(result);
	}
}
