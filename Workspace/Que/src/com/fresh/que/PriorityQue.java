package com.fresh.que;

public abstract class PriorityQue<T extends Comparable<T>>
{
	public abstract T peek();
	public abstract T pull();
	public abstract boolean offer(T data);
}
