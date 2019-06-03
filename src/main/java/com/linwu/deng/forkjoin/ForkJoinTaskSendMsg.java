/**
 * @Title: ForkJoinTaskSendMsg.java
 * @Desc: TODO
 * @Package: com.linwu.deng.forkjoin
 * @author: denglw
 * @date: 2019年5月31日 上午10:38:20
 * @version 1.0
 */

package com.linwu.deng.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ForkJoinTaskSendMsg
 * @Desc: 批量发送消息    RecursiveAction无返回结果的ForkJoinTask
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月31日 上午10:38:20
 * @version 1.0
 */
public class ForkJoinTaskSendMsg {
	 
    class SendMsgTask extends RecursiveAction {
		private static final long serialVersionUID = -8346423972083716290L;

		private final int THRESHOLD = 10;//开始执行计算的条件

        private int start;
        private int end;
        private List<String> list;

        public SendMsgTask(int start, int end, List<String> list) {
            this.start = start;
            this.end = end;
            this.list = list;
        }

        @Override
        protected void compute() {

            if ((end - start) <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + list.get(i));
                }
            }else {
                int middle = (start + end) / 2;
                invokeAll(new SendMsgTask(start, middle, list), new SendMsgTask(middle, end, list));
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 123; i++) {
            list.add(String.valueOf(i+1));
        }

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new ForkJoinTaskSendMsg().new SendMsgTask(0, list.size(), list));
        pool.awaitTermination(10, TimeUnit.SECONDS);
        pool.shutdown();
    }

}
