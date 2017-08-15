/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

*/

import java.io.* ;
import java.util.* ;

public class RemoveElement{
	public int removeElement(int[] nums, int val) {
        int n = nums.length ;
        if(n==0 || n==1 && nums[0]!=val)
            return n ; 
        int i ; 
        int count = 0 ; 
        for(i=0;i<n;i++){
            if(nums[i]!=val){
                nums[count] = nums[i] ;
                count++ ;
            }
        }
        return count ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
	    	int n = scr.nextInt() ;
	    	int arr[] = new int[n] ;
	    	int i ;
	    	for(i=0;i<n;i++)
	    		arr[i] = scr.nextInt() ;
	    	int val = scr.nextInt() ;
	    	RemoveElement rem = new RemoveElement() ;
	    	System.out.println(rem.removeElement(arr,val)) ; 
    	}
    }
}