/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
*/

import java.io.* ;
import java.util.* ;

public class Permutations3{
	public List<List<Integer>> permuteUnique(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ;
		int i ;
		int n = nums.length ;
		for(i=0;i<n;i++){
			if(map.containsKey(nums[i]))
				map.put(nums[i],map.get(nums[i])+1) ; 
			else
				map.put(nums[i],1) ; 
		}
		List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
		List<Integer> list = new ArrayList<Integer>() ;
		HashMap<List<Integer>,Integer> listMap = new HashMap<List<Integer>,Integer>() ;
		backtrack(map,listMap,list,n,nums) ;
		Iterator<List<Integer>> iter = listMap.keySet().iterator() ; 
		while(iter.hasNext())
			arrlist.add(iter.next()) ; 
		return arrlist ; 
    }
    public void backtrack(HashMap<Integer,Integer> map,HashMap<List<Integer>,Integer> listMap, List<Integer> list, int n, int[] nums){
    	int i ;
    	//System.out.println(list); 
    	if(list.size()==n){
    		List<Integer> list2 = new ArrayList<Integer>(list) ;
    		if(!listMap.containsKey(list2))
    			listMap.put(list2,1) ;  
    	}
    	else{
	    	for(i=0;i<n;i++){
	    		//System.out.println("i: "+ i) ;	 
	    		if(map.get(nums[i])==0)
	    			continue ; 
	    		list.add(nums[i]) ;
	    		map.put(nums[i],map.get(nums[i])-1) ;  
	    		backtrack(map,listMap,list,n,nums) ;
	    		list.remove(list.size()-1) ; 
	    		map.put(nums[i],map.get(nums[i])+1) ; 
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
    		Permutations3 p = new Permutations3() ;
    		List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
    		arrlist = p.permuteUnique(arr) ; 
    		System.out.println(p.permuteUnique(arr)) ;
    		System.out.println(arrlist.size()) ; 
    	}
    }
}