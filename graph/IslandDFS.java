//Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. 

import java.io.* ;
import java.util.* ;

public class IslandDFS{
	static class Element{
		int x,y ;
		Element(int a,int b){
			x = a;
			y = b;
		}
	}
	
	static boolean isValid(int i,int j,int m,int n){
		return (i>=0 && j>=0 && i<m && j<n) ;
	}

	static void findIslandUtil(int mat[][], int i, int j, int m, int n, boolean[][] visited){
		visited[i][j] = true ;
		
		if(isValid(i-1,j-1,m,n) && mat[i-1][j-1] == 1 && !visited[i-1][j-1])
			findIslandUtil(mat,i-1,j-1,m,n,visited) ; 
		
		if(isValid(i-1,j,m,n) && mat[i-1][j] == 1 && !visited[i-1][j])
			findIslandUtil(mat,i-1,j,m,n,visited) ; 
		
		if(isValid(i-1,j+1,m,n) && mat[i-1][j+1] == 1 && !visited[i-1][j+1])
			findIslandUtil(mat,i-1,j+1,m,n,visited) ; 
		
		if(isValid(i,j-1,m,n) && mat[i][j-1] == 1 && !visited[i][j-1])
			findIslandUtil(mat,i,j-1,m,n,visited) ; 
		
		if(isValid(i,j+1,m,n) && mat[i][j+1] == 1 && !visited[i][j+1])
			findIslandUtil(mat,i,j+1,m,n,visited) ; 
		
		if(isValid(i+1,j-1,m,n) && mat[i+1][j-1] == 1 && !visited[i+1][j-1])
			findIslandUtil(mat,i+1,j-1,m,n,visited) ; 
		
		if(isValid(i+1,j,m,n) && mat[i+1][j] == 1 && !visited[i+1][j])
			findIslandUtil(mat,i+1,j,m,n,visited) ; 
		
		if(isValid(i+1,j+1,m,n) && mat[i+1][j+1] == 1 && !visited[i+1][j+1])
			findIslandUtil(mat,i+1,j+1,m,n,visited) ; 
	
	}

	static int findIsland(int mat[][], int m, int n){
		boolean visited[][] = new boolean[m][n] ;
		int ans = 0 ;
		int i,j ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				if(mat[i][j]==1 && !visited[i][j]){
					ans++ ;
					findIslandUtil(mat,i,j,m,n,visited) ; 
				}
			}
		}
		return ans ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt() ;
		int i,j,k ;
		for(k=0;k<ntest;k++){
			int m = scr.nextInt() ;
			int n = scr.nextInt() ;
			int mat[][] = new int[m][n] ;
			for(i=0;i<m;i++){
				for(j=0;j<n;j++)
					mat[i][j] = scr.nextInt() ;
			}
			int ans = findIsland(mat,m,n) ; 
			System.out.println(ans) ; 
		}
	}
}