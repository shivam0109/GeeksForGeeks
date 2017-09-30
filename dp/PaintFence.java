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
        if(k==1){
        	if(n>2)
        		return 0 ;
        	else
        		return 1 ; 
        }
        if(n<=2){
        	if(n==1)
        		return k;
        	if(n==2)
        		return k*k ;
        }
        long m = (long)(Math.pow(10,9)+7) ; 
        dp[0] = (long)(k%m);
        dp[1] = (long)((long)((k*k)%m)) ;
        int i;
        for(i=2;i<n;i++){
        	long a = (long)(dp[i-2]%m) ; 
        	long b = (long)(dp[i-1]%m) ;
        	long c = (long)((a+b)%m) ;
        	long d = (long)((k-1)%m) ;
        	dp[i] = (long)((c*d)%m) ;
        }
        //dp[i] = (dp[i-2]+
        .dp[i-1])*(k-1) ; 
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