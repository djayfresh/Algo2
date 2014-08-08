package com.fresh.tree;


public class HuffmanCode<T extends Comparable<T>> implements Comparable<HuffmanCode<T>>
{
	public Integer data;
	public Byte id;
	public HuffmanCode(Integer data, Byte id)
	{
		this.data = data;
		this.id = id;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(HuffmanCode<T> arg0)
	{
		return data.compareTo(arg0.data);
	}
}
