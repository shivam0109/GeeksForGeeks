/*
Implement pow(x,n) ;
*/

import java.io.* ;
import java.util.* ;

public class Power{
	public double myPow(double x, int n) {
		System.out.println(x + " " + n) ;
       	if(n==0){
           if(x==0)
               return 0;
           else
               return 1;
        }
        if(n<0){
        	if(n!= -2147483648)
            	return myPow(1/x,-n) ;
            else{
            	return (1/x)*myPow(1/x,-n-1) ;  
            }
        }
        if(n%2==0){
            double y = myPow(x,n/2) ;
            return y*y ;
        }
        else{
            return x*myPow(x,n-1) ;
        }
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		double x = scr.nextDouble() ;
    		int n = scr.nextInt() ;
    		Power xpown = new Power() ;
    		System.out.println(xpown.myPow(x,n)) ; 
    	}
    }
}