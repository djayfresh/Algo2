package com.fresh.fib;

import java.util.HashMap;

public class Fib
{
	static HashMap<Long, Long> fiblist = new HashMap<Long,Long>();
	
	public static void main(String[] args)
	{
		long time = System.nanoTime();
		System.out.println(fib(25));
		System.out.println("Fib time: " + (System.nanoTime() - time)/1000 + "ms");
		
		time = System.nanoTime();
		System.out.println(fib(50));
		System.out.println("Fib time: " + (System.nanoTime() - time)/1000 + "ms");
		
		time = System.nanoTime();
		System.out.println(betterFib(50));
		System.out.println("Fib time: " + (System.nanoTime() - time)/1000 + "ms");
	}

	static long fib(long n)
	{
		if(n < 2)
			return n;
		return fib(n-1) + fib(n-2);
	}
	
	static long betterFib(int n)
	{
		if(n < 2) return n;
		
		long[] list = new long[n+1];
		list[0] = 0;
		list[1] = 1;
		
		for(int i = 2; i <= n; i++)
		{
			list[i] = list[i-2] + list[i-1];
		}
		return list[n];
	}
}
