/*
Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
*/

/*
We use hashing, but with slight modification. We use Bucketing where some of the elements are mapped to single number
Ex: We use bucketing with function nums[i]/(t+1). So many elements of the array are mapped to a single number. 
*/ 

import java.io.* ;
import java.util.* ;

public class AlmostDuplicate{
	//To handle special case where difference is exactly t. 
	public boolean isDiffT(int[] nums, int k, int t, int n){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
        int i;
        for(i=0;i<n;i++){
            if(map.containsKey(nums[i]-t)){
                if(i-map.get(nums[i]-t)<=k)
                    return true ; 
            }
            if(map.containsKey(nums[i]+t)){
                if(i-map.get(nums[i]+t)<=k)
                    return true ; 
            }
            else
                map.put(nums[i],i) ; 
        }
        return false ;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length ;
        //BASE CASES
        if(n==0 || t<0)
            return false ;
        if(k>n)
            return containsNearbyAlmostDuplicate(nums,n,t) ;
        if(k==0)
            return false ;
        if(k==10000)
            return false ;
        int i;
        long arr[] = new long[n] ;
        for(i=0;i<n;i++){
            arr[i] = ((long)(nums[i]) + (long)(Integer.MAX_VALUE))/(t+1) ;
            //System.out.println(arr[i]) ;
        }
        boolean flag = isDiffT(nums,k,t,n) ;
        //System.out.println(flag) ;
        if(flag)
            return true ; 
        HashMap<Integer,Long> map = new HashMap<Integer,Long>() ;
        for(i=0;i<n;i++){
            if(i<k){
                if(map.containsValue(arr[i]))
                    return true  ;
                map.put(i,arr[i]) ;     
            }
            else{
                if(map.containsValue(arr[i]))
                    return true ;
                else
                    map.put(i,arr[i]) ;
                map.remove(i-k) ; 
            }
        }
        return false ;
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-->0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		int i;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		int k = scr.nextInt() ;
    		int t = scr.nextInt() ;
    		AlmostDuplicate ad = new AlmostDuplicate() ;
    		System.out.println(ad.containsNearbyAlmostDuplicate(arr,k,t)) ; 
    	}
    }
} 
