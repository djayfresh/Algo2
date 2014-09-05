package com.fresh.search;

import java.util.PriorityQueue;
import java.util.Queue;

import com.fresh.graph.Graph;

public class Search
{
	private static int UNVISITED = 0;
	private static int VISITED = 1;

	static void graphDFSTraverse(Graph G)
	{
		for (int v = 0; v < G.n(); v++)
			G.setMark(v, UNVISITED); // Initialize
		for (int v = 0; v < G.n(); v++)
			if (G.getMark(v) == UNVISITED)
				DFS(G, v);
	}

	/** Depth first search */
	static void DFS(Graph G, int v)
	{
		// PreVisit(G, v); // Take appropriate action
		G.setMark(v, VISITED);
		for (int w = G.first(v); w < G.n(); w = G.next(v, w))
			if (G.getMark(w) == UNVISITED)
				DFS(G, w);
		// PostVisit(G, v); // Take appropriate action }
	}

	static void graphBFSTraverse(Graph G)
	{
		for (int v = 0; v < G.n(); v++)
			G.setMark(v, UNVISITED); // Initialize
		for (int v = 0; v < G.n(); v++)
			if (G.getMark(v) == UNVISITED)
				BFS(G, v);
	}

	/** Breadth first (queue-based) search */
	static void BFS(Graph G, int start)
	{
		Queue<Integer> Q = new PriorityQueue<Integer>(G.n());
		Q.add(start);
		G.setMark(start, VISITED);
		while (Q.size() > 0)
		{
			int v = Q.poll();
			//PreVisit(G, v); // Take appropriate action
			for (int w = G.first(v); w < G.n(); w = G.next(v, w))
				if (G.getMark(w) == UNVISITED)
				{
					G.setMark(w, VISITED);
					Q.add(w);
				}
			//PostVisit(G, v); // Take appropriate action
		}
	}
}
