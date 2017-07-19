//BFS for disconnected graph 

import java.io.* ;
import java.util.* ;

public class GraphModifiedBFS{
	private int V;
	private LinkedList<Integer> adj[] ;

	GraphModifiedBFS(int v){
		V = v;
		adj = new LinkedList[V] ;
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList() ;
	}

	public void addEdge(int v, int w){
		adj[v].add(w) ; 
	}

	public void bfsUtil(int s, boolean visited[]){
		LinkedList<Integer> q = new LinkedList<Integer>() ;
		visited[s] = true ;
		q.add(s) ; 
		while(!q.isEmpty()){
			int k = q.poll() ;
			System.out.printf("%d ", k) ; 
			Iterator<Integer> i = adj[k].listIterator() ;
			while(i.hasNext()){
				int n = i.next() ;
				if(!visited[n]){
					visited[n] = true ;
					q.add(n) ; 
				}
			}
		}
	}

	public void bfs(int s){
		boolean visited[] = new boolean[V] ;
		bfsUtil(s,visited) ; 
		for(int i=0;i<V;i++){
			while(!visited[i])
				bfsUtil(i,visited) ; 
		}
	}

	public static void main(String[] args){
		GraphModifiedBFS g = new GraphModifiedBFS(5) ; 
		g.addEdge(0,4) ;
		g.addEdge(1,2) ;
		g.addEdge(1,3) ; 
		g.addEdge(1,4) ;
		g.addEdge(2,3) ;
		g.addEdge(3,4) ; 

		g.bfs(0) ; 
		System.out.printf("\n") ;  
	}
}