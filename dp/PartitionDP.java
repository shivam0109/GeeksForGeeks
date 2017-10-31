/*
For a given k, there can be one or more ways to make clusters (partitions). 
We define a function Cost(i) for the i_{th} cluster, as the square of the difference between its first and last element.
*/

import java.io.* ;
import java.util.* ;

public class PartitionDP{
	public static int partition(int arr[], int n, int k){
		int dp[][] = new int[k][n] ;
		int i,j,m ;
		for(j=0;j<n;j++)
			dp[0][j] = (arr[j]-arr[0])*(arr[j]-arr[0]) ;
		for(i=1;i<k;i++)
			dp[i][0] = 100000000 ; 
		for(i=1;i<k;i++){
			for(j=1;j<n;j++){
				int x = Integer.MAX_VALUE ; 
				if(j<i)
					dp[i][j] = dp[i-1][j] ; 
				else{
					for(m=j;m>=1;m--){
						//System.out.println("i: " + i + " j: " +j) ; 
						x = Math.min(x,(arr[j]-arr[m])*(arr[j]-arr[m])+dp[i-1][m-1]) ; 
						//System.out.println(x) ; 
					}
					dp[i][j] = x ; 
				}	
			}
		}
		return dp[k-1][n-1] ; 
	}
	public static void main(String[] args){
		int arr[] = {1,5,8,10} ;
		// partition(0,0,arr,0,1,0,list,4) ; 
		System.out.println(partition(arr,4,2)) ; 
	}
}