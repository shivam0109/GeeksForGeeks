/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

*/

/*
If for an element x, an element <=x exists on it's left side and >=x exists on it's right side, we dont need to check for x.
So, we need to create a min array and max array and traverse them simulataneously.  
Now, if we have min[i] <= max[j],currdiff = j-i, do j++ 
else do i++ 
*/

import java.io.* ;
import java.util.* ;

public class MaxDistance{
	public int maximumGap(ArrayList<Integer> a){
		if(a==null || a.size()==0)
			return -1 ;
		int n = a.size() ;
		int runMax[] = new int[n] ;
		int runMin[] = new int[n] ; 
		int i,j ;
		runMin[0] = a.get(0) ;
		for(i=1;i<n;i++)
			runMin[i] = Math.min(runMin[i-1],a.get(i)) ;
		runMax[n-1] = a.get(n-1) ;
		for(i=n-2;i>=0;i--)
			runMax[i] = Math.max(runMax[i+1],a.get(i)) ;
		i = 0 ;
		j = 0 ;
		int max = 0 ;
		while(i<n && j<n){
			if(runMin[i]<=runMax[j]){
				max = Math.max(max,j-i) ;
				j++ ;
			}
			else
				i++ ;
		}
		return max ; 		
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-->0){
			int n = scr.nextInt() ;
			ArrayList<Integer> list = new ArrayList<Integer>() ;
			for(int i=0 ; i<n ; i++)
				list.add(scr.nextInt()) ;
			MaxDistance md = new MaxDistance() ;
			System.out.println(md.maximumGap(list)) ; 
 		}
	}
}