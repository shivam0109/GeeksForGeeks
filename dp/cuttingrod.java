//Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
//Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
//For example, if length of the rod is 8 and the values of different pieces are given as following, 
//then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

//length   | 1   2   3   4   5   6   7   8  
//--------------------------------------------
//price    | 1   5   8   9  10  17  17  20

import java.io.* ;
import java.util.* ;

public class cuttingrod{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int i,j,k;
		int n = scr.nextInt();
		int arr[] = new int[n];
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt();
		int dp[] = new int[n];
		int sum,max;
		dp[0] = arr[0];
		for(i=1;i<n;i++){
			max = arr[i];
			for(j=0;j<=i/2;j++){
				sum = dp[j]+dp[i-j-1];
				if(sum>max)
					max = sum;						
			}
			dp[i] = max;
		}
		for(i=0;i<n;i++)
			System.out.printf("%d ",dp[i]);
		System.out.printf("\n");
	}
}