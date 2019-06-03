/**
 * @Title: ConstantOutOfMemory.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月25日 下午4:22:50
 * @version 1.0
 */

package com.linwu.deng.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ConstantOutOfMemory
 * @Desc: 常量池内存溢出探究
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月25日 下午4:22:50
 * @version 1.0
 * @ VM args : -XX:PermSize=4M -XX:MaxPermSize=4M
 * @异常描述：java.lang.OutOfMemoryError: PermGen space
 */
public class ConstantOutOfMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 try {

	           List<String> strings = new ArrayList<String>();

	           int i = 0;

	           while(true){

	              strings.add(String.valueOf(i++).intern());

	           }

	       } catch (Exception e) {

	           e.printStackTrace();

	           throw e;

	       }

	}

}
