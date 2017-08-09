/*
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
*/

import java.io.* ;
import java.util.* ;

public class SubarrayGivenSum{
	public static int[] getIndices(int arr[], int n, int k){
        int ans[] = new int[2] ;
        if(n==1){
            if(arr[0]==k){
                ans[0] = 1; 
                ans[1] = 1;
                return ans ;
            }
        }
        int i = 0 ;
        int j = 0 ;
        ans[0] = -1 ;
        ans[1] = -1 ;
        int currSum = arr[0] ;
        while(j<n){
        	System.out.println("i: " + i + " j: " + j) ;
            if(currSum==k){
                ans[0] = i+1;
                ans[1] = j+1;
                break ;
            }
            else if(currSum<k){
                j++ ;
                if(j<n)
                    currSum += arr[j] ; 
            }
            else{
                currSum -= arr[i] ; 
                i++ ;
            }        
        }
        return ans ; 
    }
	public static void main (String[] args) {
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
		    int n = scr.nextInt() ;
		    int k = scr.nextInt() ;
		    int i,j ;
		    int arr[] = new int[n] ;
		    for(i=0;i<n;i++)
		        arr[i] = scr.nextInt() ;
            int ans[] = new int[2] ;
            ans = getIndices(arr,n,k) ; 
            for(i=0;i<2;i++)
                System.out.printf("%d ",ans[i]) ;
            System.out.printf("\n") ;
 		}   
	}
}
