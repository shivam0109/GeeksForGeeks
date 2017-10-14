//Given number of pages in n different books and m students. 
//The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. 
//The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

//The idea is to first find any feasible solution and then apply binary search for optimal solution. 
//If a feasible solution exists, we update min by min+1. 

//A feasible solution satisfies all the conditions.
//Every student gets atleast 1 book.
//The number of students required should be not more than the given number of students at any time.

import java.io.* ;
import java.util.* ;

public class minPageAllocation{
	// static boolean isFeasible(int arr[], int n, int m, int soln){
	// 	int student = 1;
	// 	int currSum = 0;
	// 	int i;
	// 	for(i=0;i<n;i++){
	// 		if(arr[i]>soln)
	// 			return false ;
		
	// 		if(currSum + arr[i] > soln){
	// 			student++ ;
	// 			currSum = arr[i] ;
	// 			if(student>m)
	// 				return false;
	// 		}
	// 		else
	// 			currSum += arr[i] ; 
	// 	}
	// 	return true ; 
	// }
	// static int findPages(int arr[], int n, int m){
	// 	int min = 0 ;
	// 	int max = 0;
	// 	int i;
	// 	if(n<m)
	// 		return -1 ;
	// 	for(i=0;i<n;i++)
	// 		max += arr[i] ;
	// 	int result = Integer.MAX_VALUE ;
	// 	while(min<=max){
	// 		int mid = (min+max)/2 ;
	// 		if(isFeasible(arr,n,m,mid)){
	// 			result = Math.min(result,mid) ;
	// 			max = mid-1 ;
	// 		}
	// 		else 
	// 			min = mid+1; 
	// 	}
	// 	return result ; 
	// }
	public static boolean isFeasible(int arr[], int num, int n, int k){
		int count = 1 ;
		int i;
		int sum = 0 ;
		for(i=0;i<n;i++){
			if(arr[i]>num)
				return false ;
		}
		for(i=0;i<n;i++){
			sum += arr[i] ;
			if(sum>num){
				sum = arr[i] ;
				count++ ;
				if(count>k)
					return false ;
			}
		}
		return true ; 
	}
	public static int minPages(int arr[], int k){
		int n = arr.length ;
		if(n==0)
			return 0 ;
		int min = arr[0] ;
		int max = arr[0] ;
		int i;
		for(i=1;i<n;i++)
			max += arr[i] ;
		int start = min ;
		int end = max ;
		int mid = -1; 
		while(start<end){
			System.out.println("start: " + start + " end: " +end) ;
			mid = start + (end-start)/2 ;
			if(isFeasible(arr,mid,n,k)){
				end = mid ;
			}
			else
				start = mid+1 ;
		}
		return start ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
1		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int numBooks = scr.nextInt() ;
			int arr[] = new int[numBooks] ;
			for(i=0;i<numBooks;i++)
				arr[i] = scr.nextInt() ;
			int k = scr.nextInt() ;
			int ans = minPages(arr,k) ;
			System.out.println(ans) ;
		}
	}
} 