/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/

/*
Similar to kadane's algo. Te only difference is max product at an index can also be made by using min of prev index. 
Time : O(n) Space : O(1) 
*/

import java.io.* ;
import java.util.* ;

public class MaxProductSubarray{
	public int maxProduct(int[] nums) {
        int n = nums.length ;
        if(n==0)
            return 0 ;
        if(n==1)
            return nums[0] ;
        int currMax = Math.max(nums[0],0) ;
        int currMin = Math.min(nums[0],0) ;
        int i;
        int max = -Integer.MAX_VALUE ;
        max = Math.max(max,currMax) ; 
        for(i=1;i<n;i++){
            int prevMax = currMax ; 
            currMax = Math.max(0,Math.max(currMax*nums[i],Math.max(nums[i],currMin*nums[i]))) ;
            currMin = Math.min(0,Math.min(prevMax*nums[i],Math.min(nums[i],currMin*nums[i]))) ;
            max = Math.max(currMax,max) ; 
        }
        return max; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		for(int i=0; i<n ;i++)
    			arr[i] = scr.nextInt() ;
    		MaxProductSubarray maxProd = new MaxProductSubarray() ;
    		System.out.println(maxProd.maxProduct(arr)) ; 
    	}
    }
}