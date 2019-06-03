/**
 * @Title: MyObject.java
 * @Desc: TODO
 * @Package: com.linwu.deng.lock
 * @author: denglw
 * @date: 2019年5月8日 下午5:30:45
 * @version 1.0
 */

package com.linwu.deng.lock;

import com.linwu.deng.jvm.oom.TestCase;

/**
 * @ClassName: MyObject
 * @Desc: TODO
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月8日 下午5:30:45
 * @version 1.0
 */
public class MyObject {
	public void method(TestCase test){
		synchronized(test){}
	}
}
