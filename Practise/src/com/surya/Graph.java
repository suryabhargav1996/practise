package com.surya;

import java.util.*;


public class Graph {

	static void addEdge(List<List<Integer>> adjList, int src, int dest) {
		adjList.get(src).add(dest);
		adjList.get(dest).add(src);
	}
	
	static void dfs(List<List<Integer>> adjList, int src) {
		
		boolean[] visited = new boolean[adjList.size()];
		dfsRec(adjList, visited, src);
		
	}
	private static void dfsRec(List<List<Integer>> adjList, boolean[] visited, int src) {
		// TODO Auto-generated method stub
		
		visited[src] = true;
		
		System.out.print(src + " ");
		
		for(int i: adjList.get(src)) {
			if(!visited[i]) {
				dfsRec(adjList,visited, i);
			}
		}
	}
	
	
	static void bfs(List<List<Integer>> adjList, int src) {
		boolean[] visited = new boolean[adjList.size()];
		bfsHelper(adjList, visited, src);
		
	}

	private static void bfsHelper(List<List<Integer>> adjList, boolean[] visited, int src) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			
			if(!visited[curr]) {
				System.out.print(curr +  " ");
				visited[curr] = true;
				for(int i : adjList.get(curr)) {
					q.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int V = 6;
		List<List<Integer>> adjList = new ArrayList<>(V);
	
		
		for(int i=0;i<V;i++) {
			adjList.add(new ArrayList<>());
		} //created empty arrayList for each node to store adj nodes
		
		addEdge(adjList, 0,1);
		addEdge(adjList,1,2);
		addEdge(adjList,2,3); 
		addEdge(adjList,3,1);
		addEdge(adjList,0,5);
		addEdge(adjList,5,4);
		
		System.out.println("DFS: \n");
		dfs(adjList,0);
		System.out.println("");
		dfs(adjList,1);
		System.out.println("");
		dfs(adjList,2);
		
		System.out.println("BFS: \n");
		bfs(adjList,0);
		System.out.println("");
		bfs(adjList,1);
		System.out.println("");
		bfs(adjList,2);
		
		
		System.out.println("compare is " + Integer.compare(4, 4));
		
	}

}
