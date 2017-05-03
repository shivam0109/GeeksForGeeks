//Product Array Puzzle 

import java.util.*;
import java.lang.*;
import java.io.*;

class array23{
	public static void main (String[] args) {
		//code
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
		    int n = scr.nextInt();
		    int arr[] = new int[n];
		    for(i=0;i<n;i++)
		        arr[i] = scr.nextInt();
		    int left[] = new int[n];
		    int right[] = new int[n];
		    left[0] = 1;
		    for(i=1;i<n;i++)
		        left[i] = arr[i-1]*left[i-1];
		    right[n-1] = 1;
		    for(i=n-2;i>=0;i--)
		        right[i] = arr[i+1]*right[i+1];
		    for(i=0;i<n;i++){
		        long prod = left[i]*right[i];
		        System.out.println(prod);
		    }
		    System.out.printf("\n");
		}
	}
}