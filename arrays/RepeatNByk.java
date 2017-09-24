/*
Given an array of of size n and a number k, find all elements that appear more than n/k times
*/

/*
Extension of Moore's Voting Algorithm. The number of such elements can never be more than k-1. 
Create a data structure which stores the potential candidates at each step. 
If a new element is encountered, decrease the count of each element by 1. 
Remove elements from the ds which have count=0 and ignore the current element. 
This step is like Moore's Voting Algorithm. 
*/

import java.io.* ;
import java.util.* ;

public class RepeatNByK{
	public int contains(int[] arr, int n, int m){
		for(int i=0;i<n;i++){
			if(arr[i]==m)
				return i ;
		}
		return -1 ;
	}
	public void decreaseBy1(int[] arr, int n){
		for(int i=0; i<n ;i++)
			arr[i] = arr[i]-1 ;
	}
	public int isCountZero(int [] arr, int n){
		for(int i=0; i<n ; i++){
			if(arr[i]==0)
				return 
		}
	}
	public int[] repeatNk(int[] arr, int n, int k){
		int[] temp = new int[k-1] ; 
		int[] count = new int[k-1] ;
		int i;
		for(i=0;i<n;i++){
			int index = contains(temp,k-1,arr[i]) ; 
			if(index!=-1){
				count[index]++ ;
			}
			else
				decreaseBy1(count,k-1) ;
			if(isCountZero())
		}
	}
}