package com.fresh.graph;

public class ClassGraph
{
	int[][] matrix;
	int[] marks;
	
	public ClassGraph(int n)
	{
		matrix = new int[n][n];
		marks = new int[n];
	}
	
	public int first(int v)
	{
		for(int i = 0; i < vCount(); i++)
		{
			if(matrix[v][i] != 0)
			{
				return i;
			}
		}
		return vCount();
	}
	
	public int vCount()
	{
		return matrix.length;
	}
	
	public int next(int v, int lastNeighbor)
	{
		for(int i = lastNeighbor +1; i < vCount(); i++)
		{
			if(matrix[v][i] != 0)
			{
				return i;
			}
		}
		return vCount();
	}
	
	public void addEdge(int vertex, int neighbor, int weight)
	{
		//add 0 throw exception
		matrix[vertex][neighbor] = weight;
	}
	
	public void removeEdge(int vertex, int neighbor)
	{
		matrix[vertex][neighbor] = 0;
	}
	
	public boolean isEdge(int vertex, int neighbor)
	{
		return matrix[vertex][neighbor] != 0;
	}
	
	public void setMark(int vertex, int mark)
	{
		marks[vertex] = mark;
	}
	
	public int getMark(int vertex)
	{
		return marks[vertex];
	}
}
