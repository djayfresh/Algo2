package com.fresh.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuffmanTree<T extends Comparable<T> > extends Tree<T>
{
	public BinaryNode<T> root;
	public HuffmanTree(Byte[] bytes)
	{
		constructTree(bytes);
	}
	
	private void constructTree(Byte[] bytes)
	{
		Map<Byte, Integer> total = new HashMap<Byte, Integer>();
		
		for(int i = 0; i < bytes.length; i++)
		{
			int count = 0;
			for(int c = 0; c < bytes.length; c++)
			{
				if(bytes[i] == bytes[c])
				{
					count++;
				}
			}
			int value = 0;
			Integer intValue = total.get(bytes[i]);
			if(intValue != null)
			{
				value = intValue.intValue();
			}
			total.put(bytes[i], count + value);
		}
		int keyCount = total.keySet().size();
		for(int k = 0; k < keyCount; k++)
		{
			
			
		}
	}
	
	public boolean insert(T data)
	{
		return insert(root, data);
	}
	
	private boolean insert(BinaryNode<T> node, T data)
	{
		if(root == null)
		{
			root = new BinaryNode<T>(data, null);
			return true;
		}
		else if(node == null)
		{
			return false;
		}
		int compared = data.compareTo(node.data);
		if(compared > 0)
		{
			if(node.getRight() == null)
			{
				node.setRight(new BinaryNode<T>(data, node));
				return true;
			}
			else
			{
				insert(node.getRight(), data);
			}
		}
		if(compared < 0)
		{
			if(node.getLeft() == null)
			{
				node.setLeft(new BinaryNode<T>(data, node));
				return true;
			}
			else
			{
				insert(node.getLeft(), data);
			}
		}
		return false;
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
	public List<T> ancestors(T obj)
	{
		return null;
	}

	@Override
	public boolean contains(T obj)
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
	public boolean add(T obj)
	{
		return insert(root, null, obj);
	}

	@Override
	public boolean delete(T obj)
	{
		return false;
	}

	@Override
	public boolean remove(T obj)
	{
		return false;
	}
}
