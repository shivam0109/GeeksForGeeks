//Longest Increasing Subsequence using recursion.

import java.io.* ;
import java.util.* ;

public class LIS_REC{
	static int lis(int arr[], int size){
		int i;
		if(size==1)
			return 1;
		int current_lis = 1;
		for(i=0;i<size-1;i++){
			int subprob_lis = lis(arr,i);
			if(arr[size-1]>arr[i] && current_lis< (1+subprob_lis))
				current_lis = 1 + subprob_lis;
		}
		System.out.printf("size : %d, current_lis: %d ",size,current_lis);
		System.out.printf("\n");
		
		if (max_lis_length < current_lis)
    	    max_lis_length = current_lis;
    	return current_lis;
	}
	static int _lis(int arr[],int n){
		max_lis_length = 1;
		_lis(arr,n);
		return max_lis_length;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int i;
		int arr[] = new int[size];
		for(i=0;i<size;i++)
			arr[i] = scr.nextInt();
		lis(arr,size);
	}
}