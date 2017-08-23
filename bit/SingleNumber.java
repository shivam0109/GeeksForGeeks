/*
Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

import java.io.* ;
import java.util.* ;

public class SingleNumber{
	public int singleNumber(int[] arr) {
        int n = arr.length ;
        int i,j;
        int x = 1;
        int ans = 0;
        for(i=0;i<32;i++){
            x = 1 << i ;
            int sum = 0 ;
            for(j=0;j<n;j++){
                //find set bits. sum contains the count of set bits.  
                if((arr[j] & x) == x)
                    sum++ ;
            }
            //bits with sum%3!=0 are the bits of answer. 
            if(sum%3!=0)
                ans = ans|x ; 
        }  
        return ans ; 
    }
    public static void main(String[] args){
    	int[] arr = new int[] {4,4,4,5,6,5,7,5,6,6} ; 
    	SingleNumber sm = new SingleNumber() ;
    	System.out.println(sm.singleNumber(arr)) ; 
    }
}