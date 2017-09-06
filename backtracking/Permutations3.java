/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
Sort the array "int[] nums" to make sure we can skip the same value.
when a number has the same value with its previous, we can use this number only if his previous is used

*/

import java.io.* ;
import java.util.* ;

public class Permutations3{
	public List<List<Integer>> permuteUnique(int[] nums) {
		int n = nums.length ;
		int i ;
		if(n==0)
			return new ArrayList<List<Integer>>() ;
		Arrays.sort(nums) ; 
		boolean used[] = new boolean[n] ; 
		List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ; 
		List<Integer> list = new ArrayList<Integer>() ;
        backtrack(arrlist,list,n,nums,used) ; 
		return arrlist ;
    }
    public void backtrack(List<List<Integer>> arrlist, List<Integer> list, int n, int nums[], boolean[] used){
    	if(list.size()==n){
    		List<Integer> list2 = new ArrayList<Integer>(list) ; 
    		arrlist.add(list2) ; 
    	}
    	else{
    		for(int i=0; i<n ; i++){
                if(used[i])
                    continue ; 
    			if(i>=1 && nums[i-1]==nums[i] && !used[i-1])
    				continue ; 
    			used[i] = true ;
                list.add(nums[i]) ; 
    			backtrack(arrlist,list,n,nums,used) ; 
    			used[i] = false ; 
                list.remove(list.size()-1) ; 
    		}
    	}
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-->0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ; 
    		for(int i=0; i<n ;i++)
    			arr[i] = scr.nextInt() ;
    		Permutations3 p = new Permutations3() ;
    		List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ; 
    		arrlist = p.permuteUnique(arr) ; 
    		System.out.println(arrlist) ; 
    	}
    }
}