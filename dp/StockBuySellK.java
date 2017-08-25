/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/ 

import java.io.* ;
import java.util.* ;

public class StockBuySellK{
	public void printMat(int dp[][], int m, int n){
		int i,j ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++)
				System.out.printf("%d ",dp[i][j]) ; 
			System.out.printf("\n") ;
		}
	}
	public int maxProfit(int k, int[] prices) {
		int n = prices.length ;
		int dp[][] = new int[k+1][n] ;
		int i,j ;
		int maxdiff ; 
		for(i=0;i<k+1;i++)
			dp[i][0] = 0 ;
		for(j=0;j<n;j++)
			dp[0][j] = 0 ;
		for(i=1;i<k+1;i++){
			maxdiff = -prices[0] ; 
			for(j=1;j<n;j++){
				dp[i][j] = Math.max(dp[i][j-1],prices[j]+maxdiff) ; 
				maxdiff = Math.max(maxdiff, dp[i-1][j]-prices[j]) ;
			}
		}
		printMat(dp,k+1,n) ; 
		return dp[k][n-1] ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			int k = scr.nextInt() ;
			for(int i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			StockBuySellK bsk = new StockBuySellK() ;
			System.out.println(bsk.maxProfit(k,arr)) ; 
		}
	}
}