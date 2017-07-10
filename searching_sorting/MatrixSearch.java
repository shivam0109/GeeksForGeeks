//Given an n x m matrix, where every row and column is sorted in increasing order, and a number x . 
//The task is to find whether element x is present in the matrix or not.

//Expected Time Complexity : O(m + n)

import java.io.* ;
import java.util.* ;

public class MatrixSearch{
	static int searchMatrix(int mat[][], int m, int n, int x){
		int i=0; 
		int j=n-1;
		int flag = 0;
		while(i<m && j>=0){
			if(mat[i][j]==x){
				flag = 1;
				break ;
			}
			else if(x>mat[i][j])
				i++ ;
			else
				j-- ;
		}
		return flag ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt() ;
		int i,k,j ;
		for(k=0;k<ntest;k++){
			int m = scr.nextInt() ;
			int n = scr.nextInt() ;
			int mat[][] = new int[m][n] ;
			for(i=0;i<m;i++){
				for(j=0;j<n;j++)
					mat[i][j] = scr.nextInt() ;
			}
			int x = scr.nextInt() ;
			int ans = searchMatrix(mat,m,n,x) ;
			System.out.println(ans) ;
		}
	}
}