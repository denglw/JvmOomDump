/**
 * @Title: OOMHeapTest.java
 * @Desc: TODO
 * @Package: com.linwu.deng.jvm.dump
 * @author: denglw
 * @date: 2019年4月30日 下午4:27:13
 * @version 1.0
 */

package com.linwu.deng.jvm.dump;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: OOMHeapTest
 * @Desc: OOM堆内存泄漏
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月30日 下午4:27:13
 * @version 1.0
 * @JVM参数配置：-Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 */
public class OOMHeapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		oom();
//	    System.out.println("lai project，hello");

	}
	
	private static void oom(){
        Map<String, Pilot> map = new HashMap<String, Pilot>();
        Object[] array = new Object[1000000];
        for(int i=0; i<1000000; i++){
            String d = new Date().toString();
            Pilot p = new Pilot(d, i);
            map.put(i+"rosen jiang", p);
            array[i]=p;
        }
    }

}
