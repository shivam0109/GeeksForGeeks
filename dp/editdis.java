//Program to compute edit distance between two strings.

import java.util.*;
import java.io.* ;

public class editdis{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int m = scr.nextInt();
			int n = scr.nextInt();
			String str1 = scr.next();
			String str2 = scr.next();
			//int m = str1.length();
			//int n = str2.length();
			int mat[][] = new int[m+1][n+1];
			int flag = 0;
 			
 			for(i=0;i<m+1;i++){
 				for(j=0;j<n+1;j++){
 					if(i==0)
 						mat[i][j] = j;
 					else if(j==0)
 						mat[i][j] = i;
 					else{
 						if(str1.charAt(i-1)==str2.charAt(j-1))
 							mat[i][j] = mat[i-1][j-1];
 						else
 							mat[i][j] = 1+Math.min(mat[i-1][j-1],Math.min(mat[i-1][j],mat[i][j-1]));
 					}
  				}
 			}

 			for(i=0;i<m+1;i++){
 				for(j=0;j<n+1;j++)
 					System.out.printf("%d ",mat[i][j]);
 				System.out.printf("\n");
 			}
 			//System.out.println(mat[m-1][n-1]);
 			System.out.printf("\n");
 		}		
	}
}