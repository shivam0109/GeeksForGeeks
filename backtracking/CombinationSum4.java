/*
Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.
*/

import java.io.* ;
import java.util.* ;

public class CombinationSum4{
	static int totalCount =  0 ; 
	public int factorial(int num){
		int ans = 1 ;
		int count = 1;
		while(count<=num){
			ans = ans*count ;
			count++ ;
		}
		return ans ; 
	}
	public int numPermutations(List<Integer> list){
		int n = list.size() ;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ; 
		int i ;
		for(i=0;i<n;i++){
			if(map.containsKey(list.get(i)))
				map.put(list.get(i),map.get(list.get(i))+1) ; 
			else
				map.put(list.get(i),1) ; 
		}
		Set keyset = map.keySet() ; 
		System.out.println("keyset: " + keyset) ; 
		Iterator<Integer> iter = keyset.iterator() ; 
		int factN = factorial(n) ; 
		int num ;
		int count = 0 ;
		while(iter.hasNext()){
			num = iter.next() ;
			count = map.get(num) ; 
			System.out.println("num: " + num + " count: " + count) ; 
			int factnum = factorial(count) ; 
			factN = factN/factnum ;  
		}
		return factN ; 
	}
	public int combinationSum4(int[] nums, int target) {
    	List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
    	List<Integer> list = new ArrayList<Integer>() ;
    	int count1 = totalCount ; 
    	backtrack(arrlist,list,nums,target,0) ;
    	int count2 = totalCount ; 
    	return count2-count1 ; 
    }
    public void backtrack(List<List<Integer>> arrlist, List<Integer> list, int[] arr, int sum, int start){
    	if(sum<0)
    		return ;
    	else if(sum==0){
    		List<Integer> p = new ArrayList<Integer>(list) ;
    		arrlist.add(p) ;
    		totalCount += numPermutations(p) ;
    		//System.out.println(totalCount) ;   
    	}
    	else{
    		for(int i=start; i<arr.length ; i++){
    			list.add(arr[i]) ; 
    			backtrack(arrlist,list,arr,sum-arr[i],i) ; 
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