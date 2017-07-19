//DFS when all vertices might not be reachable from a vertex. 

import java.io.* ;
import java.util.* ;

public class GraphModifiedDFS{
	private int V ;
	private LinkedList<Integer> adj[] ;

	//O(V)
	GraphModifiedDFS(int v){
		V = v ;
		adj = new LinkedList[V] ;
		for(int i =0 ;i<v;i++)
			adj[i] = new LinkedList<Integer>() ;
	}

	public void addEdge(int v, int w){
		adj[v].add(w) ; 
	}

	//O(E)
	public void dfsUtil(int s, boolean visited[]){
		visited[s] = true ;
		System.out.printf("%d ",s) ; 
		Iterator<Integer> i = adj[s].listIterator() ;
		while(i.hasNext()){
			int n = i.next() ;
			if(!visited[n])
				dfsUtil(n,visited) ; 	
		}
	}

	public void dfs(int s){
		boolean visited[] = new boolean[V] ;
		dfsUtil(s,visited) ;
		for(int i=0;i<V;i++){
			if(!visited[i])
				dfsUtil(i,visited) ; 
		}
		System.out.printf("\n") ; 
	}

	public static void main(String[] args){
		GraphModifiedDFS g = new GraphModifiedDFS(4) ;

		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        //g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(1) ; 
	}
}