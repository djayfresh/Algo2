package com.fresh.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

import edu.neumont.io.Bits;

public class HuffmanTree
{
	public BinaryNode<HuffmanCode<Integer>> root;
	private Bits[] keys = new Bits[256];

	public HuffmanTree(byte[] bytes)
	{
		constructTree(frequancyCount(bytes));
	}

	public void printBytes(byte[] bytes)
	{
		int[] byteCount = frequancyCount(bytes);
		String byteCode = "Byte: | ";
		String byteFrequancey = "Freq: | ";
		for (int i = 0; i < byteCount.length; i++)
		{
			if (byteCount[i] > 0)
			{
				byteCode += (i-128) + " | ";
				byteFrequancey += byteCount[i] + " | ";
			}
		}
		System.out.println(byteCode);
		System.out.println(byteFrequancey);
	}
	
	public void printBytes(int[] byteCount)
	{
		String byteCode = "Byte: | ";
		String byteFrequancey = "Freq: | ";
		for (int i = 0; i < byteCount.length; i++)
		{
			if (byteCount[i] > 0)
			{
				byteCode += (i-128) + " | ";
				byteFrequancey += byteCount[i] + " | ";
			}
		}
		System.out.println(byteCode);
		System.out.println(byteFrequancey);
	}
	public int[] frequancyCount(byte[] bytes)
	{
		int[] byteCount = new int[256];
		for (int i = 0; i < bytes.length; i++)
		{
			byteCount[bytes[i]+128] += 1;
		}
		return byteCount;
	}
	public void constructTree(int[] byteCount)
	{
		PriorityQueue<BinaryNode<HuffmanCode<Integer>>> que = new PriorityQueue<BinaryNode<HuffmanCode<Integer>>>(
				new Comparator<BinaryNode<HuffmanCode<Integer>>>()
				{
					@Override
					public int compare(BinaryNode<HuffmanCode<Integer>> arg0,
							BinaryNode<HuffmanCode<Integer>> arg1)
					{
						return arg0.data.data.compareTo(arg1.data.data);
					}
				});

		for (int c = 0; c < byteCount.length; c++)
		{
			if (byteCount[c] > 0)
			{
				que.add(new BinaryNode<HuffmanCode<Integer>>(
						new HuffmanCode<Integer>(byteCount[c], (byte) (c-128)), null));
			}
		}
		while (!que.isEmpty())
		{
			BinaryNode<HuffmanCode<Integer>> left = que.poll();
			BinaryNode<HuffmanCode<Integer>> right = que.poll();
			int frequancy = left.data.data;
			BinaryNode<HuffmanCode<Integer>> parent = new BinaryNode<HuffmanCode<Integer>>(
					new HuffmanCode<Integer>(frequancy, (byte) left.data.id),
					null);
			left.parent = parent;
			parent.setLeft(left);
			parent.setRight(right);
			if (right != null)
			{
				right.parent = parent;
				frequancy += right.data.data;
				que.add(parent);
				root = parent;
			}
			parent.data.data = frequancy;
		}
		if(root != null)
		{
			constructKey(root.left, new Bits(), true);
			constructKey(root.right, new Bits(), false);
		}
	}

	private void constructKey(BinaryNode<HuffmanCode<Integer>> current,
			Bits path, boolean wentLeft)
	{
		if (current != null)
		{
			path.add(!wentLeft);
			if (current.isLeaf())
			{
				System.out.println("Code: byte " + current.data.id + " key: " + toBitString(path));
				keys[current.data.id+128] = new Bits();
				keys[current.data.id+128].addAll(path);
			}
			else
			{
				// LEFT
				Bits leftBits = new Bits();
				leftBits.addAll(path);
				constructKey(current.left, leftBits, true);

				// RIGHT
				Bits rightBits = new Bits();
				rightBits.addAll(path);
				constructKey(current.right, rightBits, false);
			}
		}
	}

	/**
	 * reads the next byte from a queue of bits by traversing the Huffman tree
	 * 
	 * @param bits
	 *            - message, to modify pull bits off as used till leaf
	 * @return byte - leaf/data
	 */
	public byte toByte(Bits bits)
	{
		return toByte(root, bits);
	}
	
	private byte sometihing(Bits bits)
	{
		byte b = -1;
		BinaryNode<HuffmanCode<Integer>> current = root;
		for (int i = 0; i < bits.size(); i++)
		{
			if (current.isLeaf())
			{
				b = current.data.id;
				break;
			}
			if (bits.pop())
			{
				current = current.right;
			}
			else
			{
				current = current.left;
			}
		}
		return b;
	}
	
	private byte toByte(BinaryNode<HuffmanCode<Integer>> current, Bits bits)
	{
		if(current.isLeaf())
			return current.data.id;
		if(bits.pop())
		{
			return toByte(current.right, bits);
		}
		else
		{
			return toByte(current.left, bits);
		}
	}

	/**
	 * writes the bits indicated by the Huffman tree for the given byte
	 * 
	 * @param b
	 *            - byte
	 * @param bits
	 *            - writing to bits as the steps to bits
	 */
	public void fromByte(byte b, Bits bits)
	{
		bits.addAll(keys[b+128]);
	}
	
	
	public String toBitString(Bits bits)
	{
		String message ="";
		for(int m = 0; m < bits.size(); m++)
		{
			message += bits.get(m) ? '1' : '0';
		}
		return message;
	}
}
