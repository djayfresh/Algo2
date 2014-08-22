package com.fresh.tree;

public class BinaryNode<T extends Comparable<T>>
{
	BinaryNode<T> left;
	BinaryNode<T> right;
	BinaryNode<T> parent;
	public T data;

	public BinaryNode(T data, BinaryNode<T> parent)
	{
		this.parent = parent;
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setLeft(BinaryNode<T> child)
	{
		this.left = child;
	}

	public void setRight(BinaryNode<T> child)
	{
		this.right = child;
	}

	public BinaryNode<T> getLeft()
	{
		return left;
	}

	public BinaryNode<T> getRight()
	{
		return right;
	}

	public BinaryNode<T> getParent()
	{
		return parent;
	}

	@Override
	public String toString()
	{
		return data.toString();
	}

	public boolean isLeaf()
	{
		return right == null && left == null;
	}
}
