package com.fresh.tree;

import java.util.List;

public class AVLTree<T extends Comparable<T>> extends Tree<T>
{
	BinaryNode<T> root;
	
	@Override
	public boolean add(T data)
	{
		return false;
	}

	@Override
	public boolean delete(T data)
	{
		return false;
	}

	@Override
	public boolean insert(T data)
	{
		return insert(root, null, data);
	}

	private boolean insert(BinaryNode<T> node, BinaryNode<T> parent, T data)
	{
		if(root == null)
		{
			root = new BinaryNode<T>(data, null);
			return true;
		}
		else if(node == null)
		{
			int compared = data.compareTo(parent.data);
			if(compared > 0)
			{
				parent.setRight(new BinaryNode<T>(data, parent));
				return true;
			}

			if(compared < 0)
			{
				parent.setLeft(new BinaryNode<T>(data, parent));
				return true;
			}
		}
		else
		{
			int compared = data.compareTo(node.data);
			if(compared > 0)
			{
				insert(node.getRight(), node, data);
			}
			if(compared < 0)
			{
				insert(node.getLeft(), node, data);
			}
		}
		return false;
	}
	
	private BinaryNode<T> rightRotate(BinaryNode<T> node)
	{
		BinaryNode<T> leftNode = node.left; //store left node
		node.left = leftNode.right;
		leftNode.right = node;
		return leftNode;
	}
	
	private BinaryNode<T> leftRotate(BinaryNode<T> node)
	{
		BinaryNode<T> rightNode = node.right; //store right node
		node.right = rightNode.left;
		rightNode.left = node;
		return rightNode;
	}
	
	@Override
	public int height()
	{
		return 0;
	}

	@Override
	public int levels()
	{
		return 0;
	}

	@Override
	public void clear()
	{
		root = null;
	}

	@Override
	public void rebalance()
	{
	}

	@Override
	public List<T> ancestors(T data)
	{
		return null;
	}

	@Override
	public boolean contains(T data)
	{
		return false;
	}

	@Override
	public List<T> preorder()
	{
		return null;
	}

	@Override
	public List<T> postorder()
	{
		return null;
	}

	@Override
	public List<T> inorder()
	{
		return null;
	}

	@Override
	public boolean remove(T data)
	{
		return false;
	}

}
