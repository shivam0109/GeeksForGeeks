/*
Find out the number of N digit numbers, whose digits on being added equals to a given number S. 
Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007
*/

import java.io.* ;
import java.util.* ;

public class NDigitSum{
	public int nDigitSum(int n, int sum){
		
		if(n==0)
			return 0 ;
		
		if(sum==0){
			if(n==1)
				return 1 ;
			else
				return 0 ;
		}

		if(sum>9*n)
			return 0 ;

		if(sum==9*n)
			return 1 ;

		long dp[][] = new long[n][sum] ;
		int i,j ;
		
		for(j=0;j<sum;j++){
			if(j<9)
				dp[0][j] = 1 ;
			else
				dp[0][j] = 0 ;
		}
		
		for(i=0;i<n;i++)
			dp[i][0] = 1 ;

		for(i=1;i<n;i++){
			for(j=1;j<sum;j++){
				if(j<=9)
					dp[i][j] = (dp[i-1][j]%1000000007+dp[i][j-1]%1000000007)%1000000007 ;	
				else
					dp[i][j] = ((dp[i-1][j]%1000000007+ dp[i][j-1]%1000000007)%1000000007 - dp[i-1][j-10])%1000000007 ;	
				
				if(dp[i][j]<0)
					dp[i][j] = 1000000007 + dp[i][j] ; 
			}
		}

		// for(i=0;i<n;i++){
		// 	for(j=0;j<sum;j++)
		// 		System.out.printf("%d ",dp[i][j]) ;
		// 	System.out.printf("\n") ;
		// }		
		return (int)(dp[n-1][sum-1]) ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			int n = scr.nextInt() ;
			int sum = scr.nextInt() ;
			NDigitSum nsum = new NDigitSum() ;
			System.out.println(nsum.nDigitSum(n,sum)) ; 
		}
	}
}
