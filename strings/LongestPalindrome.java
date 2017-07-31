/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/ 


/*
Fix a center and expand around it to see if it forms a palindrome or not. Vary centers from i=0 to i=n-1. 
Search for both even and odd length substrings. So there are 2n-1 centers. n for odd and n-1 for even. 
*/
import java.io.* ;
import java.util.* ;

public class LongestPalindrome{
		public String longestPal(String str){
		int start = 0;
		int end = 0 ;
		int size = str.length() ;
		int i;
		for(i=0;i<str.length();i++){
			//odd length palindrome 
			int len1 = expandAroundCenter(str,i,i,size) ;
			//even length palindrome 
			int len2 = expandAroundCenter(str,i,i+1,size) ;
			int len = Math.max(len1,len2) ;
			if(len>end-start){
				start = i-(len-1)/2 ; 
				end = i + len/2 ; 
			} 
		}
		return str.substring(start,end+1) ;
	}
	public int expandAroundCenter(String str, int i, int j, int size){
		int left = i ;
		int right = j ;
		//int len = 0 ;
		while(left>=0 && right<=size-1){
			if(str.charAt(left)==str.charAt(right)){
				left-- ;
				right++ ;
			}
			else 
				break ;
		}
		return right-left-1 ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			String str = scr.next() ;
			LongestPalindrome lp = new LongestPalindrome() ;
			System.out.println(lp.longestPal(str)) ;
		}
	}
}