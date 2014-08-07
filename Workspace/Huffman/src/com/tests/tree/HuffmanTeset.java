package com.tests.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fresh.tree.HuffmanTree;
import com.fresh.tree.Tree;

public class HuffmanTeset
{

	@Test
	public void test()
	{
		Byte[] bytes = new Byte[1];
		bytes[0] = 0;
		HuffmanTree<Integer> tree = new HuffmanTree<Integer>(bytes);
		tree.insert(3);
		System.out.println(tree.root.data);
	}

}
