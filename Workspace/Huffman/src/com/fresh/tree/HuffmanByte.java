package com.fresh.tree;


public class HuffmanByte
{
	HuffmanTree<HuffmanCode<Integer>> tree;
	public HuffmanByte(Byte[] bytes)
	{
		tree = new HuffmanTree<HuffmanCode<Integer>>();
		constructTree(bytes);
	}
	
	private void constructTree(Byte[] bytes)
	{
		int[] byteCount = new int[256];
		for(int i = 0; i < bytes.length; i++)
		{
			byteCount[bytes[i]] += 1;
		}
		for(int c = 0; c < 256; c++)
		{
			if(byteCount[c] > 0)
			{
				tree.add(new HuffmanCode<Integer>(c, (byte) c));
			}
		}
	}
}
