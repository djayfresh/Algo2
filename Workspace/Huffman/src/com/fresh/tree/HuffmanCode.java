package com.fresh.tree;


public class HuffmanCode<T extends Comparable<T>> implements Comparable<HuffmanCode<T>>
{
	public T data;
	public Byte id;
	public HuffmanCode(T data, Byte id)
	{
		this.data = data;
		this.id = id;
	}
	
	@Override
	public int compareTo(HuffmanCode<T> arg0)
	{
		return id.compareTo(arg0.id);
	}
	
	@Override
	public String toString()
	{
		return "Frequancy: " + data + " | ID: " + id;
	}
}
