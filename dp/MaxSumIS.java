//Given an array of n positive integers. 
//Write a program to find the sum of maximum sum subsequence of the given array 
//such that the intgers in the subsequence are sorted in increasing order. 
//For example, if input is {1, 101, 2, 3, 100, 4, 5}, 
//then output should be 106 (1 + 2 + 3 + 100), 
//if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and 
//if the input array is {10, 5, 4, 3}, then output should be 10. 

import java.io.* ;
import java.util.* ;

public class MaxSumIS{
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
		int i,j,k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int sum[] = new int[n];
			
			for(i=0;i<n;i++)
				sum[i] = arr[i] ;

			for(i=1;i<n;i++){
				for(j=0;j<i;j++){
					if(arr[j]<arr[i] && sum[i]<sum[j]+arr[i])
						sum[i] = sum[j]+arr[i];
				}
				//sum[i] = Math.max(sum[i],sum[i-1]);
			}

			for(i=0;i<n;i++)
				System.out.printf("%d ",sum[i]);
			System.out.printf("\n");		
			int m = max(sum);
			System.out.println(m);			
		}
	}
}

