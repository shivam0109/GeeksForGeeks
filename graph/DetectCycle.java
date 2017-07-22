/* Detect Cycle in a Directed Graph */ 

/*
  Using DFS
  if element in the adjacency list is already present in the recursion stack, return true. 
  explored is used to store the recursion stack. 
  if explored[iter.next()] is true -> iter.next() has a path to s (since, iter.next() was already present in the stack) and 
  s has a path to iter.next() (present in the adjacency list).  
*/


import java.io.* ;
import java.util.* ;

public class DetectCycle{
	private static int V ;
	private static LinkedList<Integer> adj[] ; 
	
	DetectCycle(int v){
		V = v; 
		adj = new LinkedList[V] ; 
		for(int i=0; i<V; i++)
			adj[i] = new LinkedList() ;
	}

	public static void addEdge(int n1, int n2){
		adj[n1].add(n2) ; 
	}

	public static boolean findCycleUtil(int s, boolean[] visited, boolean[] explored){
		Iterator<Integer> iter = adj[s].listIterator() ;
		boolean flag ;
		visited[s] = true ;
		explored[s] = true ;  
		while(iter.hasNext()){
			int n = iter.next() ;
			if(explored[n])
				return true ; 
			if(!visited[n] && findCycleUtil(n,visited,explored))
				return true ; 
		}
		explored[s] = false ; 
		return false ; 
	}

	public static boolean findCycle(){
		boolean visited[] = new boolean[V] ;
		boolean explored[] = new boolean[V] ;
		int i;
		boolean flag = false ; 
		for(i=0;i<V;i++){
			if(!visited[i]){
				flag = findCycleUtil(i,visited,explored) ; 
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
		for(k=0;k<ntest;k++){
			int v = scr.nextInt() ;
			int e = scr.nextInt() ;
			DetectCycle g = new DetectCycle(v) ; 
			for(i=0;i<e;i++){
				int n1 = scr.nextInt() ;
				int n2 = scr.nextInt() ;
				g.addEdge(n1,n2) ; 
			}
			boolean ans = g.findCycle() ;
			System.out.println(ans) ; 
		}		
	}
}