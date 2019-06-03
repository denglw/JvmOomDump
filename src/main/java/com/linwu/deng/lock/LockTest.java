/**
 * @Title: MyTest.java
 * @Desc: TODO
 * @Package: com.linwu.deng.lock
 * @author: denglw
 * @date: 2019年5月10日 上午11:23:54
 * @version 1.0
 */

package com.linwu.deng.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyTest
 * @Desc: TODO
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月10日 上午11:23:54
 * @version 1.0
 */
public class LockTest {

	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final LockTest test = new LockTest();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }  
     
    public void insert(Thread thread) {
        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
        
    }	
}
