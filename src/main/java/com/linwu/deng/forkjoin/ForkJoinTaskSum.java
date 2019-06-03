/**
 * @Title: ForkJoinTaskSum.java
 * @Desc: TODO
 * @Package: com.linwu.deng.forkjoin
 * @author: denglw
 * @date: 2019年5月31日 上午10:54:12
 * @version 1.0
 */

package com.linwu.deng.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @ClassName: ForkJoinTaskSum 此代码需要JDK1.8
 * @Desc: 求和   RecursiveTask有返回结果的ForkJoinTask
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月31日 上午10:54:12
 * @version 1.0
 */
public class ForkJoinTaskSum {
	private class SumTask extends RecursiveTask<Integer>{
		private static final long serialVersionUID = -8807223268824852352L;
		private static final int THRESHOLD = 20;
		private int arr[];
		private int start;
		private int end;
		public SumTask(int arr[],int start,int end){
			this.arr =arr;
			this.start = start;
			this.end = end;
		}
		private Integer subTotal(){
			Integer sum = 0;
			for(int i=start;i<end;i++){
				sum += arr[i];
			}
			System.out.println(Thread.currentThread().getName() + ": ∑(" + start + "~" + end + ")=" + sum);
			return sum;
		}
		@Override
		protected Integer compute() {
			if((end - start)<=THRESHOLD){//递归出口
				return subTotal();
			}else{
				int middle = (start + end) / 2;//拆子任务
				SumTask left = new SumTask(arr,start,middle);//递归拆分
				SumTask right = new SumTask(arr,middle,end);
				left.fork();
				right.fork();
//				invokeAll(left, right);//无监工线程，线程分工且执行任务
				return left.join() + right.join();//子任务计算结果
			}
		}
		
	}
	public static void main(String[] args){
		int[] arr = new int[100];
		for(int i=0;i<100;i++){
			arr[i] = i+1;
		}
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTask<Integer> result= forkJoinPool.submit(new ForkJoinTaskSum().new SumTask(arr,0,arr.length));
		System.out.println("最终计算结果: " + result.invoke());
		forkJoinPool.shutdown();
	}
}
