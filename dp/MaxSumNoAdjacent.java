/*
Find maximum sum in an array, where you cannot take adjacent numbers.
*/ 

import java.io.* ;
import java.util.* ;

public class MaxSumNoAdjacent{
	public int findSum(int arr[], int n){
		int i ;
		int dp[] = new int[n] ;
		if(n==1)
			return arr[0] ;
		else if(n==2)
			return Math.max(arr[0],arr[1]) ;
		else if(n==3)
			return Math.max(arr[0]+arr[2],arr[1]) ;
		else{
			dp[0] = arr[0] ;
			dp[1] = arr[1] ;
			dp[2] = arr[0] + arr[2] ;
			for(i=3;i<n;i++){
				dp[i] = Math.max(arr[i]+dp[i-2], arr[i]+dp[i-3]) ;
			}
		}
		return Math.max(dp[n-1],dp[n-2]) ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			MaxSumNoAdjacent mSumNoAdj = new MaxSumNoAdjacent() ;
			int ans = mSumNoAdj.findSum(arr,n) ; 
			System.out.println(ans) ;
		}
	}
}