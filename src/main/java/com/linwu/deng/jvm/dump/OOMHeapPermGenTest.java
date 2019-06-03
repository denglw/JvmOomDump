/**
 * @Title: OOMHeapPermGenTest.java
 * @Desc: TODO
 * @Package: com.linwu.deng.jvm.dump
 * @author: denglw
 * @date: 2019年4月30日 下午5:10:14
 * @version 1.0
 */

package com.linwu.deng.jvm.dump;

/**
 * @ClassName: OOMHeapPermGenTest
 * @Desc: PermGen持久代异常
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月30日 下午5:10:14
 * @version 1.0
 * @JVM参数配置 -XX:PermSize=3M -XX:MaxPermSize=3M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 */
public class OOMHeapPermGenTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		oom();

	}
	
	private static void oom(){
		Object[] array = new Object[10000000];
        for(int i=0; i<10000000; i++){
            String d = String.valueOf(i).intern();
            array[i]=d;
        }
       
    }

}
