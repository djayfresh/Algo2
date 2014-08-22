package com.fresh.graph;

import java.util.List;

public abstract class Graph<T extends Vertex<E>, E extends Comparable<E>>
{
	public abstract boolean add(T p1, T p2);
	public abstract boolean remove(T p1, T p2);
	public abstract List<T> retreive(T p1);
	public abstract int mark(T p1);
	public abstract T first(T p1);
	public abstract T next(T p2, T p1);
}
