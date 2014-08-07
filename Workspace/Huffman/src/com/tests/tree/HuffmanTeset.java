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
		System.out.println("Root: " + tree.root.data);
		tree.add(1);
		System.out.println("Left: " + tree.root.getLeft().data);
		tree.insert(4);
		System.out.println("Right: " + tree.root.getRight().data);
		tree.add(5);
		System.out.println("Right - Right: " + tree.root.getRight().getRight().data);
		tree.add(2);
		System.out.println("Left - Right: " + tree.root.getLeft().getRight().data);
	}

}
