/*
Given N * M string array of O's and X's
Return the number of 'X' total shapes. 'X' shape consists of one or more adjacent X's (diagonals not included).
*/

/*
Use BFS 
1. Treat it as a disconnected graph and apply bfs.
2. So the number of times the loop in bfs will run will be the answer. 
*/

import java.io.* ;
import java.util.* ;
import java.lang.* ;

public class XShapes{
	static class Element{
		int x,y ;
		Element(int a, int b){
			x = a;
			y = b;
		}
	}

	static boolean isValid(int i, int j, int m, int n){
		return (i>=0 && j>=0 && i<m && j<n) ; 
	}

	static void findXUtil(char mat[][], int i, int j, int m, int n, boolean[][] visited){
		visited[i][j] = true ; 
		LinkedList<Element> q = new LinkedList<Element>() ;
		Element temp,temp2 ;
		temp = new Element(i,j) ;
		q.add(temp) ;  
		while(!q.isEmpty()){
			temp = q.poll() ;
			if(isValid(temp.x+1,temp.y,m,n) && mat[temp.x+1][temp.y]=='X' && !visited[temp.x+1][temp.y]){
				temp2 = new Element(temp.x+1,temp.y) ;
				q.add(temp2) ;
				visited[temp.x+1][temp.y] = true ;  
			}
			if(isValid(temp.x-1,temp.y,m,n) && mat[temp.x-1][temp.y]=='X' && !visited[temp.x-1][temp.y]){
				temp2 = new Element(temp.x-1,temp.y) ;
				q.add(temp2) ;
				visited[temp.x-1][temp.y] = true ;  
			}
			if(isValid(temp.x,temp.y+1,m,n) && mat[temp.x][temp.y+1]=='X' && !visited[temp.x][temp.y+1]){
				temp2 = new Element(temp.x,temp.y+1) ;
				q.add(temp2) ;
				visited[temp.x][temp.y+1] = true ;  
			}
			if(isValid(temp.x,temp.y-1,m,n) && mat[temp.x][temp.y-1]=='X' && !visited[temp.x][temp.y-1]){
				temp2 = new Element(temp.x,temp.y-1) ;
				q.add(temp2) ;
				visited[temp.x][temp.y-1] = true ;  
			}
		}
	}

	static int findX(char mat[][], int m, int n){
		boolean visited[][] = new boolean[m][n] ;
		int ans = 0;
		int i,j ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				if(mat[i][j]=='X' && !visited[i][j]){
					//printMatrix(visited,m,n) ; 
					findXUtil(mat,i,j,m,n,visited) ;
					ans++ ;
				}
			}
		}
		return ans ; 
	}

	public static void printMatrix(boolean mat[][], int m, int n){
		int i,j ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++)
				System.out.print(mat[i][j] + " ") ; 
			System.out.printf("\n") ; 
		}
		System.out.printf("\n") ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt();
		int i,j,k ;
		for(k=0;k<ntest;k++){
			int m = scr.nextInt() ;
			int n = scr.nextInt() ;
			char mat[][] = new char[m][n] ; 
			for(i=0;i<m;i++){
				String str = scr.next(); 
				for(j=0;j<n;j++)
					mat[i][j] = str.charAt(j) ; 
			}
			int ans = findX(mat,m,n) ;
			System.out.println(ans) ;  
		}
	}
}