/*
Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications. 
There are many options to multiply a chain of matrices because matrix multiplication is associative.
*/

import java.io.* ;
import java.util.* ;

public class MatrixChainMul{
	public void printMat(int mat[][], int m, int n){
		for(int i=0; i<m ;i++){
			for(int j=0; j<n ;j++)
				System.out.printf("%d ",mat[i][j]) ;
			System.out.printf("\n") ; 
		}
		//System.out.printf("\n") ;
	}
	public int findCost(int arr[], int n){
		int m = n-1 ;
		int dp[][] = new int[m][m] ;
		int i,j,k,l ; 
		for(l=0;l<m;l++)
			dp[l][l] = 0 ; 
		for(l=1;l<m;l++){
			for(i=0;i<m-l;i++){
				j = l+i ;
				int min = Integer.MAX_VALUE ;
				for(k=i;k<j;k++){
					int val = dp[i][k] + dp[k+1][j] + arr[i]*arr[k+1]*arr[j+1] ;
					min = Math.min(min,val) ;
				}
				dp[i][j] = min ;  
			}
		}
		printMat(dp,m,m) ; 
		return dp[0][m-1] ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(int i=0; i<n ;i++)
				arr[i] = scr.nextInt() ;
			MatrixChainMul matMul = new MatrixChainMul() ;
			int ans = matMul.findCost(arr,n) ;
			System.out.println(ans) ; 
		}
	}
}