package com.tests.tree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import com.fresh.tree.HuffmanTree;

import edu.neumont.io.Bits;

public class HuffmanTeset
{

	// @Test
	public void test()
	{

	}

	@Test
	public void byteHuffman()
	{
		System.out.println("\nHuffman Test:-----------\n");
		byte[] bytes = new byte[10];
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

		HuffmanTree byteTree = new HuffmanTree(bytes);

		System.out.println("Root: " + byteTree.root.data);
		System.out.println("Left: " + byteTree.root.getLeft().data);
		System.out.println("Right: " + byteTree.root.getRight().data);
		System.out.println("Left - Left: "
				+ byteTree.root.getLeft().getLeft().data);
		System.out.println("Left - Right: "
				+ byteTree.root.getLeft().getRight().data);
		System.out.println();

	}

	@Test
	public void byteHuffmanTest2()
	{
		System.out.println("\nHuffman Test 2:-----------\n");
		byte[] bytes = new byte[10];
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

		HuffmanTree byteTree = new HuffmanTree(bytes);

		System.out.println("Root: " + byteTree.root.data);
		System.out.println("Left: " + byteTree.root.getLeft().data);
		System.out.println("Left - Left: "
				+ byteTree.root.getLeft().getLeft().data);
		System.out.println("Left - Left - Left: "
				+ byteTree.root.getLeft().getLeft().getLeft().data);
		System.out.println("Left - Left - Right: "
				+ byteTree.root.getLeft().getLeft().getRight().data);
		System.out.println("Left - Right: "
				+ byteTree.root.getLeft().getRight().data);
		System.out.println("Right: " + byteTree.root.getRight().data);
		// System.out.println("Right - Left: " +
		// byteTree.root.getRight().getLeft().data);
		// System.out.println("Right - Right: " +
		// byteTree.root.getRight().getRight().data);
		System.out.println();
	}

	@Test
	public void fromByteTest()
	{
		System.out.println("\nFrom Byte Test:-----------\n");
		byte[] bytes = new byte[10];
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
		
		byte byteTest = 'C';
		
		HuffmanTree byteTree = new HuffmanTree(bytes);
		byteTree.printBytes(bytes);
		Bits bits = new Bits();
		byteTree.fromByte(byteTest, bits);
		System.out.print(byteTest + ": " );
		for(int i = 0; i < bits.size(); i++)
		{
			System.out.print(bits.get(i)? '1' : '0');
		}
		System.out.println();
	}
	
	@Test
	public void toByteTest()
	{
		System.out.println("\nFrom Byte Test:-----------\n");
		/*Byte[] bytes = new Byte[10];
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
		*/
		byte[] bytes = "Four score and seven years ago".getBytes();
		
		byte byteTest = 'e';
		
		HuffmanTree byteTree = new HuffmanTree(bytes);
		byteTree.printBytes(bytes);
		Bits bits = new Bits();
		byteTree.fromByte(byteTest, bits);
		System.out.print(byteTest + ": " );
		for(int i = 0; i < bits.size(); i++)
		{
			System.out.print(bits.get(i)? '1' : '0');
		}
		System.out.println();
		
		byte outcome = byteTree.toByte(bits);
		System.out.println("Mapped to: " + outcome);
	}
	
	@Test
	public void fileTest()
	{
		System.out.println("\nFile Byte Test:-----------\n");
		
		File file = new File("compressed.huff");
		
		byte[] bytes = new byte[(int) file.length()];
		try
		{
			FileInputStream img = new FileInputStream(file);
			img.read(bytes);
			HuffmanTree tree = new HuffmanTree(bytes);
			
			img.close();
			tree.printBytes(bytes);
			
			
		} catch (Exception e)
		{
			System.out.println("Didn't work...");
			e.printStackTrace();
		}
	}
}
