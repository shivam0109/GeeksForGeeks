//Given an array of integers where each element represents the max number of steps that can be made forward from that element. 
//Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
//Output: 3 (1-> 3 -> 8 ->9)

import java.io.* ;
import java.util.* ;

public class minjumps{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i,j;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int dp[] = new int[n];
			dp[0] = 0;
			for(i=1;i<n;i++)
				dp[i] = n;
			for(i=1;i<n;i++){
				for(j=0;j<i;j++){
					if(dp[i]>dp[j]+1 && i-j<=arr[j])
						dp[i] = dp[j]+1;
				}
			}
			for(i=0;i<n;i++)
				System.out.printf("%d ",dp[i]);
			System.out.printf("\n");
		}
	}
}