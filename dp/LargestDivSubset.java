/*
Given a set of distinct positive integers, 
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.
*/ 

import java.io.* ;
import java.util.* ;

public class LargestDivSubset{
	public void printArray(int arr[], int n){
        for(int i=0;i<n;i++)
            System.out.printf("%d ",arr[i]) ;
        System.out.printf("\n") ;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length ;
        if(n==0)
            return new ArrayList<Integer>() ;
        if(n==1){
            List<Integer> oneList = new ArrayList<Integer>() ;
            oneList.add(nums[0]) ;
            return oneList ; 
        }
        int i,j ;
        int dp[] = new int[n] ;
        int index[] = new int[n] ;
        Arrays.fill(dp,1) ;
        int max = 0 ;
        int maxIndex = 0 ;
        Arrays.sort(nums) ;
        for(i=0;i<n;i++)
            index[i] = i ;
        
        for(i=1;i<n;i++){
            for(j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1 ;
                    index[i] = j ;
                }
            }
            if(max<dp[i]){
                max = dp[i] ;
                maxIndex = i ;
            }
        }
        //printArray(dp,n) ;
        //printArray(index,n) ;
        int curr = max ;
        int currIndex = maxIndex ;
        List<Integer> list = new ArrayList<Integer>() ;
        while(curr>0){
            list.add(nums[currIndex]) ;
            currIndex = index[currIndex] ;
            curr-- ;
        }
        Collections.reverse(list) ;
        return list ;
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		int i ;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		LargestDivSubset lds = new LargestDivSubset() ;
    		List<Integer> ans = new ArrayList<Integer>() ;
    		ans = lds.largestDivisibleSubset(arr) ; 
    		for(i=0;i<ans.size();i++)
    			System.out.printf("%d ",ans.get(i)) ;
    		System.out.printf("\n") ;
    	}
    }
}