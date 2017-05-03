//Given a sequence, find the length of the longest palindromic subsequence in it. 
//For example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. 
//“BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.

import java.io.* ;
import java.util.* ;

public class LPalinSub{
	static char[] reverse(String s){
		char[] carr = s.toCharArray();
		int i;
		int len = s.length();
		char c;
		for(i=0;i<len/2;i++){
			c = carr[i];
			carr[i] = carr[len-i-1];
			carr[len-i-1] = c;
		}
		return carr;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		String str = scr.next();
		char[] arr = str.toCharArray();
		char[] rev = reverse(str);
		//System.out.println(revstr);
		for(int i=0;i<rev.length;i++)
			System.out.printf("%c",rev[i]);
		System.out.printf("\n");
		int mat[][] = new int[arr.length+1][arr.length+1];
		int i,j;
		for(i=0;i<arr.length;i++){
			for(j=0;j<rev.length;j++){
				if(i==0||j==0)
					mat[i][j] = 0;
				else{
					if(arr[i-1]==rev[j-1])
						mat[i][j] = mat[i-1][j-1]+1;
					else
						mat[i][j] = Math.max(mat[i][j-1],mat[i-1][j]);
				}
			}
		}
		for(i=0;i<arr.length;i++){
			for(j=0;j<rev.length;j++)
				System.out.printf("%d ",mat[i][j]);
			System.out.printf("\n");
		}
		//System.out.println(mat[arr.length-1][rev.length-1]);
	}
}