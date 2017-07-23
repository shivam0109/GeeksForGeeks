/* Detect cycle in an undirected graph using union find */ 
/* Basic Union Find. Try to make disjoint sets. While performing union of two nodes, if both of them have 
   same representative => adding this edge will create a cycle because there already exists a path from 
   one node to another. */

import java.io.* ;
import java.util.* ;

public class DetectCycleUnionFind{
	private Map<Long,Node> map = new HashMap<Long,Node>() ; 

	class Node{
		long data;
		Node parent ; 
		int rank ; 
	}

	public void makeSet(long d){
		Node node = new Node() ; 
		node.data = d ;
		node.rank = 0;
		node.parent = node ;
		map.put(d,node) ; 
	}

	public boolean union(long data1, long data2){
		Node parent1 = findSet(map.get(data1)) ;
		Node parent2 = findSet(map.get(data2)) ;
		
		if(parent1 == parent2)
			return false ;

		if(parent1.rank>=parent2.rank){
			if(parent1.rank == parent2.rank){
				parent1.rank++ ;
			}
			parent2.parent = parent1 ; 
		}
		else
			parent1.parent = parent2 ; 
		return true ;  
	}

	public Node findSet(Node node){
		Node temp = node.parent ;
		if(temp==node)
			return node ;
		node.parent = findSet(node.parent) ; 
		return node.parent ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		DetectCycleUnionFind g = new DetectCycleUnionFind() ;
		int ntest = scr.nextInt() ; 
		long i,j ;
		for(j=0;j<ntest;j++){
			int v = scr.nextInt() ;
			int e = scr.nextInt() ;
			for(i=0;i<v;i++)
				g.makeSet(i) ; 
			boolean flag = true ;
			boolean flag2 = true ; 
			for(i=0;i<e;i++){
				long n1 = scr.nextLong() ;
				long n2 = scr.nextLong() ;
				flag = g.union(n1,n2) ;
				if(!flag)
					flag2 = false ;  
			}
			if(flag2)
				System.out.println("No Cycle Found") ; 
			else
				System.out.println("Cycle Found") ; 		
		}
	}
}