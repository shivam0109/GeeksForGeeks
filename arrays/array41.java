//There are N ticket sellers each of whom has a certain amount of tickets. 
//The price of a ticket is the number of tickets remaining with the ticket seller. 
// They want to sell a total of K tickets. 
// We need to find the maximum amount they can earn by selling K tickets.


//Idea is to do hashing (kind of) where another array stores the frequency of elements in the actual array.
//Then update the maximum and the frequency array iteratively. 

import java.io.* ;
import java.util.* ;

public class array41{
	static int getMaxValue(int[] arr, int max, int k){
		int ans = 0;
		int i ;
		for(i=0;i<k;i++){
			ans += max ;
			arr[max-1] += 1 ;
			arr[max] -= 1;
			if(arr[max]==0)
				max = max-1; 
		}
		return ans ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt();
		int i,j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt() ;
			int arr[] = new int[size] ; 
			int k = scr.nextInt() ;
			int arr2[] = new int[1000001] ;
			int max = -1;  
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt() ;
				max = Math.max(arr[i],max) ;  
				arr2[arr[i]] += 1 ; 
			}
			int ans = getMaxValue(arr2, max, k) ; 
			System.out.println(ans);
		}
	}
}