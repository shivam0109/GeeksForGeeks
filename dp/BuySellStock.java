/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/ 

import java.io.* ;
import java.util.* ;

public class BuySellStock{
	public int maxProfit(int[] prices) {
        int n = prices.length ;
        if(n==0 || n==1)
            return 0 ;
        int end = 1 ;
        int profit = 0 ;
        while(end<n){
            if(prices[end]>prices[end-1])
                profit += prices[end]-prices[end-1] ;
            end++ ;
        }
        return profit ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ; 
    	int ntest = scr.nextInt() ;
    	while(ntest-->0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		int i;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		BuySellStock bs = new BuySellStock() ;
    		System.out.println(bs.maxProfit(arr)) ; 
    	}
    }
}