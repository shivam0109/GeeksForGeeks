//You are given a list of n-1 integers and these integers are in the range of 1 to n. 
//There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

// Find sum of 1 to n = n(n+1)/2. Subtract the sum of array from this number.

import java.util.* ;
import java.io.* ;

public class array5{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j;
		for(j=0;j<ntest;j++){
			int i; 
			int size = scr.nextInt();
			int arr[] = new int[size];
			int sum = 0;
			for(i=0;i<size-1;i++){
				arr[i] = scr.nextInt();
				sum = sum + arr[i];
			}
			int rsum = (size*(size+1))/2 ;
			System.out.println(rsum-sum);
		}
	} 
}
