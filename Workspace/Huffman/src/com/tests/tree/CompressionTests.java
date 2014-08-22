package com.tests.tree;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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

	@Test
	public void longTest()
	{
		String message = "I would love to be eating cookies right now. Just saying..";
		//message = "Hello";
		
		System.out.println("Message: " + message);
		byte[] bytes = message.getBytes();
		
		HuffmanTree tree = new HuffmanTree(bytes);
		tree.printBytes(bytes);
		HuffmanCompressor cmp = new HuffmanCompressor();
		
		byte[] cmpBytes = cmp.compress(tree, bytes);
		System.out.println(new String(cmpBytes));
		
		byte[] decmp = cmp.decompress(tree, bytes.length, cmpBytes);

		tree.printBytes(decmp);
		System.out.println("Decompressed message: " + new String(decmp));
	}
	
	@Test
	public void negative()
	{
		byte[] bytes = {-5, -2, -2, -2, 5, 2, 2, 5};
		HuffmanTree tree = new HuffmanTree(bytes);
		tree.printBytes(bytes);
		HuffmanCompressor cmp = new HuffmanCompressor();
		byte[] comp = cmp.compress(tree, bytes);
		System.out.println("Compression");
		tree.printBytes(comp);
		byte[] decomp = cmp.decompress(tree, bytes.length, comp);
		System.out.println("decompression");
		tree.printBytes(decomp);
	}
}
