/*
Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.
*/

import java.io.* ;
import java.util.* ;

public class CombinationSum4{
	static long totalCount = 0;
	public int combinationSum4(int[] nums, int target) {
		int n = nums.length ;
		if(n==0)
			return 0 ;
    	//Arrays.sort(nums) ; 
    	List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
    	List<Integer> list = new ArrayList<Integer>() ; 
    	long count1 = totalCount ; 
    	backtrack(arrlist,list,nums,n,target) ; 
    	//System.out.println(arrlist) ;
    	long count2 = totalCount ; 	
    	return  (int)(count2-count1) ; 
    }
    public void backtrack(List<List<Integer>> arrlist, List<Integer> list, int[] nums, int n, int target){
    	if(target<0)
    		return ; 
    	else if(target==0){
    		// List<Integer> list2 = new ArrayList<Integer>(list) ; 
    		// arrlist.add(list2) ;
    		//System.out.println(list) ;
    		totalCount++ ;   
    	}
    	else{
    		for(int i=0;i<n;i++){
    			list.add(nums[i]) ; 
    			backtrack(arrlist,list,nums,n,target-nums[i]) ;
    			list.remove(list.size()-1) ; 
    		}
    	}
    }
    public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ; 
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int k = scr.nextInt() ;
			CombinationSum4 csum4 = new CombinationSum4() ;
			System.out.println(csum4.combinationSum4(arr,k)) ;
			//System.out.println(totalCount) ; 
		}
	}

}