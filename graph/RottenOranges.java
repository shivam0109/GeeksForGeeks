/* 
Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges 
So we have to determine what is the minimum time required so that all the oranges become rotten. 
A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
If it is impossible to rot every orange then simply return -1.
*/

import java.io.* ;
import java.util.* ;

public class RottenOranges{
	static class Element{
		int x,y ;
		Element(int i, int j){
			x = i ;
			y = j ; 
		}
	}

	public static boolean isValid(int i, int j, int m, int n){
		return (i>=0 && j>=0 && i<m && j<n) ;
	}

	public static boolean isDelimiter(Element el){
		return (el.x==-1 && el.y==-1) ; 
	}

	public static boolean isFreshRemaining(int mat[][], int m, int n){
		for(int i=0;i<m;i++){
			for(int j=0; j<n; j++){
				if(mat[i][j]==1)
					return true;
			}
		}
		return false ; 
	}

	public static int timeToRot(int mat[][], int m, int n){
		LinkedList<Element> q = new LinkedList<Element>() ;
		int i,j;
		Element temp ;
		int ans = 0 ;
		
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				if(mat[i][j]==2){
					temp = new Element(i,j) ;
					System.out.printf("%d %d\n",i,j) ; 
					q.add(temp) ; 
				}
			}
		}
	 
		temp = new Element(-1,-1) ; 
		q.add(temp) ; 

		while(!q.isEmpty()){
			boolean flag = false ;
			while(!isDelimiter(q.peek())){
				temp = q.peek() ; 
				System.out.println("Temp.data : " + temp.x + " " + temp.y) ;
				if(isValid(temp.x+1,temp.y,m,n) && mat[temp.x+1][temp.y]==1){
					if(!flag){
						ans++ ;
						flag = true ;
					} 
					mat[temp.x+1][temp.y] = 2 ;
					Element temp2 = new Element(temp.x+1,temp.y) ;
					q.add(temp2) ; 
				}

				if(isValid(temp.x-1,temp.y,m,n) && mat[temp.x-1][temp.y]==1){
					if(!flag){
						ans++ ;
						flag = true ;
					} 
					mat[temp.x-1][temp.y] = 2 ;
					Element temp2 = new Element(temp.x-1,temp.y) ;
					q.add(temp2) ; 
				}

				if(isValid(temp.x,temp.y+1,m,n) && mat[temp.x][temp.y+1]==1){
					if(!flag){
						ans++ ;
						flag = true ;
					} 
					mat[temp.x][temp.y+1] = 2 ;
					Element temp2 = new Element(temp.x,temp.y+1) ;
					q.add(temp2) ; 
				}

				if(isValid(temp.x,temp.y-1,m,n) && mat[temp.x][temp.y-1]==1){
					if(!flag){
						ans++ ;
						flag = true ;
					} 
					mat[temp.x][temp.y-1] = 2 ;
					Element temp2 = new Element(temp.x,temp.y-1) ;
					q.add(temp2) ; 
				}
				//Remove the rotten orange 
				q.poll() ;
			}
			//Remove the delimiter. 
			q.poll() ;

			//If q is not empty, add delimiter 
			if(!q.isEmpty()){
				Element temp3 = new Element(-1,-1) ;
				q.add(temp3) ;
			}
		}
		for(i=0;i<m;i++){
			for(j=0;j<n;j++)
				System.out.printf("%d ", mat[i][j]) ;
			System.out.printf("\n") ;
		}
		boolean freshRem = isFreshRemaining(mat,m,n) ; 
		System.out.println(freshRem) ; 
		if(freshRem)
			return -1 ;
		return ans ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt() ;
		int i,j,k; 
		for(k=0;k<ntest;k++){
			int m = scr.nextInt() ;
			int n = scr.nextInt() ;
			int mat[][] = new int[m][n] ;
			for(i=0;i<m;i++){
				for(j=0;j<n;j++)
					mat[i][j] = scr.nextInt() ;
			}
			int ans = timeToRot(mat,m,n) ; 
			System.out.println(ans) ; 
		}
	}
}