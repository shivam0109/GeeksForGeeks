/*
You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

*/

import java.io.* ;
import java.util.* ;

public class CoinSumOpt{
	public void copyAbove(int[][] mat, int row, int col){
		for(int j=0; j<col ;j++)
			mat[row-1][j] = mat[row][j] ; 
	}
	public void printMat(int[][] mat, int row, int col){
		int i,j ;
		for(i=0;i<row;i++){
			for(j=0;j<col;j++)
				System.out.printf("%d ",mat[i][j]) ;
			System.out.printf("\n") ; 
		}
	}
	public int waysToMakeSum(int[] arr, int sum){
		int n = arr.length ;
		if(n==0)
			return 1 ;
		int dp[][] = new int[2][sum+1] ;
		Arrays.sort(arr) ;
		int i,j ;
		for(j=0;j<sum+1;j++){
			if(j%arr[0]==0)
				dp[0][j] = 1;
		}
		dp[1][0] = 1 ;
		for(i=1;i<n;i++){
			for(j=1;j<sum+1;j++){
				if(arr[i]>j)
					dp[1][j] = dp[0][j] ; 
				else
					dp[1][j] = dp[0][j] + dp[1][j-arr[i]] ; 
			}
			copyAbove(dp,1,sum+1) ; 
		}
		printMat(dp,2,sum+1) ; 
		return dp[1][sum] ;  
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
			int sum = scr.nextInt() ;
			CoinSumOpt coin = new CoinSumOpt() ;
			System.out.println(coin.waysToMakeSum(arr,sum)) ; 
		}
	}
}