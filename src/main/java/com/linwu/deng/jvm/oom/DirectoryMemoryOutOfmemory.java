/**
 * @Title: DirectoryMemoryOutOfmemory.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月25日 下午5:11:31
 * @version 1.0
 */

package com.linwu.deng.jvm.oom;



import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @ClassName: DirectoryMemoryOutOfmemory
 * @Desc: 直接内存溢出测试
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月25日 下午5:11:31
 * @version 1.0
 * @VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @ 异常描述 java.lang.OutOfMemoryError: Direct buffer memory 
 */
public class DirectoryMemoryOutOfmemory {

	private static final int ONE_MB = 1024*1024;

    private static int count = 1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {

	           Field field = Unsafe.class.getDeclaredField("theUnsafe");

	           field.setAccessible(true);

	           Unsafe unsafe = (Unsafe) field.get(null);

	           while (true) {

	              unsafe.allocateMemory(ONE_MB);

	              count++;

	           }

	       } catch (Exception e) {

	           System.out.println("Exception:instance created "+count);

	           e.printStackTrace();

	       } catch (Error e) {

	           System.out.println("Error:instance created "+count);

	           e.printStackTrace();

	       }


	}

}
