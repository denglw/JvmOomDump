/**
 * @Title: HeapOutOfMemory.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月25日 下午3:45:22
 * @version 1.0
 */

package com.linwu.deng.jvm.oom;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: HeapOutOfMemory
 * @Desc: 堆溢出测试
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月25日 下午3:45:22
 * @version 1.0
 * jvm参数 -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
 * 异常描述：java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOutOfMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TestCase> cases = new ArrayList<TestCase>();

	       while(true){

	           cases.add(new TestCase());

	       }

	}

}
