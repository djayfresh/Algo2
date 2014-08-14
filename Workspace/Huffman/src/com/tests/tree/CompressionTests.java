package com.tests.tree;

import org.junit.Test;

import com.fresh.compressor.HuffmanCompressor;
import com.fresh.tree.HuffmanTree;

public class CompressionTests
{

	@Test
	public void test()
	{
		String message = "I would love to be eating cookies right now. Just saying..";
		message = "Hello";
		
		System.out.println("Message: " + message);
		byte[] bytes = message.getBytes();
		
		HuffmanTree tree = new HuffmanTree(bytes);
		tree.printBytes(bytes);
		HuffmanCompressor cmp = new HuffmanCompressor();
		
		byte[] cmpBytes = cmp.compress(tree, bytes);
		System.out.println(new String(cmpBytes));
		
		byte[] decmp = cmp.decompress(tree, bytes.length, cmpBytes);

		tree.printBytes(decmp);
		System.out.println(new String(decmp));
	}

}
