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

    public void printArray(int[] arr, int n){
    	for(int i=0;i<n;i++)
    		System.out.printf("%d ",arr[i]) ; 
    	System.out.printf("\n") ; 
    }

    public void backtrack(List<List<Integer>> arrlist, List<Integer> list, int n, int start){       			
		for(int i=start; i<n-1; i++){
			for(int j=start+1;j<n;j++){
				swap(list,i,j) ;
				backtrack(arrlist,list,n,i+1) ;
				System.out.println(list) ; 
				arrlist.add(list) ; 
				swap(list,i,j) ; 
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