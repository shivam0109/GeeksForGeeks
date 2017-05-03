//Maximum difference between two elements such that larger element appears after the smaller number. 
//O(n) time and O(1) space.

import java.io.* ;
import java.util.* ;

public class array18{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int diff = arr[1]-arr[0];
			int curr_sum = diff;
			int max_sum = diff;
			for(i=1;i<n-1;i++){
				diff = arr[i+1]-arr[i];
				if(curr_sum>0)
					curr_sum = curr_sum+diff;
				else
					curr_sum = diff;
				if(curr_sum>max_sum)
					max_sum = curr_sum;
			}
			if(max_sum<0)
				System.out.println(-1);
			else
				System.out.println(max_sum);
		}	
	}
}