//0-1 Knapsack Problem.

import java.io.*;
import java.util.* ;

public class knapsack01{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k ;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int w = scr.nextInt();
			int val[] = new int[n];
			int wt[] = new int[n];
			for(i=0;i<n;i++)
				val[i] = scr.nextInt();
			for(i=0;i<n;i++)
				wt[i] = scr.nextInt();
			int mat[][] = new int[n+1][w+1];
			for(i=0;i<n+1;i++){
				for(j=0;j<w+1;j++){
					if(i==0 || j==0)
						mat[i][j] = 0;
					else if(wt[i-1]<=j)
						mat[i][j] = Math.max(mat[i-1][j],val[i-1]+mat[i-1][j-wt[i-1]]);
					else
						mat[i][j] = mat[i-1][j];
				}
			}
			for(i=0;i<n+1;i++){
				for(j=0;j<w+1;j++){
					System.out.printf("%d ",mat[i][j]);
				}
				System.out.printf("\n");
			}
 		}
	}
}