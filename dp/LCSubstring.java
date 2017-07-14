//Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

import java.io.* ;
import java.util.* ;

public class LCSubstring{
	static int findLCSubstr(char[] ch1, char[] ch2, int m, int n){
		int mat[][] = new int[m+1][n+1] ;
		int i,j ;
		int result = 0;
		for(i=0;i<m+1;i++){
			for(j=0;j<n+1;j++){
				if(i==0 || j==0)
					mat[i][j] = 0; 
				else if(ch1[i-1]==ch2[j-1]){
					mat[i][j] = mat[i-1][j-1] + 1;
					result = Math.max(result,mat[i][j]) ;
				}
				else
					mat[i][j] = 0 ;
			}
		}
		return result ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int m = scr.nextInt() ;
			int n = scr.nextInt() ;
			String str1 = scr.next() ;
			String str2 = scr.next() ;
			char ch1[] = str1.toCharArray() ;
			char ch2[] = str2.toCharArray() ;
			int ans = findLCSubstr(ch1,ch2,m,n) ; 
			System.out.println(ans) ;
		}
	}
}