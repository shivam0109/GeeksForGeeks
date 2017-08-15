/*
Given a fence with n posts and k colors, find out the number of ways of painting the fence such that 
at most 2 adjacent posts have the same color. 
Since answer can be large return it modulo 10^9 + 7.
*/ 

import java.io.* ;
import java.util.* ;

public class PaintFence{
	public int waysToPaint(int n, int k){
        long dp[] = new long[n] ;
        int i;
        if(k==1){
            if(n>2)
                return 0 ;
            else
                return 1 ; 
        }
        if(n<=2){
            if(n==1)
                return k ;
            if(n==2)
                return k*k ;
        }
        long mod = (long)(Math.pow(10,9)+7) ;
        dp[0] = (long)(k%mod);
        dp[1] = (long)(k*k % mod);
        dp[2] = (long)((k*k*k - k)%mod) ;
        long mul = (long)(((k-1)*(k-1)*(k+2))%mod) ; 
        for(i=3;i<n;i++){
            dp[i] = (dp[i-3]*mul)%mod ;
        }
        return (int)(dp[n-1]) ;
    }
	public static void main (String[] args) {
		//code
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
		    int n = scr.nextInt() ;
		    int k = scr.nextInt() ;
		    PaintFence g = new PaintFence() ;
		    System.out.println(g.waysToPaint(n,k)) ;
		}
	}
}