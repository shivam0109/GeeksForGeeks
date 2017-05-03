//Count the number of occurences in a sorted array in O(lgn). 

import java.io.* ;
import java.util.* ;

public class array24{
	static int count = 0;
	static void bsearch(int arr[] ,int left, int right, int x){
		int mid = (left+right)/2 ;
		if(left<=right){
			if(arr[mid]==x){
				count++;
				//System.out.println(count);
				bsearch(arr,left,mid-1,x);
				bsearch(arr,mid+1,right,x);
			}
			else if(arr[mid]<x)
				bsearch(arr,mid+1,right,x);
			else
				bsearch(arr,left,mid-1,x);
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,k;
		int lcount = 0;
		int ncount = 0;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int x = scr.nextInt();
			int arr[] = new int[n];
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			bsearch(arr,0,n-1,x);
			ncount = count-lcount;
			lcount = count ;
			if(ncount == 0)
				System.out.println(-1);
			else
				System.out.println(ncount);
		}			
	}
}


