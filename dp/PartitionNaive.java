/*
For a given k, there can be one or more ways to make clusters (partitions). 
We define a function Cost(i) for the i_{th} cluster, as the square of the difference between its first and last element.
*/

import java.io.* ;
import java.util.* ;

public class PartitionNaive{
	public static void partition(int i, int j, int arr[], int par, int k, int cost, ArrayList<Integer> list, int n){
		if(par>k)
			return ; 
		if(i==n-1 && par==k){
			System.out.println(i+ " " + j+ " " +cost) ; 
			list.set(0,Math.min(list.get(0),cost + (arr[n-1]-arr[j])*(arr[n-1]-arr[j]) ) ) ;
			return ; 
		}
		if(i>=n)
			return ; 
		partition(i+1,i+1,arr,par+1,k,cost + (arr[i]-arr[j])*(arr[i]-arr[j]), list, n) ; 
		partition(i+1,j,arr,par,k,cost,list,n) ; 
	}
	public static void main(String[] args){
		int arr[] = {1,5,8,10} ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		list.add(Integer.MAX_VALUE) ; 
		partition(0,0,arr,0,1,0,list,4) ; 
		System.out.println(list.get(0)) ; 
	}
}