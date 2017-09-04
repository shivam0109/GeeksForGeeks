/*
Given a collection of distinct numbers, return all possible permutations.
*/

import java.io.* ;
import java.util.* ;

public class Permutations2{
	public List<List<Integer>> permute(int[] nums) {
    	int n = nums.length ;
    	List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
    	List<Integer> list = new ArrayList<Integer>() ;
    	backtrack(list,arrlist,nums,n) ;
    	return arrlist ;     
    }
    
    public void backtrack(List<Integer> list, List<List<Integer>> arrlist, int arr[], int n){
    	if(list.size()==n){
    		List<Integer> list2 = new ArrayList<Integer>(list) ; 
    		arrlist.add(list2) ; 
    	}
    	else{
    		for(int i=0;i<n;i++){
				if(list.contains(arr[i])) 
					continue ;
    			list.add(arr[i]) ;
    			backtrack(list,arrlist,arr,n) ;
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
    		for(int i=0; i<n ;i++)
    			arr[i] = scr.nextInt() ;
    		Permutations2 p = new Permutations2() ;
    		System.out.println(p.permute(arr)) ;
    	}
    }

}