package com.fresh.graph;

import java.lang.reflect.Array;
import java.util.List;

public class MatrixGraph<T extends Vertex<E>, E extends Comparable<E>> extends Graph<T,E>
{
	private ClassGraph graph;
	private T[][] matrix;
	@SuppressWarnings("unchecked")
	public MatrixGraph(int n, Class<T> tClass)
	{
		graph = new ClassGraph(n);
		matrix = (T[][]) Array.newInstance(tClass, n);
	}
	
	public int vCount()
	{
		return matrix.length;
	}
	@Override
	public boolean add(T p1, T p2)
	{
		return false;
	}

	@Override
	public boolean remove(T p1, T p2)
	{
		return false;
	}

	@Override
	public List<T> retreive(T p1)
	{
		return null;
	}

	@Override
	public int mark(T p1)
	{
		return 0;
	}

	@Override
	public T first(T p1)
	{
		return null;
	}

	@Override
	public T next(T p2, T p1)
	{
		return null;
	}

}
