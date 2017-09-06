/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

import java.io.* ;
import java.util.* ;

public class ReverseWords{
	public void reverse(char[] arr, int start, int end){
        System.out.println("start: " + start + " end: " + end) ; 
        int left = start ;
        int right = end ;
        while(left<=right){
            char temp = arr[left] ;
            arr[left] = arr[right] ;
            arr[right] = temp ; 
            left++ ;
            right-- ;
        }
    }
    public String reverseWords(String s) {
        if(s.length()==0)
            return "" ; 
        if(s.length() == 1 && s.charAt(0) == ' ') 
            return "" ;
        s = s.trim() ; 
        char[] arr = s.toCharArray() ; 
        int n = s.length() ; 
        reverse(arr,0,n-1) ; 
        System.out.println(String.valueOf(arr)) ;
        int start = 0 ;
        int end = 1 ;
        int i;
        for(i=0;i<n;i++){
        	if(arr[i] == ' '){
        		end = i ;
        	    reverse(arr,start,end-1) ; 
        	    start = end+1 ;
            }
        }
        reverse(arr,start,n-1) ; 
        String str = String.valueOf(arr) ;
        str = str.replaceAll(" +"," ") ;
        System.out.println(str) ; 
        return str ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		String str = scr.nextLine() ;
    		ReverseWords rw = new ReverseWords() ;
    		rw.reverseWords(str) ; 
    	}
    }
}