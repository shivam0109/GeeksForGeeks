/* Detect Cycle in an undirected graph. */ 

/* 
Use DFS. 
Almost same as detecting cycle in a directed graph. 
Difference is that we need to maintain the previous ancestor and not go in that direction. 
 */

import java.io.* ;
import java.util.* ;

public class DetectCycleUndirected{
	private int V;
	private LinkedList<Integer> adj[] ;

	DetectCycleUndirected(int v){
		V = v;
		adj = new LinkedList[V] ;
		for(int i=0;i<V;i++)
			adj[i] = new LinkedList() ;
	}

	public void addEdge(int v, int w){
		adj[v].add(w) ; 
	}

	public boolean detectCycleUtil(int s1, boolean[] visited, boolean explored[], int s2){
		visited[s1] = true ;
		explored[s1] = true ;
		Iterator<Integer> iter = adj[s1].listIterator() ; 
		while(iter.hasNext()){
			int n = iter.next() ;
			if(n!=s2 && explored[n])
				return true ;
			if(!visited[n] && detectCycleUtil(n,visited,explored,s1)) 
				return true ; 
		}
		explored[s1] = false ; 
		return false ;  
	}

	public boolean detectCycle(){
		boolean visited[] = new boolean[V] ;
		boolean explored[] = new boolean[V] ;
		int i;
		boolean flag = false ; 
		for(i=0;i<V;i++){
			if(!visited[i]){
				flag = detectCycleUtil(i, visited, explored, i);
				if(flag)
					break ;
			}
		}
		return flag ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt() ; 
		int i,j,k ;
		for(i=0;i<ntest;i++){
			int v = scr.nextInt() ;
			int e = scr.nextInt() ;
			DetectCycleUndirected g = new DetectCycleUndirected(v) ; 
			for(i=0;i<e;i++){
				int n1 = scr.nextInt() ;
				int n2 = scr.nextInt() ;
				g.addEdge(n1,n2) ; 
			}
			boolean ans = g.detectCycle() ;
			System.out.println(ans) ;
		}
	}
}