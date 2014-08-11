package com.fresh.tree;

import java.util.Comparator;
import java.util.PriorityQueue;


public class HuffmanByte
{
	public BinaryNode<HuffmanCode<Integer>> root;
	public HuffmanByte(Byte[] bytes)
	{
		printBytes(bytes);
		constructTree(bytes);
	}
	
	private void printBytes(Byte[] bytes)
	{
		int[] byteCount = new int[256];
		for(int i = 0; i < bytes.length; i++)
		{
			byteCount[bytes[i]] += 1;
		}
		String byteCode = "Byte: | ";
		String byteFrequancey = "Freq: | ";
		for(int i = 0; i < byteCount.length; i++)
		{
			if(byteCount[i] > 0)
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
		for(int i = 0; i < bytes.length; i++)
		{
			byteCount[bytes[i]] += 1;
		}
		PriorityQueue<BinaryNode<HuffmanCode<Integer>>> que = new PriorityQueue<BinaryNode<HuffmanCode<Integer>>>(
					new Comparator<BinaryNode<HuffmanCode<Integer>>>()
					{

						@Override
						public int compare(
								BinaryNode<HuffmanCode<Integer>> arg0,
								BinaryNode<HuffmanCode<Integer>> arg1)
						{
							return arg0.data.data.compareTo(arg1.data.data);
						}
					}
				);
		
		for(int c = 0; c < 256; c++)
		{
			if(byteCount[c] > 0)
			{
				que.add(new BinaryNode<HuffmanCode<Integer>>(new HuffmanCode<Integer>(byteCount[c], (byte) c), null));
			}
		}
		while(!que.isEmpty())
		{
			BinaryNode<HuffmanCode<Integer>> left = que.poll();
			BinaryNode<HuffmanCode<Integer>> right = que.poll();
			int frequancy = left.data.data;
			BinaryNode<HuffmanCode<Integer>> parent = new BinaryNode<HuffmanCode<Integer>>(new HuffmanCode<Integer>(frequancy, (byte)left.data.id), null);
			parent.setLeft(left);
			parent.setRight(right);
			if(right != null)
			{
				frequancy += right.data.data;
				que.add(parent);
				root = parent;
			}
			parent.data.data = frequancy;
		}
	}
}
