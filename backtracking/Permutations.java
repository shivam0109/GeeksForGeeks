/*
Given a collection of distinct numbers, return all possible permutations.
*/

import java.io.* ;
import java.util.* ;

public class Permutations{
	public List<List<Integer>> permute(int[] nums) {
    	int n = nums.length ;
    	List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
    	List<Integer> list = new ArrayList<Integer>() ;
    	for(int i=0 ; i<n ;i++)
    		list.add(nums[i]) ;  
    	backtrack(arrlist,list,n,0) ;
    	return arrlist ;     
    }	
    
	public void swap(List<Integer> list, int i, int j){
    	int temp = list.get(i) ;
    	list.set(i,list.get(j)) ; 
    	list.set(j,temp) ; 
    }

    public void backtrack(List<List<Integer>> arrlist, List<Integer> list, int n, int start){       			
		if(start==n-1){
            System.out.println(list) ;
            List<Integer> list2 = new ArrayList<Integer>(list) ;  
            arrlist.add(list2) ; 
        }
        else{
            for(int i=start;i<n;i++){
                swap(list,start,i) ;
                backtrack(arrlist,list,n,start+1) ;
                swap(list,start,i) ;  
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
    		Permutations p = new Permutations() ;
    		p.permute(arr) ; 
    	}
    }
}