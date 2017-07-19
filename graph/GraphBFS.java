/* 	
Breadth First Traversal or BFS for a Graph.
Similar to BFS of a tree. But may contain cycles. To avoid processing a node more than once, we use a boolean visited array. 
For simplicity, it is assumed that all vertices are reachable from the starting vertex.
*/

//Time : O(V+E) 

import java.io.* ;
import java.util.* ;

public class GraphBFS{

	//number of vertices 
	private int V ;
	//array of linkedlist as an adjacency list. 
	private LinkedList<Integer> adj[] ;

	//Constructor 
	//make an empty adjacency list 
	GraphBFS(int v){
		V = v ;
		adj = new LinkedList[v] ; 
		int i;
		for(i=0;i<v;i++){
			adj[i] = new LinkedList() ;
		}
	}

	//add edges from v to w. 
	public void addEdge(int v, int w){
		adj[v].add(w) ;  
	}

	//print BFS from source s 
	public void bfs(int s){
		boolean visited[] = new boolean[V] ; 
		visited[s] = true ;

		LinkedList<Integer> q = new LinkedList<Integer>() ;
		q.add(s) ; 

		while(!q.isEmpty()){
			s = q.poll() ;
			System.out.println(s+" ");

			Iterator<Integer> i = adj[s].listIterator() ;
			while(i.hasNext()){
				int n = i.next() ;
				if(!visited[n]){
					visited[n] = true ;
					q.add(n) ; 
				}
			}
		}		
	}

	public static void main(String[] args){
		GraphBFS g = new GraphBFS(4) ;

		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(0) ; 

	}

}