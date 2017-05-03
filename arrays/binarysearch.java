//Perform Binary Search on a sorted array

import java.util.*;
import java.io.* ;

public class binarysearch{
	public static int bsearch(int a[], int size, int num){
		int left,right,flag = 0;
		left = 0;
		right = size-1;
		int mid = (left+right)/2;
		System.out.printf("Before Loop : %d %d %d\n", left,mid,right);
		while(left <= right){
			if(a[mid] == num){
				flag = 1;
				System.out.println("First If") ;
				break;
			}
			else if(a[mid]>num){
				right = mid-1 ;
				System.out.println("2nd If") ;
			}
			else{
				left = mid+1 ;
				System.out.println("3rd If") ;
			}
			mid = (left+right)/2 ;
			System.out.printf("%d %d %d\n", left,mid,right);			
		}
		if(flag == 0){
			mid = -1;
		}
		return mid ;
	}

	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		int i;
		int size = scr.nextInt();
		int arr[] = new int[size];
		int item = scr.nextInt();
		for(i=0;i<size;i++)
			arr[i] = scr.nextInt();
		int index = bsearch(arr,size,item)+1;
		System.out.println(index);

	}
}