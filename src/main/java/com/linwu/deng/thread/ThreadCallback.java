/**
 * @Title: ThreadCallback.java
 * @Desc: 通过回调函数传递数据
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月15日 下午3:41:09
 * @version 1.0
 */

package com.linwu.deng.thread;

import java.util.Random;

class Data{//内部类
	public int value=0;
}

class Work{
	public void process(Data data, Integer ...numbers){
		for(int n : numbers){//可变参数
			data.value += n;
		}
	}
}
/**
 * @ClassName: ThreadCallback
 * @Desc: TODO
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月15日 下午3:41:09
 * @version 1.0
 */
public class ThreadCallback extends Thread {

	private Work work;
	public ThreadCallback(Work work){
		this.work = work;
	}
	
	@Override
	public void run() {
		Data data = new Data();
		Random random = new Random();
		int n1 = random.nextInt(1000);
		int n2 = random.nextInt(2000);
		int n3 =  random.nextInt(3000);
		work.process(data, n1,n2,n3);
		StringBuffer sbf = new StringBuffer(String.valueOf(n1));//性能更好一点
		sbf.append("+").append(String.valueOf(n2)).append("+").append(String.valueOf(n3))
		.append("=").append(data.value);
		System.out.println(sbf); 

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread = new ThreadCallback(new Work());//面向接口编程
		thread.start();
	}

}
