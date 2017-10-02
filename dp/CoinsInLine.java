/*
There are N coins (Assume N is even) in a line. 
Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.
*/

import java.io.* ;
import java.util.* ;

public class CoinsInLine{
	public int maxProfit(int arr[]){
		int n = arr.length ;
		if(n==0)
			return 0 ;
		int i,j ;
		int dp1[][] = new int[n][n] ; 
		int dp2[][] = new int[n][n] ; 
		for(i=0;i<n;i++){
			dp1[i][i] = arr[i] ;
			dp2[i][i] = 0 ;
		}
		int k = 0 ;
		for(i=1;i<n;i++){
			for(j=0;j<n-i;j++){
				k=i+j ; 
				//dp[j][k]
				if(arr[j]+dp2[j+1][k] > arr[k]+dp2[j][k-1]){
					dp1[j][k] = arr[j] +dp2[j+1][k] ;
					dp2[j][k] = dp1[j+1][k] ; 
				}
				else{
					dp1[j][k] = arr[k]+dp2[j][k-1] ;
					dp2[j][k] = dp1[j][k-1] ; 
				} 
			}
		}
		return dp1[0][n-1] ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ; 
		while(ntest-->0){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			int i ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			CoinsInLine cil = new CoinsInLine() ;
			System.out.println(cil.maxProfit(arr)) ; 
		}
	}
}