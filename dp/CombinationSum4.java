/*
Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.
Note that different sequences are counted as different combinations.
*/

/*
Suppose we want to make target i. Assume we need to take one element from the array to make this target. 
Now, we traverse the given array, if i-nums[j] is present in the given array, we can make the combination in the 
same number of ways as we made combination for j. Iterate over all j to find the total number of combinations. 
*/

import java.io.* ;
import java.util.* ;

public class CombinationSum4{
	public int combinationSum4(int[] nums, int target) {
        int n = nums.length ;
        if(target==0)
            return 1; 
        if(n==0)
            return 0 ; 
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>() ; 
        int i,j ;
        map.put(0,1) ; 
        for(i=0;i<n;i++)
            map.put(nums[i],1) ;
        int dp[] = new int[target+1] ; 
        dp[0] = 1 ;
        for(i=1;i<target+1;i++){
            for(j=0;j<i;j++){
                if(map.containsKey(i-j))
                    dp[i] += dp[j] ;    
            }
        }
        return dp[target] ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		for(int i=0; i<n; i++)
    			arr[i] = scr.nextInt() ; 
    		int target = scr.nextInt() ;
    		CombinationSum4 cs4 = new CombinationSum4() ;
    		System.out.println(cs4.combinationSum4(arr,target)) ; 
    	}
    }
}