/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n
*/

import java.io.* ;
import java.util.* ;

public class UniqueNumbers{
	public int countNumbersWithUniqueDigits(int n) {
        ArrayList<Integer> alist = new ArrayList<Integer>() ;
        alist.add(0) ;
        alist.add(10) ;
       	alist.add(81) ;
       	int count = 2;
       	int i = 8 ;
       	while(count<=10 || count<=n){
       		count++ ;
       		alist.add(alist.get(count-1)*i) ;
       		i-- ;
       	}
       	int sum = 0;
       	for(i=1;i<=n;i++)
       		sum += alist.get(i) ;
       	return sum ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	int i,j;
    	for(j=0;j<ntest;j++){
    		int n = scr.nextInt() ;
    		UniqueNumbers un = new UniqueNumbers() ;
    		int ans = un.countNumbersWithUniqueDigits(n) ; 
    		System.out.println(ans) ; 
    	}
    }
}