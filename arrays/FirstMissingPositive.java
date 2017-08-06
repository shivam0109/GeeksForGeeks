/*
Given an unsorted integer array, find the first missing positive integer.
*/

import java.io.* ;
import java.util.* ;

public class FirstMissingPositive{
	public int[] separateNegative(int[] arr, int n){
        int count = 0;
        int i; 
        for(i=0;i<n;i++){
            if(arr[i]<=0)
                count++ ;
        }
        i = 0; 
        int j = 0;
        while(i<count && j<n){
            if(arr[j]>0)
                j++ ;
            else{
                int temp = arr[i] ;
                arr[i] = arr[j] ;
                arr[j] = temp ;
                i++ ;
                j++ ;
            }
        }
        return arr ; 
    }

    public void printArray(int[] arr, int n){
    	int i = 0;
    	while(i<n){
    		System.out.printf("%d ",arr[i]) ;
    		i++ ;
    	}
    	System.out.printf("\n") ;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length ; 
        nums = separateNegative(nums,n) ; 
        printArray(nums,n) ;
        int i = 0 ;
        if(n==0)
            return 1 ; 
        if(n==1 && nums[0]>1)
        	return 1 ;

        while(nums[i]<=0 && i<n)
            i++ ;
        int count = i ;
        int size = n-count ; 
        System.out.println("count: " + count + " size: " + size)  ; 

        for(i=count;i<n;i++){
            if(Math.abs(nums[i])<=size){
            	System.out.println("i: " + i) ;

                // if(nums[Math.abs(nums[i])+count-1] < 0)
                //     nums[Math.abs(nums[i])+count-1] = nums[Math.abs(nums[i])+count-1]-1 ;
                if(nums[Math.abs(nums[i])+count-1]>0)
                    nums[Math.abs(nums[i])+count-1] = -nums[Math.abs(nums[i])+count-1] ; 
            }
        }

        for(i=count;i<n;i++){
            if(nums[i]>0){
                break ;
            }
        }
        
        printArray(nums,n) ;

        System.out.println(i) ;
        
        if(i==n)
            return size+1 ;
        else
            return i-count+1 ; 
    }

    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int i ;
    		int arr[] = new int[n] ;
    		FirstMissingPositive mp = new FirstMissingPositive() ;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		System.out.println(mp.firstMissingPositive(arr)) ;
    	}
    }
}