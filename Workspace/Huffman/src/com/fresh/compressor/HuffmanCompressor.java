package com.fresh.compressor;

import java.math.BigInteger;

import com.fresh.tree.HuffmanTree;

import edu.neumont.io.Bits;

public class HuffmanCompressor
{
	public byte[] compress(HuffmanTree tree, byte[] b)
	{
		String bits = toBitString(tree, b);
		//System.out.println("Bits-No Padding: " + bits);
		for(int i = bits.length(); (i%8) != 0; i++)
		{
			bits += '0';
		}
		//System.out.println("Bits-With Padding: " + bits);
		byte[] compressed = new byte[bits.length() / 8];
		for(int c = 0; c < compressed.length; c++)
		{
			String bitSub = bits.substring(c*8, 8 + (c*8));
			//System.out.println("Bit sub: " + bitSub);
			compressed[c] = (byte) Integer.parseInt(bitSub, 2);
		}
		System.out.print("Compressed bytes: ");
		for(int c = 0; c < compressed.length; c++)
		{
			System.out.print(compressed[c] + " ");
			
		}
		System.out.println();
		return compressed;
	}
	public String toBitString(HuffmanTree tree, byte[] b)
	{
		String bits = "";
		for(int i = b.length-1; i >= 0; i--)
		{
			Bits thisMessage = new Bits();
			tree.fromByte(b[i], thisMessage);
			for(int m = 0; m < thisMessage.size(); m++)
			{
				bits += thisMessage.get(m) ? '1' : '0';
			}
		}
		return bits;
	}
	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] byteArray)
	{
		byte[] bytes = new byte[uncompressedLength];
		Bits bits = new Bits();
		System.out.print("Decompressed byte: ");
		for(int i = 0; i < byteArray.length; i++)
		{
			byte byt = byteArray[i];
			System.out.print(byt + " ");
			for(int b = 7; b >= 0; b--)
			{
				bits.add(isSet(byt,b));
			}
		}
		//System.out.println("Decompressed bits: " + tree.toBitString(bits));
		System.out.print("Decompressed bytes: ");
		for(int i = bytes.length-1; i >=0; i--)
		{
			bytes[i] = tree.toByte(bits);
			System.out.print(bytes[i] + " ");
		}
		System.out.println();
		return bytes;
	}
	
	private boolean isSet(byte value, int bit){
		return (value & (1 << bit)) != 0;
	}
}
