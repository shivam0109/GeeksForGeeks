/*
A sequence of number is called arithmetic if it consists of at least three elements and 
if the difference between any two consecutive elements is the same.
*/

/*
First Find the DP Solution. If a new element is added, how many slices can be made using that element is stored in dp array.
Now, to find total number of slices, sum upto that index.
The sum forms a patern of n(n+1)/2  
*/

import java.io.* ;
import java.util.* ;

public class ArithmeticSlices{
	public int numberOfArithmeticSlices(int[] A) {
        int n = A.length ;
        if(n==0 || n==1)
            return 0 ;
        int start = 0 ;
        int end = 1 ;
        int diff = A[end]-A[start] ;
        int i ;
        int maxLen = 0 ;
        int currLen = 0 ;
        int sum = 0 ;
        while(end<n-1){
            if(A[end+1]-A[end]==diff){
                currLen++ ;
                end++ ;
            }
            else{
                start = end ;
                end = end+1 ;
                diff = A[end]-A[start] ;
                sum += (currLen*(currLen+1))/2 ; 
                currLen = 0 ;
                //maxLen = Math.max(maxLen,currLen) ;
            }
        }
        if(currLen!=0)
            sum += (currLen*(currLen+1))/2 ; 
        return sum ; 
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
    		ArithmeticSlices as = new ArithmeticSlices() ;
    		System.out.println(as.numberOfArithmeticSlices(arr)) ; 
    	}
    }
}
