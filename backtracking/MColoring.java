/*
Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two 
adjacent vertices of the graph are colored with same color. Here coloring of a graph means assignment of colors to all vertices.
*/ 

import java.io.* ;
import java.util.* ;

public class MColoring{
	public boolean isSafe(int vertex, int color, ArrayList<Integer> list, int graph[][]){
		for(int j=0 ; j<graph[0].length ; j++){	
			if(graph[vertex][j] == 1 && list.get(j)==color)
				return false ;
		}
		return true ; 
	}
	public void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int m, int graph[][], int color[], int vertex){
		if(!list.contains(-1)){
			res.add(new ArrayList<Integer>(list)) ;
			return ;
		}
		for(int i=0; i<m ;i++){
			if(isSafe(vertex,i,list,graph)){
				list.set(vertex,i) ;
				//visited[vertex] = true ;
				backtrack(res,list,m,graph,color,vertex+1) ;
				//visited[vertex] = false ;
				list.set(vertex,-1) ;
			}
		}
	}
	public static void main(String[] args){
		int graph[][] = {{0, 1, 1, 1},{1, 0, 1, 0},{1, 1, 0, 1},{1, 0, 1, 0}};
		int m = 3 ;
		boolean visited[] = new boolean[graph.length] ; 
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>() ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		for(int i=0;i<graph.length ;i++)
			list.add(-1) ;
		int color[] = new int[graph.length] ;
		for(int i=0 ; i<m ;i++)
			color[i] = i ; 
		list.set(0,0) ; 
		MColoring mcolor = new MColoring() ;
		mcolor.backtrack(res,list,m,graph,color,0) ;	
		System.out.println(res) ; 
	}
}