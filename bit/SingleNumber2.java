/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.
*/

/*
In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. 
Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, 
another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. 
XOR numbers in each group, we can find a number in either group.


*/

import java.io.* ;
import java.util.* ;

public class SingleNumber2{
	public int[] singleNumber(int[] nums) {
        int i ;
        int n = nums.length ;
        if(n==2)
            return nums; 
        int xor = nums[0] ;
        for(i=1;i<n;i++)
            xor = xor^nums[i] ;
        xor = xor&(-xor) ; 
        int arr[] = new int[2] ;
        for(i=0;i<n;i++){
            if((nums[i]&xor)==0)
                arr[0] ^= nums[i] ;
            else
                arr[1] ^= nums[i] ; 
        }
        return arr ;
    }
    public static void main(String[] args){
    	int[] arr = {1, 2, 1, 3, 2, 5} ;
    	SingleNumber2 sn2 = new SingleNumber2() ;
    	System.out.println(sn2.singleNumber(arr)) ; 
    }
}