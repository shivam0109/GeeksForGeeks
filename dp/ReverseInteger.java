/*
Reverse digits of an integer.
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
*/ 

import java.io.* ;
import java.util.* ;

public class ReverseInteger{
	public int reverse(int x){
		String str = String.valueOf(x) ;
		boolean flag = true ; 
		String str2 ;
		if(str.charAt(0)=='-')
			flag = false ;
		if(flag)
			str2 = str.reverse() ;
		if(!flag)
			str2 = "-".concat(str.substring(1,str.length()).reverse()) ; 
		int num = Integer.valueOf(str2) ; 
		if(flag && num<0 || !flag && num< -Integer.MAX_VALUE)
			return 0 ;
		else 
			return num ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int n = scr.nextInt();
			int num = reverse(n) ;
			System.out.println(num) ; 
		}
	}
}
