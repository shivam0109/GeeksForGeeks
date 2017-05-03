//Ceiling in a sorted array
//Use Binary Search to get an element just smaller or greater than given element. 

import java.io.* ;
import java.util.* ;

public class array20{
	static int[] binarysearch(int[] arr, int n, int x){
		int left = 0;
		int right = n-1;
		int mid = (left+right)/2 ;
		int val[] = new int[2];
		int flag = 0;
		while(left<=right){
			if(arr[mid]==x){
				flag = 1;
				break;
			}
			else if(arr[mid]>x){
				right = mid-1;
			}
			else
				left = mid+1;
			mid = (left+right)/2 ;
		}
		if(flag==0){
			val[0] = 0;
			val[1] = left;
		}
		else{
			val[0] = 1;
			val[1] = mid;
		}
		return val;
	}
	public static void main(String[] args){
		int flag=0;
		int n = 7;
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
		int val[] = binarysearch(arr,7,20);
		if(val[1]==n){
			if(arr[n-1]<20)
				flag = 1;;
		}
		if(flag == 0)
			System.out.println(val[1]);
		else
			System.out.println("ceil does not exist");
	}
}