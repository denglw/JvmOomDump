/**
 * @Title: TicketOfficeCase.java
 * @Desc: TODO
 * @Package: com.linwu.deng.thread.multiCase
 * @author: denglw
 * @date: 2019年5月22日 上午10:23:44
 * @version 1.0
 */

package com.linwu.deng.thread.multiCase;

/**
 * @ClassName: TicketOfficeCase
 * @Desc: 三个售票窗口同时出售20张票
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月22日 上午10:23:44
 * @version 1.0
 */
public class TicketOfficeCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TicketOffice ticketOffice = new TicketOffice(new Object(),20);
		new Thread(ticketOffice, "窗口1").start();
		new Thread(ticketOffice, "窗口2").start();
		new Thread(ticketOffice, "窗口3").start();
	}

}

class TicketOffice implements Runnable{
	private int ticketNum;
	private Object object;
	public TicketOffice(Object object,int ticketNum){
		this.ticketNum = ticketNum;
		this.object = object;
	}
	@Override
	public void run() {
		while(ticketNum > 0){
			synchronized(object){
				if(ticketNum <=0){
					System.out.println(Thread.currentThread().getName() + "没有票了");
				}else{
					System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余" + --ticketNum + "张票");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
}
