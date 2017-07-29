/*
Given a string, find the longest substring which is palindrome 
*/

import java.io.* ;
import java.util.* ;

public class LongestPalSubstring{
	public String reverseString(String str){
		int left = 0;
		int right = str.length()-1 ;
		char[] arr = str.toCharArray() ;
		while(left<=right){
			char temp = arr[left] ;
			arr[left] = arr[right] ;
			arr[right] = temp ;
			left++ ;
			right-- ;
		}
		str = String.valueOf(arr) ;
		return str ; 
	}
	public void printMatrix(int mat[][], int m, int n){
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++)
				System.out.printf("%d ",mat[i][j]) ;
			System.out.printf("\n") ;
		}
	}
	public String longestPalSub(String str){
		String reverse = reverseString(str) ;
		int n = str.length() ;
		System.out.println(str) ;
		int mat[][] = new int[n+1][n+1] ;
		int i,j ;
		int maxi = 0 ;
		int maxj = 0 ;
		int maxLen = 0 ;
		for(i=0;i<n+1;i++){
			for(j=0;j<n+1;j++){
				if(i==0 || j==0)
					mat[i][j] = 0;
				else{
					char x = str.charAt(i-1) ; 
					char y = reverse.charAt(j-1) ;
					if(x!=y)
						mat[i][j] = 0;
					else if(x==y && mat[i-1][j-1]>0)
						mat[i][j] = mat[i-1][j-1] + 1;
					else
						mat[i][j] = 1;
					if(mat[i][j]>maxLen){
						maxLen = mat[i][j] ;
						maxi = i ;
						maxj = j ;
					}
				}
			}
		}
		System.out.println(maxi + " " + maxj) ;
		printMatrix(mat,n+1,n+1) ; 
		String substr = str.substring(maxi-maxLen,maxi) ;
		return substr ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			LongestPalSubstring l = new LongestPalSubstring() ;
			String str = scr.next() ;
			String ans = l.longestPalSub(str) ;
			System.out.println(ans) ;  	
		}
	}
}