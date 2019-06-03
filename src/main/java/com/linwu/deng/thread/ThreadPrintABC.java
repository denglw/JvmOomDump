/**
 * @Title: ThreadPrintABC.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread
 * @author: denglw
 * @date: 2019年5月15日 上午11:11:43
 * @version 1.0
 */

package com.linwu.deng.thread;

/**
 * @ClassName: ThreadPrintABC
 * @Desc:  建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月15日 上午11:11:43
 * @version 1.0
 */
public class ThreadPrintABC implements Runnable {

	private String name;   
    private Object prev;   
    private Object self;   
  
    private ThreadPrintABC(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
  
    @Override  
    public void run() {   
        int count = 10;   
        while (count > 0) {   
            synchronized (prev) {   
                synchronized (self) {   
                    System.out.print(name);   
                    count--;  
                    
                    self.notify();   
                }   
                try {   
                    prev.wait();   
                } catch (InterruptedException e) {   
                    e.printStackTrace();   
                }   
            }   
  
        }   
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
        ThreadPrintABC pa = new ThreadPrintABC("A", c, a);   
        ThreadPrintABC pb = new ThreadPrintABC("B", a, b);   
        ThreadPrintABC pc = new ThreadPrintABC("C", b, c);   
           
           
        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);  
        new Thread(pc).start();   
        Thread.sleep(100);

	}

}
