/*
Implement pow(x, n) % d.

In other words, given x, n and d,

find (x^n % d)
*/ 

/* 
Main Objeective is to handle the overflow while calculating pow(x,n) 
Use the fact that x^n mod d = (x mod d)^n mod d 
*/ 

import java.io.* ;
import java.util.* ;

public class XPowNModD{
	public int pow(int x, int n, int d){
		/*return 0 or 1 if n==0. */
		if(n==0){
			if(x==0)
				return 0 ;
			else
				return 1 ;
		}
		/* Case When n is Even. */
		/*If we know x mod d = r, x^2 mod d = r^2 mod d -> x^2 mod d = (x mod d)^2 mod d */
		else if(n%2==0){
			long y  = pow(x,n/2,d) ;      
			long ret = (long)(y*y)%(long)(d) ; 
			return (int)(ret) ;  
		}
		/*Case when n is odd. */
		/*x^n mod d = ((x mod d)^n) mod d -> ((x mod d)* (x mod d)^(n-1)) mod d = ((x mod d) * (x mod d)^(n-1) mod d) mod d = ((x mod d) * x^(n-1) mod d) mod d  */
		else{
			int z = x%d ;
			if(z<0)
				z = z + d ; 
			long b = pow(x,n-1,d) ;
			long bc = (long)(z * b)%(long)(d) ;  
			return (int)(bc) ; 
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int x = scr.nextInt() ;
			int n = scr.nextInt() ;
			int d = scr.nextInt() ;
			XPowNModD power = new XPowNModD() ;
			System.out.println(power.pow(x,n,d)) ; 
		}
	}
}
