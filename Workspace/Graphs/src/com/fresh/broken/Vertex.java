package com.fresh.broken;

public class Vertex<T extends Comparable<T>>
{
	public int mark;
	public T data;
	public Vertex(T data)
	{
		this.data = data;
	}
}
