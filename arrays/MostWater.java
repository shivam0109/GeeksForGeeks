/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

In other words find maximum of abs(i-j)*min(arr[i],arr[j]) 	
*/ 

/*
Initially we consider the area constituting the exterior most lines. 
Now, to maximize the area, we need to consider the area between the lines of larger lengths. 
If we try to move the pointer at the longer line inwards, we won't gain any increase in area, 
since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, 
as per the same argument, despite the reduction in the width. 
This is done since a relatively longer line obtained by moving the shorter line's pointer might 
overcome the reduction in area caused by the width reduction.
*/ 

import java.io.* ;
import java.util.* ;

public class MostWater{
	public int maximumProduct(int arr[], int n){
		int left = 0;
		int right = n-1 ;
		int max = -Integer.MAX_VALUE ;
		int curr ;
		while(left<right){
			curr = Math.min(arr[left],arr[right])*(right-left) ;
			if(Math.min(arr[left],arr[right]) == arr[left])
				left++ ;
			else
				right-- ; 
			if(curr>max)
				max = curr ; 			
		}
		return max ; 
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
			MostWater mw = new MostWater() ;
			int ans = mw.maximumProduct(arr,n) ;
			System.out.println(ans) ; 
		}
	}
}