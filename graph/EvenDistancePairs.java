/* Given a connected acyclic graph with N nodes and N-1 edges, find out the pair of nodes that are at even distance from each other. */

import java.io.* ;
import java.util.* ;

public class EvenDistancePairs{
	private int V ;
	private LinkedList<Integer> adj[] ;
	static int oddCount = 0;
	static int evenCount = 0 ;
	
	EvenDistancePairs(int v){
		int i ;
		V = v;
		adj = new LinkedList[v] ; 
		for(i=0;i<V;i++)
			adj[i] = new LinkedList<Integer>() ;
	}

	public void addEdge(int a, int b){
		adj[a].add(b) ; 
	}

	public void dfsUtil(int i, int k, boolean[] visited){
		visited[i] = true ;
		Iterator<Integer> iter = adj[i].listIterator() ;
		while(iter.hasNext()){
			int n = iter.next() ;
			if(!visited[n]){
				if(k%2==1)
					oddCount++ ;
				else
					evenCount++ ;
				dfsUtil(n,k+1,visited) ;
			}
		}
	}

	public void dfs(){
		boolean visited[] = new boolean[V] ;
		int i;
		for(i=0;i<V;i++){
			if(!visited[i]){
				dfsUtil(i,1,visited) ; 
			}
		}
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int v = scr.nextInt() ;
			EvenDistancePairs g = new EvenDistancePairs(v) ;
			for(i=0;i<v-1;i++){
				int n1 = scr.nextInt() ;
				int n2 = scr.nextInt() ;
				g.addEdge(n1-1,n2-1) ; 
			}
			g.dfs() ;
			// System.out.println("odd " + oddCount);
			// System.out.println("even " + evenCount);
			int evenPairs = (oddCount*(oddCount-1))/2 + (evenCount*(evenCount+1))/2 ; 
			System.out.println(evenPairs) ; 
		}
	}
}