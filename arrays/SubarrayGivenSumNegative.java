/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

If sum taken from 0th index to i = a and j = b.
If b-a = k => we are done or b-k = a => we are done. 
Thus we use hashmap to store the previous sums.  
*/

import java.io.* ;
import java.util.* ;

public class SubarrayGivenSumNegative{
	public int subarraySum(int[] nums, int k) {
        int n = nums.length ;
        int count = 0 ; 
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
        int i ;
        int sum = 0;
        map.put(0,0) ;
        for(i=0;i<n;i++){
            sum += nums[i] ;
            if(map.containsKey(sum-k)){
                map.put(sum-k,map.get(sum-k)+1) ;
            }
            if(!map.containsKey(sum))
                map.put(sum,0) ; 
        }
        Set keyset = map.keySet() ;
        Iterator<Integer> iter = keyset.iterator() ;
        while(iter.hasNext()){
            int x = iter.next() ;
            int val = map.get(x) ;
            System.out.println(val) ; 
            count += (val*(val+1))/2 ;
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
