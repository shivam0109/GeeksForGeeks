//Given a sorted array having no duplicates, arr[] and a value, x, find floor of x in given array. 
//Floor of x is the largest element in arr[] such that the element is smaller than or equal to x. 
//If floor exists, then return index of it, else return -1.

import java.io.* ;
import java.util.* ;

public class FloorInSorted{
	static int findFloor(int arr[], int n, int x){
		int start = 0;
		int end = n-1;
		while(start<=end){
			int mid = (start+end)/2 ;
			if(arr[mid]==x)
				return mid ;
			else if(mid+1==n && arr[mid]<x)
				return mid ;
			else if(mid+1<n && arr[mid]<x && arr[mid+1]>x)
				return mid ;
			else if(arr[mid]>x)
				end = mid-1 ;
			else
				start = mid+1 ;
		}
		return -1 ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int x = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int ans = findFloor(arr,n,x) ;
			System.out.println(ans) ;
		}
	}
}