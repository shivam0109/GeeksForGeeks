//Given a value N, if we want to make change for N cents, and we have infinite supply of each of 
//S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
//one coin can be used many times.

import java.io.* ;
import java.util.* ;

public class coinchange{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int m = scr.nextInt();
			int sum = scr.nextInt();
			int arr[] = new int[m];
			for(i=0;i<m;i++)
				arr[i] = scr.nextInt();
			
			int mat[][] = new int[m][sum+1];

			for(i=0;i<m;i++){
				for(j=0;j<sum+1;j++){
					if(i==0){
						if(j==0)
							mat[i][j] = 1;
						else{
							if(j%arr[i]==0)
								mat[i][j] = 1;
							else
								mat[i][j] = 0;
						}	
					}
					else if(j==0)
						mat[i][j] = 1;
					else{
						if(arr[i]>j)
							mat[i][j] = mat[i-1][j];
						else
							mat[i][j] = mat[i-1][j] + mat[i][j-arr[i]];
					}
				}
			}

			for(i=0;i<m;i++){
				for(j=0;j<sum+1;j++){
					System.out.printf("%d ",mat[i][j]);
				}
				System.out.printf("\n");
			}
			System.out.printf("\n");
		}
	}
}