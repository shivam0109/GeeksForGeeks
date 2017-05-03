//Longest Increasing Subsequence using DP

import java.io.* ;
import java.util.* ;

public class lis{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int i,j;
		int arr[] = new int[n];
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt();
		int dp[] = new int[n];
		for(i=0;i<n;i++)
			dp[i] = 1;
		for(i=1;i<n;i++){
			for(j=0;j<i;j++){
				if(arr[j]<arr[i] && dp[i]<(1+dp[j])){
					dp[i] = dp[j]+1;
				}
			}
		}
		for(i=0;i<n;i++)
			System.out.printf("%d ",dp[i]);
		System.out.printf("\n");
	}
}