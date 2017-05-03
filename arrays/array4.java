//Write an efficient C program to find the sum of contiguous subarray within a one-dimensional 
//array of numbers which has the largest sum.

import java.util.* ;
import java.io.* ;

public class array4{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int arr[] = new int[size];
		int dp[] = new int[size];
		int i;
		for(i=0;i<size;i++)
			arr[i] = scr.nextInt();
		dp[0] = arr[0];
		for(i=1;i<size;i++){
			dp[i] = Math.max(dp[i-1] + arr[i],0);
		}	
		Arrays.sort(dp);
		int ans = dp[size-1];
		if(ans!=0)
			System.out.println(ans);
		else{
			Arrays.sort(arr);
			System.out.println(arr[size-1]);
		}	

	}
}
