//Find minimum number of coins to make a sum.

import java.io.* ;
import java.util.* ;

public class mincoin{
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
							mat[i][j] = 0;
						else{
							if(j%arr[i]==0)
								mat[i][j] = j/arr[i];
							else
								mat[i][j] = -1;
						}
					}
					else if(j==0)
						mat[i][j] = 0;
					else{
						if(j<arr[i])
							mat[i][j] = mat[i-1][j];
						else{
							if(mat[i-1][j]!=-1 && mat[i][j-arr[i]]!=-1)
								mat[i][j] = Math.min(mat[i][j-arr[i]]+1,mat[i-1][j]);
							else if(mat[i-1][j]==-1 && mat[i][j-arr[i]]!=-1)
								mat[i][j] = mat[i][j-arr[i]]+1;
							else if(mat[i-1][j]!=-1 && mat[i][j-arr[i]]==-1)
								mat[i][j] = mat[i-1][j];
							else
								mat[i][j] = -1;
						}
					}
				}
			}

			for(i=0;i<m;i++){
				for(j=0;j<sum+1;j++){
					System.out.printf("%d ",mat[i][j]);
				}
				System.out.printf("\n");
			}
			//System.out.printf("\n");		
		}
	}
}