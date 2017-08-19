/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

If sum taken from 0th index to i = a and j = b.
If b-a = k => we are done or b-k = a => we are done. 
Thus we use hashmap to store the previous sums. 		 

store the data in the form: (sum_i, no. of occurences of sum_i).
If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. 
Further, for every sum encountered, we also determine the number of times the sum-k has occured already, 
since it will determine the number of times a subarray with sum k has occured upto the current index. 
We increment the countcount by the same amount.
*/

import java.io.* ;
import java.util.* ;

public class SubarrayGivenSumNegative{
    public int subarraySum(int[] nums, int k){
        int n = nums.length ;
        if(n==0)
            return 0 ;
        if(n==1 && nums[0]!=k)
            return 0 ;
        if(n==1 && nums[0]==k)
            return 1 ; 
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
        int currSum = 0 ;
        int i ;
        int count = 0 ;
        map.put(0,1) ; 
        for(i=0;i<n;i++){
            currSum += nums[i] ; 
            if(map.containsKey(currSum-k)){
                count += map.get(currSum-k) ;
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1) ;  
        }
        return count ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ; 
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
            int k = scr.nextInt() ;
    		SubarrayGivenSumNegative sgiven = new SubarrayGivenSumNegative() ;
    		int i;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		int ans = sgiven.subarraySum(arr,k) ; 
    		System.out.println(ans) ; 
    	}
    }
}
