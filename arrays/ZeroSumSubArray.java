//Given an array of both positive and negative numbers, the task is to find out the subarray whose sum is closest to 0.
//There can be multiple such subarrays, we need to output just 1 of them.

import java.io.* ;
import java.util.* ;

public class ZeroSumSubArray{
	
	static ArrayList<Map.Entry<Integer,Integer>> sortMap(HashMap<Integer,Integer> hmap){
		ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(hmap.entrySet()) ;

		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
				return a.getValue().compareTo(b.getValue()) ; 
			}
		}) ;

		return list ; 
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int sum = 0; 
			HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>() ;
			for(i=0;i<n;i++){
				sum += arr[i] ;
				hmap.put(i,sum) ; 
			}
			ArrayList<Map.Entry<Integer,Integer>> sortedList = new ArrayList<Map.Entry<Integer,Integer>>() ;
			sortedList = sortMap(hmap) ; 	
			
			int closestToZero = Integer.MAX_VALUE  ;
			int lower = 0;
			int upper = 0;
			System.out.println(sortedList) ;
			for(i=1;i<sortedList.size();i++){
				Map.Entry<Integer,Integer> curr = sortedList.get(i) ;
				Map.Entry<Integer,Integer> prev = sortedList.get(i-1) ;
				if(curr.getValue()-prev.getValue()<closestToZero){
					closestToZero = curr.getValue() - prev.getValue() ;
					lower = Math.min(curr.getKey(),prev.getKey())+1;
					upper = Math.max(curr.getKey(),prev.getKey()) ; 
				}
 			}
 			System.out.println("Closest to Zero: " + closestToZero) ;
 			System.out.println("Starting Index: " + lower) ;
 			System.out.println("Ending Index: " + upper) ;  
		}
	}
}