/*
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
*/

/*
Assuming dp[i] stores the answer upto i. 
Now dp[i] could be made by max(dp[j]*dp[i-j]) over j<i. But, we have to modify the formula because new entries would be ignored. 
Eg: n=3. dp[2] = 1 and dp[1] = 1. But 3 could have been made by adding 2 and 1. So to incorporate this, 
formula = max(dp[j],j) * max(dp[i-j],i-j). 
*/

import java.io.* ;
import java.util.* ;

public class IntegerBreak{
	public int integerBreak(int n){
		int dp[] = new int[n+1] ;
		int i,j;
		if(n==2)
			return 1 ;
		if(n==3)
			return 2 ;
		for(i=0;i<n+1;i++)
			dp[i] = i ;
		for(i=1;i<n+1;i++){
			for(j=0;j<i;j++)
				dp[i] = Math.max(dp[i],Math.max(dp[j],j)*Math.max(dp[i-j],i-j)) ; 
		}
		return dp[n] ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int n = scr.nextInt() ;
			IntegerBreak intBreak = new IntegerBreak() ;
			System.out.println(intBreak.integerBreak(n)) ; 
		}
	}
}
