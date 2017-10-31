/*
Given a string, find count of distinct subsequences of it.
*/

import java.io.* ;
import java.util.* ;

public class CountDistinctSub{
	public int countStr(String str){
		int n = str.length() ;
		int arr[] = new int[256] ;
		Arrays.fill(arr,-1) ; 
		int dp[] = new int[n+1] ;
		dp[0] = 1 ;
		int count = 0 ;
		int rep = 0 ;
		for(int i=1; i<n+1; i++){
			char c = str.charAt(i-1) ; 
			if(arr[c]==-1)
				rep = 0 ;
			else
				rep = dp[arr[c]] ; 
			arr[c] = i-1 ;
			dp[i] = 2*dp[i-1]-rep ; 
		}
		return dp[n] ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		scr.nextLine() ;
		while(ntest-->0){
			String str = scr.nextLine() ;
			CountDistinctSub cs = new CountDistinctSub() ;
			System.out.println(cs.countStr(str)); 
		}
	}
}