/*
The problem is to print all the possible paths 
from top left to bottom right of a mXn matrix with the 
constraints that from each cell you can either move only to right or down.
*/

import java.io.* ;
import java.util.* ;

public class PrintAllPaths{
	public boolean isSafe(int x, int y, int mat[][], boolean visited[][]){
		return x>=0 && x<mat.length && y>=0 && y<mat[0].length && !visited[x][y] ; 
	}
	public void backtrack(int mat[][], boolean visited[][], ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res, int x, int y){
		if(x==mat.length-1 && y==mat[0].length-1){
			res.add(new ArrayList<Integer>(list)) ;
			return ;
		}
		if(isSafe(x+1,y,mat,visited)){
			list.add(mat[x+1][y]) ;
			visited[x+1][y] = true ;
			backtrack(mat,visited,list,res,x+1,y) ; 
			visited[x+1][y] = false ;
			list.remove(list.size()-1) ;
		}
		if(isSafe(x,y+1,mat,visited)){
			list.add(mat[x][y+1]) ;
			visited[x][y+1] = true ;
			backtrack(mat,visited,list,res,x,y+1) ; 
			visited[x][y+1] = false ;
			list.remove(list.size()-1) ;	
		}
	}
	public static void main(String[] args){
		int mat[][] = {{1,2,3},{4,5,6}} ;
		System.out.println(mat.length) ;
		System.out.println(mat[0].length) ; 
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>() ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		list.add(mat[0][0]) ;
		PrintAllPaths pp = new PrintAllPaths() ;
		boolean visited[][] = new boolean[mat.length][mat[0].length] ; 
		visited[0][0] = true ;
		pp.backtrack(mat,visited,list,res,0,0) ;
		System.out.println(res) ; 
	}
}