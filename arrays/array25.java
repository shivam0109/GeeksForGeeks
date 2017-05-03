//find the first and last occurences of an element in a sorted array 

import java.io.* ;
import java.util.* ;

public class array25{
	static int first = -1;
	static int last = -1;
	static void fbsearch(int arr[], int left, int right, int x){
		int mid = (left+right)/2 ;
		if(left<=right){
			if(arr[mid]==x){
				first = mid;
				//System.out.println("mid: "+ mid + "first: " + first + " ");
				fbsearch(arr,left,mid-1,x);
			}
			else if(arr[mid]>x)
				fbsearch(arr,left,mid-1,x);
			else
				fbsearch(arr,mid+1,right,x);
		}
	}
	static void lbsearch(int arr[], int left, int right, int x){
		int mid = (left+right)/2 ;
		if(left<=right){
			if(arr[mid]==x){
				last = mid;
				//System.out.println("mid: "+ mid + "first: " + first + " ");
				lbsearch(arr,mid+1,right,x);
			}
			else if(arr[mid]>x)
				lbsearch(arr,left,mid-1,x);
			else
				lbsearch(arr,mid+1,right,x);
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];			
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int x = scr.nextInt();
			fbsearch(arr,0,n-1,x);
			lbsearch(arr,0,n-1,x);
			System.out.printf("%d %d",first,last);
			System.out.printf("\n");
		}
	}
}