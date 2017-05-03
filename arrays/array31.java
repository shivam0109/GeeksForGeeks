//Given an array that contains both positive and negative integers, find the product of the maximum product subarray.

import java.io.* ;
import java.util.* ;

public class array31{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i,j;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int maxpos[] = new int[n];
			int maxneg[] = new int[n];
			maxpos[0] = Math.max(1,arr[0]);
			if(arr[0]==0)
				maxneg[0] = 1;
			else 
				maxneg[0] = Math.min(arr[0],1);
			for(i=1;i<n;i++){
				maxpos[i] = Math.max(maxneg[i-1]*arr[i],Math.max(maxpos[i-1]*arr[i],1));
				maxneg[i] = Math.min(maxpos[i-1]*arr[i],Math.min(maxneg[i-1]*arr[i],1));
			}
			for(i=0;i<n;i++)
				System.out.printf("%d ",maxpos[i]);
			System.out.printf("\n");
			for(i=0;i<n;i++)
				System.out.printf("%d ",maxneg[i]);
			System.out.printf("\n");
			int max = maxpos[0];
			for(i=0;i<n;i++){
				if(max<maxpos[i])
					max = maxpos[i];
			}
			System.out.println(max);
			
		}
	}
}