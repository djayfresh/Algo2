package com.fresh.tree;

import java.util.List;

public abstract class Tree<T extends Comparable<T>> {
	
	public abstract boolean add(T data);
	public abstract boolean delete(T data);
	public abstract boolean insert(T data);
	public abstract boolean remove(T data);
	public abstract int height();
	public abstract int levels();
	public abstract void clear();
	public abstract void rebalance();
	public abstract List<T> ancestors(T data);
	public abstract boolean contains(T data);
	public abstract List<T> preorder();
	public abstract List<T> postorder();
	public abstract List<T> inorder();
	
}