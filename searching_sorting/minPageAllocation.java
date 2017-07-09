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
	static boolean isFeasible(int arr[], int n, int m, int soln){
		int student = 1;
		int currSum = 0;
		int i;
		for(i=0;i<n;i++){
			if(arr[i]>soln)
				return false ;
		
			if(currSum + arr[i] > soln){
				student++ ;
				currSum = arr[i] ;
				if(student>m)
					return false;
			}
			else
				currSum += arr[i] ; 
		}
		return true ; 
	}
	static int findPages(int arr[], int n, int m){
		int min = 0 ;
		int max = 0;
		int i;
		if(n<m)
			return -1 ;
		for(i=0;i<n;i++)
			max += arr[i] ;
		int result = Integer.MAX_VALUE ;
		while(min<=max){
			int mid = (min+max)/2 ;
			if(isFeasible(arr,n,m,mid)){
				result = Math.min(result,mid) ;
				max = mid-1 ;
			}
			else 
				min = mid+1; 
		}
		return result ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int numStudents = scr.nextInt() ;
			int arr[] = new int[numStudents] ;
			for(i=0;i<numStudents;i++)
				arr[i] = scr.nextInt() ;
			int m = scr.nextInt() ;
			int ans = findPages(arr,numStudents,m) ;
			System.out.println(ans) ;
		}
	}
} 