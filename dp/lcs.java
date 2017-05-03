//Find the Longest Common Subsequence

import java.io.* ;
import java.util.* ;

public class lcs{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int k;
		int ntest = scr.nextInt();
		for(k=0;k<ntest;k++){
			int m = scr.nextInt();
			int n = scr.nextInt();
			String str1 = scr.next();
			String str2 = scr.next();
			//int m = str1.length();
			//int n = str2.length();
			int mat[][] = new int[m][n];
			int i,j;
			for(i=0;i<m;i++){
				for(j=0;j<n;j++)
					mat[i][j] = 0;
			}
		
			for(j=0;j<n;j++){
				if(str1.charAt(0) == str2.charAt(j)){
					mat[0][j] = 1;
					while(j!=n){
						mat[0][j] = 1;
						j++ ;
					}
				}
			}
			
			for(i=0;i<m;i++){
				if(str1.charAt(i) == str2.charAt(0)){
					mat[i][0] = 1;
					while(i!=m){
						mat[i][0] = 1;
						i++;
					}
				}
			}

			for(i=1;i<m;i++){
				for(j=1;j<n;j++){
					if(str1.charAt(i)==str2.charAt(j)){
						mat[i][j] = mat[i-1][j-1] + 1;
					}
					else{
						mat[i][j] = Math.max(mat[i-1][j],mat[i][j-1]);
					}
				}
			}

			for(i=0;i<m;i++){
				for(j=0;j<n;j++)
					System.out.printf("%d ",mat[i][j]);
				System.out.printf("\n");
			}
			//System.out.println(mat[m-1][n-1]);
		}
	}	
}