//You are given an array of N+2 integer elements. All elements of the array are in range 1 to N. 
//And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
//O(n) time and O(1) space

import java.io.* ;
import java.util.* ;

public class array26{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n+2];
			for(i=0;i<n+2;i++)
				arr[i] = scr.nextInt();
			for(i=0;i<n+2;i++){
				arr[arr[i]%n] += n;  
			}
			for(i=0;i<n+2;i++)
				System.out.printf("%d ",arr[i]);
			System.out.printf("\n");
			int flag = 0;
			for(i=0;i<n+2;i++){
				if((float)arr[i]/n > 2){
					if(i==0)
						flag = 1;
					else
						System.out.printf("%d ",i);
				}
			}
			if(flag==1)
				System.out.printf("%d ",n);
			System.out.printf("\n");
		}
	}
}