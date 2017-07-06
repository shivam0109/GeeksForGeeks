//Given two sorted arrays. There is only 1 difference between the arrays. First array has one element extra added in between. 
//Find the index of the extra element.

import java.io.* ;
import java.util.* ;

public class FindExtraIndex{
	static int findExtra(int a[], int b[], int left, int right){
		if(left<=right){
			int mid = (left+right)/2 ;
			if(mid==0 && a[mid]!=b[mid])
				return mid; 
			if(mid>0 && a[mid]!=b[mid] && a[mid-1]==b[mid-1])
				return mid;
			if(mid>0 && a[mid]!=b[mid] && a[mid-1]!=b[mid-1])
				return findExtra(a,b,left,mid-1) ; 
			if(a[mid]==b[mid])
				return findExtra(a,b,mid+1,right) ;
		}
		return -1;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt();
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt();
			int a[] = new int[n] ;
			int b[] = new int[n-1] ;
 			for(i=0;i<n;i++)
 				a[i] = scr.nextInt();
 			for(i=0;i<n-1;i++)
 				b[i] = scr.nextInt();
 			int ans = findExtra(a,b,0,n-2);
 			if(ans!=-1)
 				System.out.println(ans) ;
 			else
 				System.out.println(n-1) ;
		}
	}
}