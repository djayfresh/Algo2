package com.fresh.tree;

public class Node<T extends Comparable<T>>
{
	Node<T> child;
	Node<T> parent;
	T data;
	
	public Node(Node<T> parent, T data)
	{
		this.parent = parent;
		this.data = data;
	}
	
	public void setChild(Node<T> child)
	{
		this.child = child;
	}
	
	public Node<T> getChild()
	{
		return child;
	}
	
	public Node<T> getParent()
	{
		return parent;
	}
}
