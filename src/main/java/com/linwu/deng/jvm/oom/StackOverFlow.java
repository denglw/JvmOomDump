/**
 * @Title: StackOverFlow.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月25日 下午4:14:51
 * @version 1.0
 */

package com.linwu.deng.jvm.oom;

/**
 * @ClassName: StackOverFlow
 * @Desc: 栈层级不足 溢出
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月25日 下午4:14:51
 * @version 1.0
 * 线程栈大小 -Xss128k   Error:stack length:995
 * 异常描述： java.lang.StackOverflowError 
 */
public class StackOverFlow {

	private int i;
	
	public void plus()
	{
		i++;
		plus();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOverFlow stackOverFlow = new StackOverFlow();
		try {
			stackOverFlow.plus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception:stack length:"+stackOverFlow.i);
	        e.printStackTrace();
		}catch (Error e) {

           System.out.println("Error:stack length:"+stackOverFlow.i);
           e.printStackTrace();

	       }

	}

}
