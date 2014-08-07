package com.fresh.tree;

public class BinaryNode<T>
{
	Node<T> left;
	Node<T> right;
	Node<T> parent;
	T data;

	public BinaryNode(T data, Node<T> parent)
	{
		this.parent = parent;
		this.data = data;
	}

	public void setLeft(Node<T> child)
	{
		this.left = child;
	}

	public void setRight(Node<T> child)
	{
		this.right = child;
	}

	public Node<T> getLeft()
	{
		return left;
	}

	public Node<T> getRight()
	{
		return right;
	}

	public Node<T> getParent()
	{
		return parent;
	}
}
