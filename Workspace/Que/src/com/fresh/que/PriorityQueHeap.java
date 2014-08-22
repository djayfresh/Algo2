package com.fresh.que;

import com.fresh.tree.Heap;

public class PriorityQueHeap<T extends Comparable<T>> extends PriorityQue<T>
{
	Heap<T> heap;

	public PriorityQueHeap(Class<T> tClass, int initalzeSize)
	{
		heap = new Heap<T>(tClass, initalzeSize);
	}

	@Override
	public T peek()
	{
		return heap.peek();
	}

	@Override
	public T pull()
	{
		return heap.pull();
	}

	@Override
	public boolean offer(T data)
	{
		return heap.add(data);
	}

}
