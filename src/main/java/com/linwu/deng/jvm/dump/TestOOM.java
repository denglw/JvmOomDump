/**
 * @Title: TestOOM.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月28日 上午10:47:11
 * @version 1.0
 */

package com.linwu.deng.jvm.dump;

/**
 * @ClassName: TestOOM
 * @Desc: 测试数组内存溢出：新建的intArray 数组，需要连续的内存空间存储且一个对象不能跨代存储
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月28日 上午10:47:11
 * @version 1.0
 * @ 设置JVM 启动参数为 -Xms12m -Xmx12m 
 */
public class TestOOM {
	static final int SIZE = 2*1024*1024;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[SIZE]; 

	}

}
