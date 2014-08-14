package com.fresh.starter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.omg.CORBA.FREE_MEM;

import com.fresh.compressor.HuffmanCompressor;
import com.fresh.tree.HuffmanTree;

public class Driver
{
	public static int[] freqancyData = {423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107, 149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195, 139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149, 194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179, 148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149, 167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163, 335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374, 160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205, 121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156, 119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177, 159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445, 1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124, 152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244, 145, 167, 167, 262, 214, 293, 402};
	public static void main(String [] args)
	{
		File file = new File("compressed.huff");
		
		byte[] bytes = new byte[54679];
		HuffmanTree tree = new HuffmanTree(new byte[0]);
		tree.constructTree(Driver.freqancyData);
		System.out.println("Frequancy");
		tree.printBytes(Driver.freqancyData);
		HuffmanCompressor comp = new HuffmanCompressor();
		try
		{
			FileInputStream img = new FileInputStream(file);
			img.read(bytes);
			
			img.close();
			System.out.println("De-compression");
			tree = new HuffmanTree(bytes);
			bytes = comp.decompress(tree, 54679, bytes);
			tree.printBytes(bytes);
			tree = new HuffmanTree(bytes);
			System.out.println("Compression");
			bytes = comp.compress(tree, bytes);
			tree.printBytes(bytes);
			
			
		} catch (IOException e)
		{
			System.out.println("Didn't work...");
			e.printStackTrace();
		}
	}
}
