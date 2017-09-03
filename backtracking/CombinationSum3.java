/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
*/

import java.io.* ;
import java.util.* ;

public class CombinationSum3{
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
		List<Integer> p = new ArrayList<Integer>() ; 
		backtrack(p, n, k, 1, arrlist) ;
		return arrlist ;   	   
    }
    public void backtrack(List<Integer> list, int sum, int k, int start, List<List<Integer>> arrlist){
    	if(sum<0 || list.size()>k)
    		return ; 
    	else if(sum==0 && list.size()==k){
    		List<Integer> list2 = new ArrayList<Integer>(list) ; 
    		arrlist.add(list2) ;
    	} 
    	else{
    		for(int i=start ; i<=9 ; i++){
    			list.add(i) ; 
    			backtrack(list,sum-i,k,i+1,arrlist) ; 
    			list.remove(list.size()-1) ; 
    		}
    	}
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ; 
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int k = scr.nextInt() ;
    		CombinationSum3 cs3 = new CombinationSum3() ;
    		System.out.println(cs3.combinationSum3(k,n)) ; 
    	}
    }
}