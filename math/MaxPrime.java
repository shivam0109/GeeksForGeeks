/*
Given a number, find max prime factor of it.
*/

import java.io.* ;
import java.util.* ;

public class MaxPrime{
	public int maxPrimeFactor(int n){
		int arr[] = new int[n+1] ; 
		arr[0] = -1 ;
		arr[1] = -1 ;
		for(int i=2;i<=Math.sqrt(n);i++){
			if(arr[i]==-1)
				continue ;
			for(int j=2;i*j<=n;j++)
				arr[i*j] = -1 ;
		}
		for(int i=n;i>=0;i--){
			if(arr[i]!=-1 && n%i==0)
				return i ; 
		}
		return 1 ; 
	}
	public static void main(String[] args){
		int n = 840 ;
		MaxPrime mpf = new MaxPrime() ;
		System.out.println(mpf.maxPrimeFactor(n)) ; 
	}
}