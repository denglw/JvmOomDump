/**
 * @Title: MethodAreaOutOfMemory.java
 * @Desc: TODO
 * @Package: jvm.test
 * @author: denglw
 * @date: 2019年4月25日 下午4:59:57
 * @version 1.0
 */

package com.linwu.deng.jvm.oom;



import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @ClassName: MethodAreaOutOfMemory
 * @Desc: 方法区溢出测试
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年4月25日 下午4:59:57
 * @version 1.0  需要引入cglib的jar包
 * @VM args : -XX:PermSize=10M -XX:MaxPermSize=10M
 * @异常描述：java.lang.OutOfMemoryError: PermGen space
 */
public class MethodAreaOutOfMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		while(true){

	           Enhancer enhancer = new Enhancer();

	           enhancer.setSuperclass(TestCase.class);

	           enhancer.setUseCache(false);

	           enhancer.setCallback(new MethodInterceptor() {

	              @Override

	              public Object intercept(Object arg0, Method arg1, Object[] arg2,

	                     MethodProxy arg3) throws Throwable {

	                  return arg3.invokeSuper(arg0, arg2);

	              }

	           });

	           enhancer.create();

	       }

	}

}
