/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/ 

import java.io.* ;
import java.util.* ;

public class CountAndSay{
	public String countSayUtil(String str, int i, int n){
		if(i==n)
			return str ;
		int len = str.length() ;
		if(len==1)
			return countSayUtil("11",2,n) ;
		String retString = "" ;
		int j;
		int count = 1 ;
		for(j=0;j<len-1;j++){
			if(str.charAt(j+1)==str.charAt(j))
				count++ ;
			else{
				retString += String.valueOf(count) + String.valueOf(str.charAt(j));
				count = 1;  
			}
		}
		if(len-2>=0 && str.charAt(len-1)!=str.charAt(len-2)){
			retString += "1" + String.valueOf(str.charAt(len-1)) ;
		}
		else{
			retString += String.valueOf(count)+String.valueOf(str.charAt(len-1)) ; 
		}
		return countSayUtil(retString,i+1,n) ; 
	}
	public String countSay(int n){
		String str = "1" ; 
		String ans = countSayUtil(str,1,n) ; 
		return ans ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			int n = scr.nextInt() ;
			CountAndSay cs = new CountAndSay() ;
			System.out.println(cs.countSay(n)) ; 
		}
	}
}