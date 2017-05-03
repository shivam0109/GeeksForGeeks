//Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. 
//The array might also contain duplicates. 

import java.io.* ;
import java.util.* ;

public class array29{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int x = scr.nextInt();
			int y = scr.nextInt();
			int xin = -1;
			int yin = -1;
			int min = n+1;
			for(i=0;i<n;i++){
				if(arr[i]==x){
					xin = i;
					if(min>Math.abs(xin-yin) && yin!=-1)
						min = Math.abs(xin-yin);
				}
				if(arr[i]==y){
					yin = i;
					if(min>Math.abs(xin-yin) && xin!=-1)
						min = Math.abs(xin-yin);
				}
			}
			if(xin==-1 || yin==-1)
				System.out.println(-1);
			else
				System.out.println(min);
		}
	}
}

