package com.fresh.broken;

import java.lang.reflect.Array;
import java.util.List;

import com.fresh.graph.ClassGraph;

public class MatrixGraph<T extends Vertex<E>, E extends Comparable<E>>
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
	public boolean add(T p1, T p2)
	{
		return false;
	}

	public boolean remove(T p1, T p2)
	{
		return false;
	}

	public List<T> retreive(T p1)
	{
		return null;
	}

	public int mark(T p1)
	{
		return 0;
	}

	public T first(T p1)
	{
		return null;
	}

	public T next(T p2, T p1)
	{
		return null;
	}

}
