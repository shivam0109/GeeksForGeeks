/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.
*/

import java.io.* ;
import java.util.* ;

public class LastWord{
	public int lengthOfLastWord(final String str) {
	   // int n = str.length() ;
	   // int start = n-1 ;
	   // while(start>=0 && str.charAt(start)!=' ')
	   //     start-- ;
	   // return n-1-start ; 
	   String[] word = str.split("\\s") ;
	   int n = word.length ;
	   if(n==0)
	      return 0 ;
	   return word[n-1].length() ; 
	}
	public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	scr.nextLine() ; 
    	while(ntest-->0){
    		String str = scr.nextLine() ;
    		LastWord lword = new LastWord() ;
    		System.out.println(lword.lengthOfLastWord(str)) ; 
    	}
    }
}