/*
O(n2) space solution to integer break. 
*/ 

import java.io.* ;
import java.util.* ;

public class IntegerBreak2{
	public int integerBreak(int n){
		int dp[][] = new int[n-1][n+1] ;
		int i,j ;
		for(i=0;i<n-1;i++)
			dp[i][0] = 0 ;
		for(j=1;j<n+1;j++)
			dp[0][j] = 1 ;
		for(i=1;i<n-1;i++){
			for(j=1;j<n+1;j++){
				if(j<i+1)
					dp[i][j] = dp[i-1][j] ;
				else
					dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-(i+1)]*(i+1),Math.max(dp[i-1][j-(i+1)],(j-(i+1))*(i+1)))) ; 
			}
		}
		return dp[n-2][n] ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int n = scr.nextInt() ;
			IntegerBreak2 intBreak = new IntegerBreak2() ;
			System.out.println(intBreak.integerBreak(n)) ; 
		}
	}
}