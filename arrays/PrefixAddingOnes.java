//You start with an array A of size N. Also, A[i] = 0 for i = 1 to N. 
//You will be given K positive integers. Let j be one of these integers, you have to add 1 to all A[i], for i >= j. 
//Your task is to print the array A after all these K updates are done.

import java.io.* ;
import java.util.* ;

public class PrefixAddingOnes{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j;
		for(j=0;j<ntest;j++){
			
			int n = scr.nextInt();
			int m = scr.nextInt();
			int prefixSumArray[] = new int[n] ;
			
			for(i=0; i<m; i++){
				int num = scr.nextInt() ;
				prefixSumArray[num-1] += 1 ;
			}

			for(i=0;i<n;i++){
				if(i!=0)
					prefixSumArray[i] += prefixSumArray[i-1] ; 
				System.out.printf("%d ",prefixSumArray[i]) ;
			}
			System.out.printf("\n") ;
		}
	}
}