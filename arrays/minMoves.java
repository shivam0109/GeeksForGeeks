//Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, 
//where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

import java.io.* ;
import java.util.* ;

public class minMoves{
	static int minSum(int[] arr, int n){
        int i;
        int moves1 = 0;
        int moves2 = 0;
        for(i=0;i<n;i++)
            moves1 += Math.abs(arr[i]-arr[n/2]) ; 
        if(n%2==1)
            return moves1;
        else{
            for(i=0;i<n;i++)
            moves2 += Math.abs(arr[i]-arr[n/2 - 1]) ;
            return Math.min(moves1,moves2) ;
        }
    }
    static int minMoves2(int[] nums) {
        int n = nums.length ; 
        Arrays.sort(nums) ;
        int ans = minSum(nums,n) ;
        return ans ;
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in);
    	int ntest = scr.nextInt() ;
    	int i,j ;
    	for(j=0;j<ntest;j++){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		int ans = minMoves2(arr) ; 
    		System.out.println(ans) ;
    	}
    }
}