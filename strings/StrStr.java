/*
strstr - locate a substring ( needle ) in a string ( haystack ). 
*/

import java.io.* ;
import java.util.* ;

public class StrStr{
	public int locateSubstring(String haystack, String needle){
		haystack = haystack.trim() ;
		needle = needle.trim() ;
		int m = haystack.length() ;
		int n = needle.length() ;
		int i=0 ;
		if(haystack.equals("") || needle.equals(""))
			return -1 ; 
		if(m<n)
			return -1 ;
		if(m==n){
			if(haystack.equals(needle))
				return 0 ;
			else 
				return -1 ;
		}
		for(i=0;i<=m-n;i++){
			if(haystack.substring(i,n+i).equals(needle))
				return i ;
		}
		return -1 ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			String str = scr.nextLine() ;
			String sub = scr.nextLine() ;
			StrStr st = new StrStr() ;
			System.out.println(st.locateSubstring(str,sub)) ; 
		}
	}
}