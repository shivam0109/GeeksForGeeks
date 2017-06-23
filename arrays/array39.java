//Find Peak Element in an Array

//The task is to find a peak element in it. An array element is peak if it is not smaller than its neighbors. 
//For corner elements, we need to consider only one neighbor.

import java.io.* ;
import java.util.* ;

public class array39{
	static int getPeakIndex(int arr[], int left, int right, int n){
		if(left<=right){
            int mid = left + (right-left)/2 ;
            if(right==left)
            	return left;
            if(right-left==1){
            	if(arr[left]<=arr[right])
            		return right;
            	else
            		return left;
            }
            if(mid-1>=0 && mid+1<=n-1 && arr[mid]>=arr[mid-1] && arr[mid+1]<=arr[mid])
            	return mid;
            else if(mid-1>=0 && arr[mid]<arr[mid-1])
            	return 	getPeakIndex(arr,left,mid-1,n);
            else
            	return getPeakIndex(arr,mid+1,right,n);
        }
        return -1;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int index = getPeakIndex(arr,0,n-1,n);
			System.out.println(index);
		}
	}
}