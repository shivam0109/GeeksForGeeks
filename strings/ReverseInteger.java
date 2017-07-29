/*
Reverse digits of an integer.
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
*/ 

import java.io.* ;
import java.util.* ;

public class ReverseInteger{
	public String reverseString(String str){
		char[] arr = str.toCharArray() ;
		int left = 0 ;
		int right = str.length()-1 ;
		while(left<right){
			char temp = arr[left] ;
			arr[left] = arr[right] ;
			arr[right] = temp ;
			left++ ;
			right-- ;
		}
		String str2 = String.valueOf(arr) ;
		return str2 ; 
	}
	public int reverse(int x){
		String str = String.valueOf(x) ;
		String str2 ;
		boolean flag = true ;
		int num = 0;
		if(str.charAt(0)=='-'){
			flag = false ;
			str2 = str.substring(1,str.length()) ;
			str2 = reverseString(str2) ;
			str2 = "-".concat(str2) ; 
		} 
		else{
			str2 = reverseString(str) ; 
		}
		try{
			num = Integer.valueOf(str2) ;
		}
		catch(NumberFormatException e){
			return 0 ;
		}
		return num ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			ReverseInteger r = new ReverseInteger() ;
			int n = scr.nextInt();
			int num = r.reverse(n) ;
			System.out.println(num) ; 
		}
	}
}
