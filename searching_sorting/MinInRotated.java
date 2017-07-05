//A sorted array A[ ] with distinct elements is rotated at some unknown point, 
//the task is to find the minimum element in it.

import java.io.* ;
import java.util.* ;

public class MinInRotated{
	static int bsearch(int[] arr, int left, int right){
		if(left<=right){
			int mid = (left+right)/2 ;
			if(mid==left)
				return Math.min(arr[left],arr[0]) ; 
			
			if(mid==right)
				return Math.min(arr[right],arr[0]) ; 

			if(mid-1>=left && mid+1<=right){
				if(arr[mid-1]>arr[mid] && arr[mid]<arr[mid+1])
					return arr[mid] ;
				if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1] && arr[mid] > arr[0])
					return bsearch(arr,mid,right) ; 
				if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1] && arr[mid] < arr[0])
					return bsearch(arr,left,mid) ;
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
					return arr[mid+1] ;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int ans = bsearch(arr,0,n-1) ;
			System.out.println(ans) ;
		}
	}
}
