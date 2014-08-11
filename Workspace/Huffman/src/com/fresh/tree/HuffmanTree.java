package com.fresh.tree;

import java.util.List;


public class HuffmanTree<T extends Comparable<T>>
{
	public BinaryNode<T> root;
	
	public boolean insert(T data)
	{
		return insert(root, null, data);
	}
	
	private boolean insert(BinaryNode<T> node, BinaryNode<T> parent, T data)
	{
		return false;
	}

	public int height()
	{
		return height(root);
	}
	
	private int height(BinaryNode<T> node)
	{
		if(node == null)
			return 0;
		else
		{
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}

	public int levels()
	{
		return height() - 1;
	}

	public void clear()
	{
		root = null;
	}

	public boolean contains(T obj)
	{
		return false;
	}

	public List<T> preorder()
	{
		return null;
	}

	public List<T> postorder()
	{
		return null;
	}

	public List<T> inorder()
	{
		return null;
	}

	public boolean add(T left, T right)
	{
		if(root == null)
		{
			root = new BinaryNode<T>(left, null);
			root.setLeft(new BinaryNode<T>(left, root));
			if(right != null)
			{
				root.setRight(new BinaryNode<T>(right, root));
			}
		}
		else if(root.right == null)
		{
			root.setRight(new BinaryNode<T>(left, null));
		}
		else
		{
			BinaryNode<T> tmp = new BinaryNode<T>(left, null);
			tmp.setLeft(root);
			BinaryNode<T> tmpr = new BinaryNode<T>(left,null);
			if(right != null)
			{
				tmpr.setLeft(new BinaryNode<T>(left, tmp));
				tmpr.setRight(new BinaryNode<T>(right, tmp));
			}
			tmp.setRight(tmpr);
			root = tmp;
		}
		
		return true;
	}
}
