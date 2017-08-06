/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

*/

import java.io.* ;
import java.util.* ;

public class WaysToDecode{
	public boolean isPossible(String str){
        int num = Integer.valueOf(str) ;
        //System.out.println(num) ; 
        if(num>0 && num<=26)
            return true ;
        else
            return false ;
    }
    public boolean isZero(char[] arr, int n){
        boolean flag = false ;
        for(int i=0; i<n; i++){
            if(arr[i]=='0'){
                flag = true ;
                break ;
            }
        }
        return flag ;
    }
    public void printArray(int[] arr, int n){
    	int i ;
    	for(i=0;i<n;i++)
    		System.out.printf("%d ",arr[i]) ;
    	System.out.printf("\n") ;
    }
	public int numDecodings(String str) {
	    char[] arr = str.toCharArray() ;
	    int n = str.length() ;
	    if(isZero(arr,n))
	        return 0 ;
	    int i;
	    int dp[] = new int[n+1] ;
	    dp[0] = 1;
	    dp[1] = 1 ;
	    for(i=2;i<n+1;i++){
	        if(isPossible(str.substring(i-2,i))) 
            	dp[i] = dp[i-1]+dp[i-2] ;
            else
            	dp[i] = dp[i-1] ; 
	        
	    }
	    printArray(dp,n) ;
	    return dp[n] ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- >0){
			String num = scr.next() ;
			WaysToDecode wtd = new WaysToDecode() ;
			System.out.println(wtd.numDecodings(num)) ;
		}
	}
}