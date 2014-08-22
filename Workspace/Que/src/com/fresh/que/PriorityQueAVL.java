package com.fresh.que;

import com.fresh.tree.AVLTree;

public class PriorityQueAVL<T extends Comparable<T>> extends PriorityQue<T>
{
	AVLTree<T> tree = new AVLTree<T>();
	@Override
	public T peek()
	{
		return tree.peek();
	}

	@Override
	public T pull()
	{
		return tree.pull();
	}

	@Override
	public boolean offer(T data)
	{
		return tree.insert(data);
	}

}
