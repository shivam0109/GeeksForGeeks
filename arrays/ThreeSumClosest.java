/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

import java.io.* ;
import java.util.* ;

public class ThreeSumClosest{
	public int threeSumClosest(int[] arr, int target) {
        int n = arr.length ;
        Arrays.sort(arr) ;
        int i = 0;
        boolean flag = false ;
        int minDiff = Integer.MAX_VALUE ;
        for(i=0;i<n-2;i++){
            int low = i+1 ;
            int high = n-1 ;
            int reqSum = target-arr[i] ;
            while(low<high){
                int currDiff = reqSum-arr[low]-arr[high] ;
                System.out.println( "i: " + i + " left: " + low + " right: " + high + " " + currDiff + " " + minDiff) ;
                if(Math.abs(currDiff)<Math.abs(minDiff)){
                    minDiff = currDiff ;
                }
                if(arr[low]+arr[high]==reqSum){
                    minDiff = 0 ;
                    flag = true ;
                    break ; 
                }
                if(arr[low]+arr[high]>reqSum)
                    high-- ;
                else
                    low++ ;                
            }
            if(flag)
                break ;
        }
        //System.out.println(minDiff) ; 
        return target-minDiff ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- >0){
    		int n = scr.nextInt() ;
    		int i = 0 ;
    		int arr[] = new int[n] ;
    		ThreeSumClosest ts = new ThreeSumClosest() ;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		int target = scr.nextInt() ;
    		System.out.println(ts.threeSumClosest(arr,target)) ;
    	}
    }
}