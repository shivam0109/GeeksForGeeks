/*
Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.
*/

import java.io.* ;
import java.util.* ;

public class PowerOf2{
	public String removeLeadingZeros(String str){
		int len = str.length() ;
		int i=0 ;
		for(i=0;i<len;i++){
			if(str.charAt(i)!='0')
				break ;
		}
		if(i==len)
			return "0" ; 
		return str.substring(i,len) ; 
	}
	public String[] divideBy2(String str){
		//System.out.println("Dividend: "+str);
		String[] ans = new String[2] ;
		int len = str.length() ;
		String quotient = "" ;
		int i=0 ;
		boolean flag = false ;
		for(i=0;i<len;i++){
			int num = Integer.valueOf(str.charAt(i))-48 ;
			//System.out.println("num: " + num) ;
			if(flag)
				num += 10 ;
			int q = num/2 ;
			quotient = quotient.concat(String.valueOf(q)) ; 
			if(num%2==1)
				flag = true ;
			else
				flag = false ; 
		}
		if(flag)
			ans[0] = "1" ;
		else
			ans[0] = "0" ; 
		ans[1] = quotient ;
		return ans ; 
	}
	public boolean isPowerOf2(String str){ 
		str = removeLeadingZeros(str) ;
		System.out.println(str) ;
		if(str.equals("1") || str.equals("0"))
			return false ;
		if(str.equals("2"))
			return true ;
		String[] div = divideBy2(str) ;
		if(div[0]=="1")
			return false ;
		return isPowerOf2(div[1]) ; 
	}
	public static void main(String[] args){
		String number = "0000000000000000000040" ; 
		PowerOf2 powOf2 = new PowerOf2() ;
		System.out.println(powOf2.isPowerOf2(number)) ; 
	}
}