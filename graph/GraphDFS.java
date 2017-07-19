//DFS for a graph 

import java.util.* ;
import java.io.* ;

public class GraphDFS{
	private int V;
	private LinkedList<Integer> adj[] ;

	GraphDFS(int v){
		V = v;
		adj = new LinkedList[v] ;
		int i;
		for(i=0;i<v;i++)
			adj[i] = new LinkedList() ;
	}

	public void addEdge(int v, int w){
		adj[v].add(w) ;
	}

	public void dfsUtil(int s, boolean visited[]){		
		visited[s] = true ; 
		System.out.printf("%d ", s) ; 
		Iterator<Integer> i = adj[s].listIterator() ;
		while(i.hasNext()){
			int n = i.next() ;
			if(!visited[n]){
				dfsUtil(n,visited) ; 
			}
		}
	}

	public void dfs(int s){
		boolean visited[] = new boolean[V] ;
		dfsUtil(s,visited) ;
	}

	public static void main(String[] args){
		GraphDFS g = new GraphDFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(2) ; 
        System.out.printf("\n") ;
	}
}