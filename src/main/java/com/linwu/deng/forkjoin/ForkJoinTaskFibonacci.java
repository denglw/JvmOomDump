/**
 * @Title: ForkJoinTaskFibonacci.java
 * @Desc: TODO
 * @Package: com.linwu.deng.forkjoin
 * @author: denglw
 * @date: 2019年5月31日 下午3:03:07
 * @version 1.0
 */

package com.linwu.deng.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @ClassName: ForkJoinTaskFibonacci
 * @Desc: 斐波那契数列F(1)=1,F(2)=1,f(n) = f(n-1)+f(n-2); n>3
 * @author: denglw
 * @email: 892253193@qq.com
 * @date: 2019年5月31日 下午3:03:07
 * @version 1.0
 */
public class ForkJoinTaskFibonacci {
	private static class Fibonacci extends RecursiveTask<Long>{
		private static final long serialVersionUID = -9108508176363040861L;
		final int n;
		public Fibonacci(int n){
			this.n = n;
		}
		@Override
		protected Long compute() {
			if(n==1 || n==2){//递归出口
				return 1L;
			}else{
				Fibonacci f1 = new Fibonacci(n-1);//拆分任务
				Fibonacci f2 = new Fibonacci(n-2);
				/*f1.fork();
				f2.fork();*/
				invokeAll(f1,f2);//线程全部执行
//				return f2.join()+f1.join();
				return f2.compute()+f1.join();
			}
		}
		
	}
	
	public static Integer fibonacci(int n){//普通递归
		if(n==1||n==2){
			return 1;
		}else{
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	public static void main(String[] args) throws Exception, ExecutionException{
		ForkJoinPool pool = new ForkJoinPool();
		Future<Long> future = pool.submit(new Fibonacci(20));//异步调用
		System.out.println(future.get());
		/*Long result = pool.invoke(new Fibonacci(20));//同步调用
		System.out.println(result);*/
		pool.shutdown();
		System.out.println(fibonacci(10));//普通调用
	}
}
