/*Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. */

/* Same as BFS for disconnected graph
	The number of vertices not connected is the answer. 
*/
import java.io.* ;
import java.util.* ;

public class IslandBFS{
	static class Element{
		int x,y ;
		Element(int a, int b){
			x = a;
			y = b; 
		}
	}
	
	public static boolean isValid(int i,int j, int m, int n){
		return (i>=0 && j>=0 && i<m && j<n) ; 
	}
	
	public static void findIslandUtil(int mat[][], int i, int j, int m, int n, boolean[][] visited){
		LinkedList<Element> q = new LinkedList<Element>() ;
		Element temp, temp2 ;
		temp = new Element(i,j) ;
		q.add(temp) ; 
		while(!q.isEmpty()){
			temp = q.poll() ;
			if(isValid(temp.x+1,temp.y,m,n) && mat[temp.x+1][temp.y]==1 && !visited[temp.x+1][temp.y]){
				temp2 = new Element(temp.x+1,temp.y) ;
				q.add(temp2) ; 
				visited[temp.x+1][temp.y] = true ;
			}
			
			if(isValid(temp.x+1,temp.y+1,m,n) && mat[temp.x+1][temp.y+1]==1 && !visited[temp.x+1][temp.y+1]){
				temp2 = new Element(temp.x+1,temp.y+1) ;
				q.add(temp2) ; 
				visited[temp.x+1][temp.y+1] = true ;
			}
			
			if(isValid(temp.x+1,temp.y-1,m,n) && mat[temp.x+1][temp.y-1]==1 && !visited[temp.x+1][temp.y-1]){
				temp2 = new Element(temp.x+1,temp.y-1) ;
				q.add(temp2) ; 
				visited[temp.x+1][temp.y-1] = true ;
			}
			
			if(isValid(temp.x-1,temp.y+1,m,n) && mat[temp.x-1][temp.y+1]==1 && !visited[temp.x-1][temp.y+1]){
				temp2 = new Element(temp.x-1,temp.y+1) ;
				q.add(temp2) ; 
				visited[temp.x-1][temp.y+1] = true ;
			}
			if(isValid(temp.x-1,temp.y, m, n) && mat[temp.x-1][temp.y]==1 && !visited[temp.x-1][temp.y]){
				temp2 = new Element(temp.x-1,temp.y) ;
				q.add(temp2) ; 
				visited[temp.x-1][temp.y] = true ;
			}
			if(isValid(temp.x-1,temp.y-1, m, n) && mat[temp.x-1][temp.y-1]==1 && !visited[temp.x-1][temp.y-1]){
				temp2 = new Element(temp.x-1,temp.y-1) ;
				q.add(temp2) ; 
				visited[temp.x-1][temp.y-1] = true ;
			}
			
			if(isValid(temp.x,temp.y+1, m, n) && mat[temp.x][temp.y+1]==1 && !visited[temp.x][temp.y+1]){
				temp2 = new Element(temp.x,temp.y+1) ;
				q.add(temp2) ; 
				visited[temp.x][temp.y+1] = true ;
			}

			if(isValid(temp.x,temp.y-1, m, n) && mat[temp.x][temp.y-1]==1 && !visited[temp.x][temp.y-1]){
				temp2 = new Element(temp.x,temp.y-1) ;
				q.add(temp2) ; 
				visited[temp.x][temp.y-1] = true ;
			}
		}
	}

	public static int findIsland(int mat[][], int m, int n){
		boolean visited[][] = new boolean[m][n] ;
		int i,j ;
		int ans = 0 ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				if(!visited[i][j] && mat[i][j]==1){
					ans++ ;
					findIslandUtil(mat,i,j,m,n,visited) ; 
				}
			}
		}
		return ans ; 
	}
	
	// public static void main(String[] args){
	// 	Scanner scr = new Scanner(System.in) ;
	// 	int ntest = scr.nextInt() ;
	// 	int i,j,k;
	// 	for(k=0;k<ntest;k++){
	// 		int m = scr.nextInt() ;
	// 		int n = scr.nextInt() ;
	// 		int mat[][] = new int[m][n] ; 
	// 		for(i=0;i<m;i++){
	// 			for(j=0;j<n;j++)
	// 				mat[i][j] = scr.nextInt() ;
	// 		}
	// 	}		
	// 	int ans = findIsland(mat,m,n) ; 
	// 	System.out.println(ans) ;
	// }

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt();
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