//Given an array of positive integers. All numbers occur even number of times 
//except one number which occurs odd number of times. Find the number in O(n) time & constant space.

import java.util.* ; 
import java.io.* ;

public class array3{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int arr[] = new int[size];
			int i;
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt();
			}
			int ans = arr[0];
			for(i=1;i<size;i++){
				ans = ans ^ arr[i];
			}
			System.out.println(ans);
		}
	}
}