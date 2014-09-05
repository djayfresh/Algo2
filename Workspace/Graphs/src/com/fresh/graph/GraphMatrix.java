package com.fresh.graph;

public class GraphMatrix implements Graph
{
	private int[][] matrix; // The edge matrix
	private int numEdge; // Number of edges
	private int[] mark; // The mark array

	public GraphMatrix()
	{

	}

	public GraphMatrix(int n)
	{
		Init(n);
	}

	public void Init(int n)
	{
		mark = new int[n];
		matrix = new int[n][n];
		numEdge = 0;
	}

	public int n()
	{
		return mark.length;
	}

	public int e()
	{
		return numEdge;
	}

	/** @return v’s first neighbor */
	public int first(int v)
	{
		for (int i = 0; i < mark.length; i++)
			if (matrix[v][i] != 0)
				return i;
		return mark.length; // No edge for this vertex
	}

	/** @return v’s next neighbor after w */
	public int next(int v, int w)
	{
		for (int i = w + 1; i < mark.length; i++)
			if (matrix[v][i] != 0)
				return i;
		return mark.length; // No next edge;
	}

	/** Set the weight for an edge */
	public void setEdge(int i, int j, int wt)
	{
		assert wt != 0 : "Cannot set weight to 0";
		if (matrix[i][j] == 0)
			numEdge++;
		matrix[i][j] = wt;
	}

	/** Delete an edge */
	public void delEdge(int i, int j)
	{ // Delete edge (i, j)
		if (matrix[i][j] != 0)
			numEdge--;
		matrix[i][j] = 0;
	}

	/** Determine if an edge is in the graph */
	public boolean isEdge(int i, int j)
	{
		return matrix[i][j] != 0;
	}

	/** @return an edge’s weight */
	public int weight(int i, int j)
	{
		return matrix[i][j];
	}

	/** Set/Get the mark value for a vertex */
	public void setMark(int v, int val)
	{
		mark[v] = val;
	}

	public int getMark(int v)
	{
		return mark[v];
	}
}
