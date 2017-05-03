//A subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. 
//Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.

import java.io.* ;
import java.util.* ;

public class LBitSeq{
	static void printarr(int arr[]){
		int i;
		for(i=0;i<arr.length;i++)
			System.out.printf("%d ",arr[i]);
		System.out.printf("\n");
	}
	static int max(int arr[]){
		int i;
		int max = arr[0];
		for(i=1;i<arr.length;i++){
			if(max<arr[i])
				max = arr[i];
		}
		return max;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int i,j;
		int arr[] = new int[n];
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt();
		int lisdp[] = new int[n];
		
		for(i=0;i<n;i++)
			lisdp[i] = 1;

		for(i=1;i<n;i++){
			for(j=0;j<i;j++){
				if(arr[j]<arr[i] && lisdp[i]<lisdp[j]+1)
					lisdp[i] = lisdp[j] + 1;
			}
		}

		//printarr(lisdp);

		int ldsdp[] = new int[n];
		for(i=0;i<n;i++)
			ldsdp[i] = 1;

		for(i=1;i<n;i++){
			for(j=0;j<i;j++){
				if(arr[j]>arr[i] && ldsdp[i]<ldsdp[j]+1)
					ldsdp[i] = ldsdp[j] + 1;
			}
		}

		//printarr(ldsdp);

		for(i=0;i<n;i++)
			lisdp[i] = lisdp[i] + ldsdp[i];

		//printarr(lisdp);

		System.out.println(max(lisdp)-1);
	}
}