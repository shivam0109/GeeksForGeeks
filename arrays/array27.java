//Given an array of random numbers, Push all the zero’s of a given array to the end of the array.

import java.io.* ;
import java.util.* ;

public class array27{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i;
			int zptr = -1;
			int nzptr = -1;
			int temp;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			for(i=0;i<n;i++){
				if(arr[i]!=0)
					nzptr = i;
				if(arr[i]==0 && zptr == -1)
					zptr = i;
				if(nzptr>zptr && zptr!=-1){
					temp = arr[zptr];
					arr[zptr] = arr[nzptr];
					arr[nzptr] = temp;
					nzptr = zptr;
					zptr++;
				}
			}
			for(i=0;i<n;i++)
				System.out.printf("%d ",arr[i]);
			System.out.printf("\n");
		}
	}
}