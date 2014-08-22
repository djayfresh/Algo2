package com.fresh.starter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fresh.compressor.HuffmanCompressor;
import com.fresh.tree.HuffmanTree;

public class Driver
{
	public static int[] freqancyData = {423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107, 149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195, 139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149, 194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179, 148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149, 167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163, 335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374, 160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205, 121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156, 119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177, 159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445, 1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124, 152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244, 145, 167, 167, 262, 214, 293, 402};
	public static void main(String [] args) throws Exception
	{
		
//		byte[] bytes = new byte[54679];
		HuffmanTree tree = new HuffmanTree(Driver.freqancyData);
		HuffmanCompressor hc = new HuffmanCompressor();
		byte[] compressed = Files.readAllBytes(Paths.get("compressed.huff"));
		byte[] b = hc.decompress(tree, 54679, compressed);
		tree.printBytes(b);
//		//System.out.println("Frequancy");
//		//tree.printBytes(Driver.freqancyData);
//		HuffmanCompressor comp = new HuffmanCompressor();
//		try
//		{
//			bytes = Files.readAllBytes(Paths.get("cookie.png"));
//			int originalSize = bytes.length;
//			tree = new HuffmanTree(bytes);
//			tree.printBytes(bytes);
//			System.out.println("Compression");
//			bytes = comp.compress(tree, bytes);
//			System.out.println("De-compression");
//			bytes = comp.decompress(tree, originalSize, bytes);
//			Files.write(Paths.get("DePressedCookie.png"), bytes);
//			//tree = new HuffmanTree(bytes);
//			Bits bits = new Bits();
//			Boolean[] bool = {true, true, true, true, true, false, true, true};
//			bits.add(true);
//			bits.add(true);
//			bits.add(true);
//			bits.add(true);
//			bits.add(true);
//			bits.add(false);
//			bits.add(true);
//			bits.add(true);
//			byte b = tree.toByte(bits);
//			System.out.println("test byte: " + b);
//			System.out.println("Tree-From File");
//			tree.printBytes(bytes);
//			Files.write(Paths.get("Image.jpg"), bytes);
//			//tree = new HuffmanTree(bytes);
//			//System.out.println("Compression");
//			//bytes = comp.compress(tree, bytes);
//			//tree.printBytes(bytes);
//			
//			
//		} catch (IOException e)
//		{
//			System.out.println("Didn't work...");
//			e.printStackTrace();
//		}
		//loadToNewFile("compressed.huff", ".jpg");
		//loadToNewImage("cookie.png", ".png");
		
	}
	
	public static void loadToNewFile(String file, String fileExtension)
	{
		byte[] bytes = new byte[54679];
		HuffmanTree tree = new HuffmanTree(new byte[0]);
		tree.constructTree(Driver.freqancyData);
		//System.out.println("Frequancy");
		//tree.printBytes(Driver.freqancyData);
		HuffmanCompressor comp = new HuffmanCompressor();
		try
		{
			bytes = Files.readAllBytes(Paths.get(file));
			System.out.println("De-compression");
			bytes = comp.decompress(tree, 54679, bytes);
			Files.write(Paths.get(file.substring(0, file.indexOf('.')) + fileExtension), bytes);
		} catch (IOException e)
		{
			System.out.println("Didn't work...");
			e.printStackTrace();
		}
	}
	
	public static void loadToNewImage(String file, String fileExtension)
	{
		byte[] bytes = new byte[54679];
		HuffmanTree tree = new HuffmanTree(new byte[0]);
		HuffmanCompressor comp = new HuffmanCompressor();
		try
		{
			bytes = Files.readAllBytes(Paths.get(file));
			int originalSize = bytes.length;
			tree = new HuffmanTree(bytes);
			tree.printBytes(bytes);
			System.out.println("Compression");
			bytes = comp.compress(tree, bytes);
			System.out.println("De-compression");
			bytes = comp.decompress(tree, originalSize, bytes);
			Files.write(Paths.get("New-" + file.substring(0, file.indexOf('.')) + fileExtension), bytes);
		} catch (IOException e)
		{
			System.out.println("Didn't work...");
			e.printStackTrace();
		}
	}
}
