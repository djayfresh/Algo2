package com.fresh.tree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> extends Tree<T>
{
	BinaryNode<T> root;

	@Override
	public boolean add(T data)
	{
		return insert(data);
	}

	public void colterIsWrongTest()
	{
		System.out.println("COLTER TEST BEFORE: " + root);
		colterIsWrong(root);
		System.out.println("COLTER TEST AFTER: " + root);
	}
	public void colterIsWrong(BinaryNode<T> node)
	{
		node = null;

	}

	@Override
	public boolean delete(T data)
	{

		return delete(data, root, root);
	}

	private boolean delete(T data, BinaryNode<T> parent, BinaryNode<T> myParent)
	{
		if(parent != null)
		{
			int dataCmp = data.compareTo(parent.data);
			boolean deleted = false;
			if(dataCmp == 0)
			{
				if(parent.right != null)
				{
					leftMostAttachment(parent.right, parent.left);
					parent = parent.right;
				}
				else if(parent.left != null)
				{
					rightMostAttachment(parent.left, parent.right);
					parent = parent.left;
				}
				else
				{
					int comp = data.compareTo(myParent.data);
					if(comp < 0)
					{
						leftMostAttachment(parent.right, parent.left);
						myParent.left = parent.right;
					}
					else if(comp > 0)
					{
						rightMostAttachment(parent.left, parent.right);
						myParent.right = parent.right;
					}
				}
			}
			else if(dataCmp < 0)
			{
				deleted = delete(data, parent.left, parent);
			}
			else
			{
				deleted = delete(data, parent.right, parent);
			}
			return deleted;
		}
		else
		{
			return false;
		}
	}

	public void leftMostAttachment(BinaryNode<T> parent, BinaryNode<T> toConnect)
	{
		BinaryNode<T> cur = parent;
		if(cur != null)
		{
			while(cur.left != null)
			{
				cur = cur.left;
			}
			parent.left = toConnect;
		}
	}

	public void rightMostAttachment(BinaryNode<T> parent, BinaryNode<T> toConnect)
	{
		BinaryNode<T> cur = parent;

		if(cur != null)
		{
			while( cur.right != null)
			{
				cur = cur.right;
			}			
			parent.right = toConnect;
		}
	}

	public boolean offer(T data)
	{
		return insert(data);
	}

	public T peek()
	{
		BinaryNode<T> cur = root;
		while (cur.right != null)
		{
			cur = cur.right;
		}
		return cur.data; // Look to right most child
	}

	public void deleteRightMost(BinaryNode<T> cur, BinaryNode<T> parent)
	{
		if(root.right == null)
		{
			root = root.left;
		}
		if(cur.right == null)
		{
			parent.right = null;
		}
		else
		{
			deleteRightMost(parent.right, cur);
		}
	}

	public T pull()
	{
		BinaryNode<T> cur = root;
		while (cur.right != null)
		{
			cur = cur.right;
		}

		T data = cur.data;
		deleteRightMost(root, root);
		//delete(data);
		rebalance();
		return data;
	}

	@Override
	public boolean insert(T data)
	{
		return insert(root, null, data);
	}

	private boolean insert(BinaryNode<T> node, BinaryNode<T> parent, T data)
	{
		if (root == null)
		{
			root = new BinaryNode<T>(data, null);
			return true;
		}
		else if (node == null)
		{
			int compared = data.compareTo(parent.data);
			if (compared > 0)
			{
				parent.setRight(new BinaryNode<T>(data, parent));
				return true;
			}

			if (compared < 0)
			{
				parent.setLeft(new BinaryNode<T>(data, parent));
				return true;
			}
		}
		else
		{
			int compared = data.compareTo(node.data);
			if (compared > 0)
			{
				insert(node.getRight(), node, data);
			}
			if (compared < 0)
			{
				insert(node.getLeft(), node, data);
			}
		}
		return false;
	}

	private BinaryNode<T> rightRotate(BinaryNode<T> node)
	{
		BinaryNode<T> leftNode = node.left; // store left node
		node.left = leftNode.right;
		leftNode.right = node;
		return leftNode;
	}

	private BinaryNode<T> leftRotate(BinaryNode<T> node)
	{
		BinaryNode<T> rightNode = node.right; // store right node
		node.right = rightNode.left;
		rightNode.left = node;
		return rightNode;
	}

	@Override
	public int height()
	{
		return height(root);
	}
	
	private int height(BinaryNode<T> subtree) 
	{
		if(subtree == null)
			return -1;
		int lHeight = height(subtree.left);
		int rHeight = height(subtree.right);
		return Math.max(lHeight, rHeight) + 1;
	}
	
	private int balanceFactor(BinaryNode<T> subtree)
	{
		int lHeight = -1;
		int rHeight = -1;
		if(subtree.left != null)
		{
			lHeight = height(subtree.left);
		}
		if(subtree.right != null)
		{
			rHeight = height(subtree.right);
		}
		
		return lHeight - rHeight;
	}

	@Override
	public int levels()
	{
		return height() - 1;
	}

	@Override
	public void clear()
	{
		root = null;
	}

	@Override
	public void rebalance()
	{
		rebalance(root);
	}
	
	private void rebalance(BinaryNode<T> subtree)
	{
		int bf = balanceFactor(subtree);
		if(bf >= 2 || bf <= -2)
		{
			//Do something to fix this
		}
		else
		{
			//Why do you try? 
		}
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
		return preorder(root, new ArrayList<T>());
	}

	private List<T> preorder(BinaryNode<T> current, List<T> path)
	{
		return null;
	}

	@Override
	public List<T> postorder()
	{
		return postorder(root, new ArrayList<T>());
	}

	private List<T> postorder(BinaryNode<T> current, List<T> path)
	{
		return null;
	}

	@Override
	public List<T> inorder()
	{
		return inorder(root, new ArrayList<T>());
	}

	private List<T> inorder(BinaryNode<T> current, List<T> path)
	{
		return null;
	}

	@Override
	public boolean remove(T data)
	{
		return false;
	}

}
