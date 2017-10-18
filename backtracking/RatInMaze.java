/*
A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. 
The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination. 
*/

import java.io.* ;
import java.util.* ;

public class RatInMaze{
	public boolean isSafe(int x, int y, int n, int mat[][], boolean[][] visited){
		return x>=0 && x<n && y>=0 && y<n && mat[x][y] == 1 && !visited[x][y]; 
	}
	public void backtrack(int mat[][], int n, int x, int y, ArrayList<String> list, String str, boolean visited[][]){
		System.out.println(str) ; 
		if(x==n-1 && y==n-1){
			list.add(str) ;
			return ; 
		}
		//GO UP 
		if(isSafe(x+1,y,n,mat,visited)){
			str = str.concat("D") ;
			visited[x+1][y] = true ;  
			backtrack(mat,n,x+1,y,list,str,visited) ; 
			str = str.substring(0,str.length()-1) ;
			visited[x+1][y] = false ;
		}
		//GO DOWN
		if(isSafe(x-1,y,n,mat,visited)){
			str = str.concat("U") ;
			visited[x-1][y] = true ;  
			backtrack(mat,n,x-1,y,list,str,visited) ; 
			str = str.substring(0,str.length()-1) ;
			visited[x-1][y] = false ;
		}
		//GO RIGHT
		if(isSafe(x,y+1,n,mat,visited)){
			str = str.concat("R") ;
			visited[x][y+1] = true ; 
			backtrack(mat,n,x,y+1,list,str,visited) ; 
			str = str.substring(0,str.length()-1) ;
			visited[x][y+1] = false ;
		}
		//GO LEFT
		if(isSafe(x,y-1,n,mat,visited)){
			str = str.concat("L") ;
			visited[x][y-1] = true ; 
			backtrack(mat,n,x,y-1,list,str,visited) ; 
			str = str.substring(0,str.length()-1) ;
			visited[x][y-1] = false ;
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			int n = scr.nextInt() ;
			int mat[][] = new int[n][n] ;
			int i,j ;
			for(i=0;i<n;i++){
				for(j=0;j<n;j++)
					mat[i][j] = scr.nextInt() ;
			}
			RatInMaze rmaze =  new RatInMaze() ;
			ArrayList<String> list = new ArrayList<String>() ;
			boolean visited[][] = new boolean[n][n] ;
			visited[0][0] = true ; 
			if(mat[0][0]==0)
				System.out.println("Not Possible") ;
			else{
				rmaze.backtrack(mat,n,0,0,list,"",visited) ;
				Collections.sort(list) ;
				System.out.println(list) ; 	
			}
		}	
	}
}