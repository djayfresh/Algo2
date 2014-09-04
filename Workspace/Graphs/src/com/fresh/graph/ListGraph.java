package com.fresh.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListGraph
{
	public static final int VISITED = 2;
	//Vertex<T>[] verts;
	ArrayList<Edge>[] list;
	int[] marks;

	@SuppressWarnings("unchecked")
	public ListGraph(int n)
	{
		//verts = (Vertex<T>[]) Array.newInstance(verts.getClass(), n);
		list = (ArrayList<Edge>[]) Array.newInstance(list.getClass(), n);
		marks = new int[n];
	}

	public int first(int v)
	{
		return list[v].get(0).v2;
	}

	public int vCount()
	{
		return list.length;
	}
	
	public int neighborCount(int v)
	{
		return list[v].size();
	}

	public int next(int v, int lastNeighbor)
	{
		return list[v].get(lastNeighbor + 1).v2;
	}

	/**
	 * 
	 * @param vertex
	 * @param neighbor
	 * @param weight - any weight non-Zero
	 * @throws Exception for a weight of Zero
	 */
	public void addEdge(int vertex, int neighbor, int weight) throws Exception
	{
		// add 0 throw exception
		if(weight == 0)
		{
			throw new Exception("Weight of Zero");
		}
		list[vertex].add(new Edge(neighbor, weight));
	}

	public void removeEdge(int vertex, int neighbor)
	{
		list[vertex].remove(new Edge(neighbor,0));
	}
	/**
	 * 
	 * @param vertex
	 * @param neighbor
	 * @return weight of edge or Zero if no weight found
	 */
	public int weight(int vertex, int neighbor)
	{
		return isEdge(vertex, neighbor)? list[vertex].get(list[vertex].indexOf(new Edge(neighbor, 0))).weight : 0;
	}

	public boolean isEdge(int vertex, int neighbor)
	{
		return list[vertex].contains(new Edge(neighbor, 0));
	}

	public void setMark(int vertex, int mark)
	{
		marks[vertex] = mark;
	}

	public int getMark(int vertex)
	{
		return marks[vertex];
	}
	
	public void clearMarks()
	{
		marks = new int[vCount()];
	}

	private class Edge implements Comparable<Edge>
	{
		public Integer v2;
		public int weight;

		public Edge(int v2, int weight)
		{
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(ListGraph.Edge o)
		{
			return v2.compareTo(o.v2);
		}

		@Override
		public boolean equals(Object object)
		{
			return ((ListGraph.Edge) object).v2 == v2;
		}
	}
}
