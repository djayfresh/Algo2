package com.fresh.compressor;

import java.math.BigInteger;

import com.fresh.tree.HuffmanTree;

import edu.neumont.io.Bits;

public class HuffmanCompressor
{
	public byte[] compress(HuffmanTree tree, byte[] b)
	{
		String bits = toBitString(tree, b);
		System.out.println("Bits-No Padding: " + bits);
		for(int i = bits.length(); (i%8) != 0; i++)
		{
			bits += '0';
		}
		System.out.println("Bits-With Padding: " + bits);
		return new BigInteger(bits, 2).toByteArray();
	}
	public String toBitString(HuffmanTree tree, byte[] b)
	{
		String bits = "";
		for(int i = 0; i < b.length; i++)
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
		for(int i = 0; i < byteArray.length; i++)
		{
			byte byt = byteArray[i];
			for(int b = 7; b >= 0; b--)
			{
				bits.add(isSet(byt,b));
			}
		}
		System.out.println("Decompressed bits: " + tree.toBitString(bits));
		for(int i = 0; i < bytes.length; i++)
		{
			bytes[i] = tree.toByte(bits);
		}
		return bytes;
	}
	
	private boolean isSet(byte value, int bit){
		return (value & (1 << bit)) != 0;
	}
}
