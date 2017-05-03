//Given an unsorted array of size n. Array elements are in range from 1 to n. 
//One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.

import java.io.*;
import java.util.* ;

public class array28{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i;
			int sum = 0;
			for(i=0;i<n;i++){
				arr[i] = scr.nextInt();
				sum += arr[i];
			}
			for(i=0;i<n;i++){
				arr[arr[i]%n] += n;
			}
			for(i=0;i<n;i++){
				if((float)arr[i]/n > 2)
					break;
			}
			int dup = i;
			if(dup==0)
				dup = n;
			int reqsum = (n*(n+1))/2 ;
			int diff = reqsum - sum;
			int miss = dup + diff;
			System.out.printf("%d %d",dup,miss);
			System.out.printf("\n");
		}
	}
}