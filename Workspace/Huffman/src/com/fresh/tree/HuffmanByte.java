package com.fresh.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

import edu.neumont.io.Bits;

public class HuffmanByte
{
	public BinaryNode<HuffmanCode<Integer>> root;
	private Bits[] keys = new Bits[256];

	public HuffmanByte(Byte[] bytes)
	{
		constructTree(bytes);
	}

	public void printBytes(Byte[] bytes)
	{
		int[] byteCount = new int[256];
		for (int i = 0; i < bytes.length; i++)
		{
			byteCount[bytes[i]] += 1;
		}
		String byteCode = "Byte: | ";
		String byteFrequancey = "Freq: | ";
		for (int i = 0; i < byteCount.length; i++)
		{
			if (byteCount[i] > 0)
			{
				byteCode += i + " | ";
				byteFrequancey += byteCount[i] + " | ";
			}
		}
		System.out.println(byteCode);
		System.out.println(byteFrequancey);
	}

	private void constructTree(Byte[] bytes)
	{
		int[] byteCount = new int[256];
		for (int i = 0; i < bytes.length; i++)
		{
			byteCount[bytes[i]] += 1;
		}
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

		for (int c = 0; c < 256; c++)
		{
			if (byteCount[c] > 0)
			{
				que.add(new BinaryNode<HuffmanCode<Integer>>(
						new HuffmanCode<Integer>(byteCount[c], (byte) c), null));
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
		constructKey(root.left, new Bits(), true);
		constructKey(root.right, new Bits(), false);
	}

	private void constructKey(BinaryNode<HuffmanCode<Integer>> current,
			Bits path, boolean wentLeft)
	{
		if (current != null)
		{
			path.add(!wentLeft);
			if (current.isLeaf())
			{
				keys[current.data.id] = path;
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
		byte b = -1;
		BinaryNode<HuffmanCode<Integer>> current = root;
		for (int i = 0; i < bits.size(); i++)
		{
			if (bits.get(i))
			{
				current = current.right;
			}
			else
			{
				current = current.left;
			}
			if (current.isLeaf())
			{
				b = current.data.id;
				break;
			}
		}
		return b;
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
		bits.addAll(keys[b]);
	}
}
