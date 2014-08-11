package com.tests.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fresh.tree.HuffmanByte;
import com.fresh.tree.HuffmanTree;
import com.fresh.tree.Tree;

public class HuffmanTeset
{

	//@Test
	public void test()
	{
		
	}
	
	
	@Test
	public void byteHuffman()
	{
		Byte[] bytes = new Byte[10];
		bytes[0] = 'A';
		bytes[1] = 'C';
		bytes[2] = 'A';
		bytes[3] = 'B';
		bytes[4] = 'B';
		bytes[5] = 'B';
		bytes[6] = 'B';
		bytes[7] = 'B';
		bytes[8] = 'B';
		bytes[9] = 'B';
		
		HuffmanByte byteTree = new HuffmanByte(bytes);

		System.out.println("Root: " + byteTree.root.data);
		System.out.println("Left: " + byteTree.root.getLeft().data);
		System.out.println("Right: " + byteTree.root.getRight().data);
		System.out.println("Left - Left: " + byteTree.root.getLeft().getLeft().data);
		System.out.println("Left - Right: " + byteTree.root.getLeft().getRight().data);
		System.out.println();
		
	}
	
	@Test
	public void byteHuffmanTest2()
	{
		Byte[] bytes = new Byte[10];
		bytes[0] = 'A';
		bytes[1] = 'C';
		bytes[2] = 'A';
		bytes[3] = 'A';
		bytes[4] = 'A';
		bytes[5] = 'C';
		bytes[6] = 'B';
		bytes[7] = 'D';
		bytes[8] = 'B';
		bytes[9] = 'B';
		
		HuffmanByte byteTree = new HuffmanByte(bytes);

		System.out.println("Root: " + byteTree.root.data);
		System.out.println("Left: " + byteTree.root.getLeft().data);
		System.out.println("Left - Left: " + byteTree.root.getLeft().getLeft().data);
		System.out.println("Left - Left - Left: " + byteTree.root.getLeft().getLeft().getLeft().data);
		System.out.println("Left - Left - Right: " + byteTree.root.getLeft().getLeft().getRight().data);
		System.out.println("Left - Right: " + byteTree.root.getLeft().getRight().data);
		System.out.println("Right: " + byteTree.root.getRight().data);
		//System.out.println("Right - Left: " + byteTree.root.getRight().getLeft().data);
		//System.out.println("Right - Right: " + byteTree.root.getRight().getRight().data);
		System.out.println();
	}

}
