//Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
//Kadane's Algorithm
import java.io.* ;
import java.util.*;

public class LargestSumContSubarray{
	static int max(int arr[]){
		int i;
		int max = arr[0];
		for(i=1;i<arr.length;i++){
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();		
		int i,j;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int dp[] = new int[n];
			for(i=0;i<n;i++){
				if(i==0){
					if(arr[i]>0)
						dp[i] = arr[i];
					else
						dp[i] = 0;
				}
				else
					dp[i] = Math.max(dp[i-1]+arr[i],0);
			}
			for(i=0;i<n;i++)
				System.out.printf("%d ",dp[i]);
			System.out.printf("\n");				
			int ans = max(dp);
			if(ans==0)
				System.out.println(max(arr));
			else
				System.out.println(ans);
		}
	}
}