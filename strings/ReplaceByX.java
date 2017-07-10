//Given a string and a pattern, Replace all the continuous occurrence of pattern with a single X in the string.

import java.io.* ;
import java.util.* ;

public class ReplaceByX{
	static String replace(String input, String pattern){
		String ans = ""  ;
		int inputLen = input.length() ;
		int patLen = pattern.length() ;
		int i=0;
		while(i<inputLen){
			if(i+patLen>inputLen){
				ans = ans.concat(input.substring(i,inputLen)) ;
				i = inputLen ;
			}
			else{
				String substr = input.substring(i,i+patLen) ;
				if(ans.length()==0 && substr.equals(pattern)){
					ans = ans.concat("X") ;
					i+=patLen ;
				}
				else if(substr.equals(pattern) && ans.charAt(ans.length()-1)!='X'){
					ans = ans.concat("X") ;
					i+=patLen;
				}
				else if(substr.equals(pattern) && ans.charAt(ans.length()-1)=='X')
					i += patLen ;
				else{
					ans = ans.concat(String.valueOf(input.charAt(i))) ;
					i++ ;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			String str = scr.next() ;
			String pattern = scr.next() ;
			String ans = replace(str,pattern) ;
			System.out.println(ans) ;
		}
	}
}