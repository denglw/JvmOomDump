/**
 * @Title: KeylessEntry.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月28日 下午3:26:30
 * @version 1.0
 */

package com.linwu.deng.jvm.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: KeylessEntry
 * @Desc: 内存泄漏示例： 
 * @ 设置JVM 启动参数为 -Xms10m -Xmx10m 
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月28日 下午3:26:30
 * @version 1.0
 * @分析：由于Key实体没有实现equals()方法，导致for循环中每次执行m.containsKey(new Key(i))结果均为false，其结果就是HashMap中的元素将一直增加。
随着时间的推移，越来越多的Key对象进入堆空间且不能被垃圾收集器回收（m为局部变量，GC会认为这些对象一直可用，所以不会回收），直到所有的堆空间被占用，
最后抛出java.lang.OutOfMemoryError:Java heap space。
 */
public class KeylessEntry {

	
	 static class Key {
	        Integer id;
	 
	        Key(Integer id) {
	            this.id = id;
	        }
	 
	        @Override
	        public int hashCode() {
	            return id.hashCode();
	        }
	        
	        @Override
	        public boolean equals(Object o) {
	            boolean response = false;
	            if (o instanceof Key) {
	                response = (((Key)o).id).equals(this.id);
	            }
	            return response;
	        }
	    }

	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Key,String> m = new HashMap<Key,String>();
        while(true) {
            for(int i=0;i<10000;i++) {
                if(!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
        }

	}

}
