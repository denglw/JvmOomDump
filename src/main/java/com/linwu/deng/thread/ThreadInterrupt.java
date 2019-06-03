/**
 * @Title: ThreadInterrupt.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月23日 上午11:30:15
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: ThreadInterrupt
 * @Desc: 终止线程-法二：中断法
 * 如果线程中有wait()和sleep()等方法，用中断法来终止线程效果更好
 * a.要使用interrupt()方法来中断线程，一定要在方法里捕获InterruptedException。
 * b.如果因为wait(),或sleep()等需要捕获InterruptedException的方法被中断时，jvm会在抛出异常之前先清除中断标记位，使得isInterrupted()返回为false。
 * 所以我们要在判断之前先重新设置好标记位
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月23日 上午11:30:15
 * @version 1.0
 */
public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while(true){
					if(Thread.currentThread().isInterrupted()){//中断状态
						System.out.println("interrupt!");
                        break;
					}
					System.out.println("t1 sleep");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {//必须在方法里捕获InterruptedException
						e.printStackTrace();
						//设置中断状态（如果需要真真中断线程，则需要重新设置中断位）
						Thread.currentThread().interrupt();//jvm会在抛出异常之前先清除中断标记位，使得isInterrupted()返回为false
					}
					Thread.yield();
				}
				System.out.println(System.currentTimeMillis());
			}
			
		};
		t1.start();
		Thread.sleep(1000);
        System.out.println(System.currentTimeMillis());
        t1.interrupt();//设置中断状态
	}

}
