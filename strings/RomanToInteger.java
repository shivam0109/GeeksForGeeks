/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/ 

import java.io.* ;
import java.util.* ;

public class RomanToInteger{
	public int romanToInt(String str) {
        int num = 0;
        int i=0;
        int len = str.length() ;
        while(i<len){
            char c = str.charAt(i) ;
            if(c=='M'){
                num += 1000 ;
                i++ ;
            }
            else if(i+1<len && c=='C' && str.charAt(i+1)=='M'){
                num += 900 ;
                i += 2 ;
            }
            else if(c=='D'){
                num += 500 ;
                i++ ;
            }
            else if(i+1<len && c=='C' && str.charAt(i+1)=='D'){
                num += 400 ;
                i += 2 ;
            }
            else if(c=='C'){
                num += 100 ;
                i++ ;
            }
            else if(i+1<len && c=='X' && str.charAt(i+1)=='C'){
                num += 90 ;
                i += 2 ;
            }
            else if(c=='L'){
                num += 50 ;
                i++ ;
            }
            else if(i+1<len && c=='X' && str.charAt(i+1)=='L'){
                num += 40 ;
                i += 2 ;
            }
            else if(c=='X'){
                num += 10 ;
                i++ ;
            }
            else if(i+1<len && c=='I' && str.charAt(i+1)=='X'){
                num += 9 ;
                i += 2 ;
            }
            else if(c=='V'){
                num += 5 ;
                i++ ;
            }
            else if(i+1<len && c=='I' && str.charAt(i+1)=='V'){
                num += 4 ;
                i += 2 ;
            }
            else{
                num += 1 ;
                i++ ;
            } 
        }
        return num ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			RomanToInteger roman = new RomanToInteger() ;
			String str = scr.next() ;
			int num = roman.romanToInt(str) ; 
			System.out.println(num) ;  	
		}
    }
}