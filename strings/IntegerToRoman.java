/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

import java.io.* ;
import java.util.* ;

public class IntegerToRoman{
	public String intToRomanUtil(int num, String str){
        //System.out.println(str) ; 
        if(num>=1000){
            str = str.concat("M") ;
            num = num-1000 ;
            //System.out.println(str) ; 
            return intToRomanUtil(num,str) ;
        }
        else if(num>=900){
            str = str.concat("CM") ;
            num = num-900 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=500){
            str = str.concat("D") ;
            num = num-500 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=400){
            str = str.concat("CD") ;
            num = num-400 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=100){
            str = str.concat("C") ;
            num = num-100 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=90){
            str = str.concat("XC") ;
            num = num-90 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=50){
            str = str.concat("L") ;
            num = num-50 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=40){
            str = str.concat("XL") ;
            num = num-40 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=10){
            str = str.concat("X") ;
            num = num-10 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=9){
            str = str.concat("IX") ;
            num = num-9 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=5){
            str = str.concat("V") ;
            num = num-5 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=4){
            str = str.concat("IV") ;
            num = num-4 ;
            return intToRomanUtil(num,str) ;
        }
        else if(num>=1){
            str = str.concat("I") ;
            num = num-1 ;
            return intToRomanUtil(num,str) ;
        }
        else
            return str ; 
    }
    public String intToRoman(int num){
    	String str = intToRomanUtil(num,"") ;
    	return str ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		IntegerToRoman roman = new IntegerToRoman() ;
    		int num = scr.nextInt() ;
    		String str = roman.intToRoman(num) ; 
    		System.out.println(str) ; 
    	}
    }
}
