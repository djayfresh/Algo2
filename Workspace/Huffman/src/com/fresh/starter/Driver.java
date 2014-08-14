package com.fresh.starter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.fresh.tree.HuffmanTree;

public class Driver
{
	public static void main(String [] args)
	{
		File file = new File("compressed.huff");
		
		byte[] bytes = new byte[(int) file.length()];
		try
		{
			FileInputStream img = new FileInputStream(file);
			img.read(bytes);
			HuffmanTree tree = new HuffmanTree(bytes);
			
			img.close();
			tree.printBytes(bytes);
			
			
		} catch (IOException e)
		{
			System.out.println("Didn't work...");
			e.printStackTrace();
		}
	}
}
