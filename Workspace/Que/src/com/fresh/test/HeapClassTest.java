package com.fresh.test;

import java.util.Random;

import org.junit.Test;

import com.fresh.tree.AVLTree;
import com.fresh.tree.Heap;

public class HeapClassTest
{

	@Test
	public void testHeap()
	{
		System.out.println("Heap Test");
		Heap<Integer> heap = new Heap<Integer>(Integer.class, 2);
		heap.add(1);
		heap.add(2);
		System.out.println(heap.peek());
	}

	@Test
	public void something()
	{
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(4);
		tree.colterIsWrongTest();
	}
	@Test
	public void testAVL()
	{
		System.out.println("AVL Test");
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(5);
		tree.add(2);
		tree.add(4);
		tree.add(5);
		System.out.println(tree.peek());
		tree.add(10);
		System.out.println(tree.peek());
		tree.add(11);
		System.out.println(tree.peek());
	}

	@Test
	public void pullAVL()
	{
		System.out.println("AVL Pull");
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.add(5);
		System.out.println(tree.pull());
		tree.add(2);
		tree.add(4);
		tree.add(7);
		System.out.println(tree.peek());
		System.out.println(tree.pull());
		System.out.println(tree.pull());
		System.out.println(tree.pull());
		System.out.println(tree.pull());
	}

	@Test
	public void pullHeap()
	{
		System.out.println("Heap Pull");
		Heap<Integer> heap = new Heap<Integer>(Integer.class, 50);
		heap.add(5);
		System.out.println(heap.pull());
		heap.add(1);
		for ( int i = 0; i < 50; i++ ) {
			heap.add(new Random().nextInt(50)+2);
		}
		System.out.println(heap.pull());
		System.out.println(heap.pull());
		System.out.println(heap.pull());
		System.out.println(heap.pull());
		System.out.println(heap.pull());
	}
}
