/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*/

import java.io.* ;
import java.util.* ;

public class PalinString{
	public boolean isPalin(String str){
		//str = str.replaceAll("\\s+","") ; 
		str = str.replaceAll("[^A-Za-z0-9]","") ; 
		str = str.toLowerCase() ;
		if(str.equals(""))
			return true; 
		int n = str.length() ;
		int left = 0 ;
		int right = n-1 ;
		while(left<right){
			if(str.charAt(left)!=str.charAt(right))
				return false ;
			left++ ;
			right-- ;
		}
		return true ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			String str = scr.nextLine() ;
			PalinString ps = new PalinString() ; 
			System.out.println(ps.isPalin(str)) ; 
		}
	}
}