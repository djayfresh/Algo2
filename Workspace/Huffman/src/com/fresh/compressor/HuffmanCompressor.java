package com.fresh.compressor;

import java.math.BigInteger;

import com.fresh.tree.HuffmanTree;

import edu.neumont.io.Bits;

public class HuffmanCompressor
{
	public byte[] compress(HuffmanTree tree, byte[] b)
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
		for(int i = bits.length(); (i%8) != 0; i++)
		{
			bits += '0';
		}
		
		return new BigInteger(bits, 2).toByteArray();
	}
	public byte[] decompress(HuffmanTree tree, int uncompressedLength, byte[] byteArray)
	{
		byte[] bytes = new byte[uncompressedLength];
		Bits bits = new Bits();
		for(int i = 0; i < byteArray.length; i++)
		{
			for(int b = 0; b < 8; b++)
			{
				byte byt = byteArray[i];
				bits.add(isSet(byt,b));
			}
		}
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
