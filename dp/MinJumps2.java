/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Time : O(n)

*/

/*
Use Greedy Approach for O(n) solution. 
maxReach -> stores the max index that can be reached from ith index 
currEnd -> used to see if maxReach has been reached 
if at an index i, if maxReach <= i => we cannot go further. return -1. 
every time i reaches currEnd check if it is possible to move further, if yes, update currEnd to maxReach. 
*/

import java.io.* ;
import java.util.* ;

public class MinJumps2{
	public int jump(int[] A) {        
        int n = A.length ;
        if(n==0 || n==1)
            return 0;
        if(A[0]==0)
            return -1 ;
        //max index that can be reached. 
        int maxReach = 0;
        //used to see if we have reached the current end. 
        int currEnd = 0;
        //stores the answer. 
        int jumps = 0;
        int i;
        for(i=0;i<n-1;i++){
            //update maxReach at each iteration. 
            maxReach = Math.max(maxReach,A[i]+i) ;
            if(i==currEnd){
                if(i>=maxReach)
                    return -1 ; 
                currEnd = maxReach ;
                jumps++ ;
            }
        }
        return jumps ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		for(int i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		MinJumps2 minJump = new MinJumps2() ;
    		System.out.println(minJump.jump(arr)) ; 
    	}
    }
}