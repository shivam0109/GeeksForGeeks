//Given a number n, write a program that returns count of numbers from 1 to n that don’t contain digit 3 in their decimal representation.

import java.io.* ;
import java.util.* ;

public class math2{
	static int cointains3(int k){
		String s = String.valueOf(k);
		int i;
		int flag = 0;
		for(i=0;i<s.length();i++){
			if(s.charAt(i)=='3'){
				flag = 1;
				break; 
			}
		}
		if(flag==1)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt();		
			int count = 0;
			for(i=1;i<=n;i++){
				if(cointains3(i)==0)
					count += 1;
			}
			System.out.println(count);
		}
	}	
}