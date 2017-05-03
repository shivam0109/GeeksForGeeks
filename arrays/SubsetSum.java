//Given an array. Find whether it can be partitioned into two subsets with equal sum. Also, find the subset.

import java.io.*;
import java.util.* ;

public class SubsetSum{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int size = scr.nextInt();
			int arr[] = new int[size];
			int sum = 0;
			int flag = 1;
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt();
				sum = sum + arr[i];
			}
			//System.out.printf("\n");
			if(sum%2 == 1){
				flag = 0;
				System.out.println("NO");
			}
			else{
				int mat[][] = new int[size][sum/2+1];
				for(i=0;i<size;i++){
					for(j=0;j<(sum/2+1);j++){
						//initalize top row
						if(i==0){
							if(j!=0 && j!= arr[i]){
								mat[i][j] = 0;
							}
							else
								mat[i][j] = 1;									
						}
						//initialize 1st column
						else if(j==0)
							mat[i][j] = 1;
						//general case
						else{
							//copy the upper row until we can use new element.
							while(j!=arr[i]){
								mat[i][j] = mat[i-1][j];
								j = j+1;
							}
							//if we get mat[i-1][j] = 1, we were able to generate sum j using prev elements. So, we will be able 
							//to generate that sum now also.
							//if mat[i-1][j] = 0, check mat[i-1][j-arr[i]], if 1, then by using the new element we can make sum = j;
							while(j!=(sum/2+1)){
								if(mat[i-1][j] == 1)
									mat[i][j] = 1;
								else{
									if(mat[i-1][j-arr[i]] == 0)
										mat[i][j] = 0;
									else 
										mat[i][j] = 1;
								}
								j = j+1;
							}
						}
					}
				}
				// for(i=0;i<size;i++){
				// 	for(j=0;j<(sum/2 + 1);j++)
				// 		System.out.printf("%d ",mat[i][j]);
				// 	System.out.printf("\n");
				// }
				if(mat[size-1][sum/2]==1)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}