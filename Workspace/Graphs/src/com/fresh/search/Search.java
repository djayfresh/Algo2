package com.fresh.search;

import java.util.ArrayList;
import java.util.Stack;

import com.fresh.graph.ListGraph;

public class Search
{
	public static int[] depthFirst(ListGraph g)
	{
		Stack<Integer> path = new Stack<Integer>();
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for(int i = 0; i < g.vCount(); i++)
		{
			path.push(i);
			dFVert(i, g, path);
		}
		return null;
	}
	private static int[] dFVert(int index, ListGraph g, Stack<Integer> stack)
	{
		if(g.getMark(stack.peek()) == ListGraph.VISITED)
		{
			//stack.pop()
			//add to list
		}
		else
		{
			int thisVert = stack.peek();
			stack.push(g.first(thisVert));
			g.setMark(thisVert, ListGraph.VISITED);
		}
		
		return null;
	}
	public static int[] breathFirst(ListGraph g)
	{
		
		return null;
	}
}
