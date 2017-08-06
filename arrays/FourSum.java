/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.
*/ 

import java.io.* ;
import java.util.* ;

public class FourSum{
	public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length ;
        int i,j;
        Arrays.sort(nums) ; 
        List<List<Integer>> retList = new ArrayList<List<Integer>>() ;
        for(i=0;i<n-3;i++){
            if(i==0 || i>0 && nums[i]!=nums[i-1]){
                for(j=i+1;j<n;j++){
                    if(j==i+1 || nums[j]!=nums[j-1]){
                        int lo = j+1 ;
                        int high = n-1 ;
                        //System.out.println("i " + i + " j " + j + " lo " + lo + " high " + high) ; 
                        while(lo<high){
                            int sum = nums[i] + nums[j] + nums[lo] + nums[high] ; 
                            List<Integer> list = new ArrayList<Integer>() ;
                            if(sum == target){
                                list.add(nums[i]) ;
                                list.add(nums[j]) ;
                                list.add(nums[lo]) ;
                                list.add(nums[high]) ;
                                retList.add(list) ; 
                                while(lo+1<n && nums[lo+1]==nums[lo])
                                    lo++ ;
                                while(high-1>=0 && nums[high-1]==nums[high])
                                    high-- ;
                                lo++ ;
                                high-- ;
                            }
                            else if(sum>target)
                                high-- ;
                            else
                                lo++ ;
                        }
                    }
                }
            }
        }
        return retList ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- >0){
    		int n = scr.nextInt() ;
    		int i = 0 ;
    		int arr[] = new int[n] ;
    		FourSum fs = new FourSum() ;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		int target = scr.nextInt() ;
    		List<List<Integer>> list = new ArrayList<List<Integer>>() ;
    		list = fs.fourSum(arr,target) ;  
    		for(i=0;i<list.size();i++)
    			System.out.println(list.get(i)) ;
    	}
    }
}
