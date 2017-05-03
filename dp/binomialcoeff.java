//Find Binomial Coefficient using DP

import java.io.* ;
import java.util.* ;

public class binomialcoeff{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		int mat[][] = new int[n][k];
		int i,j;
		for(i=0;i<n;i++){
			for(j=0;j<k;j++){
				if(j==0)
					mat[i][j] = i+1;
				else if(j<=i)
					mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
				else
					mat[i][j] = 0;
			}
		}
		for(i=0;i<n;i++){
			for(j=0;j<k;j++){
				System.out.printf("%d ",mat[i][j]);
			}
			System.out.printf("\n");
		}

	}
}