package com.fresh.test;

import java.util.Random;

import org.junit.Test;

import com.fresh.que.PriorityQue;
import com.fresh.que.PriorityQueAVL;
import com.fresh.que.PriorityQueHeap;

public class QueTesting
{

	@Test
	public void testAVL()
	{
		System.out.println("AVL");
		PriorityQue<Integer> que = new PriorityQueAVL<Integer>();
		que.offer(1);
		que.offer(10);
		System.out.println(que.pull());
		System.out.println(que.peek());
	}
	
	@Test
	public void testHeap()
	{
		System.out.println("Heap");
		PriorityQue<Integer> que = new PriorityQueHeap<Integer>(Integer.class, 2);
		que.offer(1);
		que.offer(10);
		System.out.println(que.pull());
		System.out.println(que.peek());
	}
	
	@Test
	public void testAVLLarge()
	{
		System.out.println("Large AVL");
		PriorityQue<Integer> que = new PriorityQueAVL<Integer>();
		que.offer(1);
		que.offer(10);
		for(int i = 2; i < 50; i++)
		{
			que.offer(new Random().nextInt(50));
		}
		System.out.println(que.pull());
		System.out.println(que.peek());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
	}
	
	@Test
	public void testHeapLarge()
	{
		System.out.println("Large Heap");
		PriorityQue<Integer> que = new PriorityQueHeap<Integer>(Integer.class, 2);
		que.offer(1);
		que.offer(10);
		for(int i = 2; i < 50; i++)
		{
			que.offer(new Random().nextInt(50));
		}
		System.out.println(que.pull());
		System.out.println(que.peek());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
		System.out.println(que.pull());
	}
}
