/*
Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.

Variant of Kadane's Algorithm. 
Two cases :
a-> when wrapping does not occur. In this case, kadane's algo will give the correct answer. 
b-> when wrapping occurs, change sign of the numbers. The maximum sum from kadane's algo on this array will be from the elements 
	that won't contribute in the answer. Add answer to the total sum. 
Wrapping of contributing elements implies non wrapping of non contributing elements, so find out the sum of non contributing elements and subtract this sum from the total sum. 
To find out the sum of non contributing, invert sign of each element and then run Kadane’s algorithm.
*/

import java.io.* ;
import java.util.* ;

public class MaxCircularSubarraySum{
	public static int maxInArray(int[] arr, int n){
		int max = arr[0] ;
		for(int i = 1; i<n ; i++){
			if(arr[i]>max)
				max = arr[i] ;
		}
		return max ; 
	}

	public static int kadane(int arr[], int n){
		int i;
		int dp[] = new int[n] ;
		if(arr[0]>0)
			dp[0] = arr[0] ;
		else
			dp[0] = 0 ;
		for(i=1;i<n;i++)
			dp[i] = Math.max(dp[i-1]+arr[i],0) ;
		int max = maxInArray(dp,n) ;
		
		if(max==0)
			return maxInArray(arr,n) ; 

		return max ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			int sum = 0;
			int ans ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int ans1 = kadane(arr,n) ;
			//System.out.println("ans1: " + ans1) ;
			for(i=0;i<n;i++){
				sum += arr[i] ;
				arr[i] = -arr[i] ;
			}
			//System.out.println("sum: " + sum) ;
			int ans2 = kadane(arr,n) ;
			//System.out.println("ans2: " + ans2) ; 

			/*The sum of non contributing elements will be negative of ans2.  */
			ans2 = sum -(-ans2) ;
			if(ans2!=0)
				ans = Math.max(ans1,ans2) ; 
			else
				ans = ans1 ; 
			System.out.println(ans) ;  		
		}
	}
}