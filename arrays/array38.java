//Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it is able to trap after raining.

import java.io.* ;
import java.util.* ;

public class array38{
	static int findMax(int arr[], int n){
		int i;
		int max = arr[0];
		int maxIndex = 0;
		for(i=1;i<n;i++){
			if(arr[i]>max){
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt() ;
		int arr[] = new int[n] ;
		int i;
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt();

		int maxIndex = findMax(arr,n);
		System.out.println(maxIndex);
		int j = 0, water = 0;
		for(i=0;i<maxIndex;i++){
			if(arr[i] > j)
				j = arr[i];
			else
				water += j-arr[i] ;
		}
		System.out.println(water);
		j=0 ;
		for(i=n-1;i>maxIndex;i--){
			if(arr[i]>j)
				j=arr[i];
			else
				water += j-arr[i];
		}
		System.out.println(water);
	}
}