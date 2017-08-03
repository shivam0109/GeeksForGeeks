/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.
*/

import java.io.* ;
import java.util.* ;

public class ThreeSum{
	public List<List<Integer>> findPair(int[] arr, int n, int start, int target, List<List<Integer>> ansList){
        int left = start+1 ;
        int right = n-1 ;
        while(left<right){
        	List<Integer> list = new ArrayList<Integer>() ;
    	    //System.out.println("left: " +left + " right: " + right) ;
            System.out.println("target: " + target + " left " + arr[left] + " right " + arr[right]) ; 
            int sum = arr[left] + arr[right] ;
            if(sum==target){
        		list.add(-target) ; 
            	list.add(arr[left]) ;
            	list.add(arr[right]) ; 
            	ansList.add(list) ;    
                while(left<right && arr[left]==arr[left+1]) 
                	left++ ;
                while(left<right && arr[right]==arr[right-1])
                	right-- ;  
                left++ ;
                right-- ;
            }
            else if(sum<target)
                left++ ;
            else
                right-- ;                
        }
        return ansList ; 
    }
    public void printArray(int[] arr, int n){
    	int i;
    	for(i=0;i<n;i++)
    		System.out.printf("%d ", arr[i]) ;
    	System.out.printf("\n") ; 
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length ;
        Arrays.sort(nums) ;
        printArray(nums,n) ;
        int i = 0;
        List<List<Integer>> list = new ArrayList<List<Integer>>() ;
        for(i=0;i<n;i++){
        	//System.out.println("ram") ;
        	if(i==0 || i>0 && nums[i]!=nums[i-1]){
	            list = findPair(nums,n,i,-nums[i],list) ; 
	        }
        }
        return list ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- >0){
    		int n = scr.nextInt() ;
    		int i = 0 ;
    		int arr[] = new int[n] ;
    		ThreeSum ts = new ThreeSum() ;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		List<List<Integer>> list = new ArrayList<List<Integer>>() ;
    		list = ts.threeSum(arr) ; 
    		for(i=0;i<list.size();i++)
    			System.out.println(list.get(i)) ;
    	}
    }
}