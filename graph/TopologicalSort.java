/* DFS Based Topological Sort */ 

import java.io.* ;
import java.util.* ;

public class TopologicalSort{
	private int V;
	private LinkedList<Integer> adj[] ;

	TopologicalSort(int v){
		V = v;
		adj = new LinkedList[v] ;
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList() ;
	}

	public void addEdge(int a, int b){
		adj[a].add(b) ;
	}

	public void dfsUtil(int v, boolean[] visited, Stack<Integer> s){
		Iterator<Integer> iter = adj[v].listIterator() ;
		visited[v] = true ; 
		while(iter.hasNext()){
			int n = iter.next() ;
			if(!visited[n])
				dfsUtil(n,visited,s) ; 
		}
		s.push(v) ; 
	}

	public void dfs(){
		boolean[] visited = new boolean[V] ;
		Stack<Integer> s = new Stack<Integer>() ;
		for(int i=0; i<V; i++){
			if(!visited[i])
				dfsUtil(i,visited,s) ; 
		}
		while(!s.empty())
			System.out.printf("%d ",s.pop()) ; 
		System.out.printf("\n") ; 
	}

	public static void main(String args[]){
        // Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6); 
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.dfs();
    }

}