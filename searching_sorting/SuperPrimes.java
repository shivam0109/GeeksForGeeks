//A prime number is Super Prime if it is a sum of two primes. Find all the Super Primes upto N

import java.io.* ;
import java.util.* ;

public class SuperPrimes{
	static int findSuperPrime(int n){
		int arr[] = new int[n+1] ;	
		int i,j ;
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		for(i=2;i*i<=n;i++){
			if(arr[i]==0){
				for(j=i;j*i<=n;j++)
					arr[j*i] = 1;
			}
		}
		
		
		for(i=2;i<=n;i++){
			if(arr[i]==0)
				list.add(i) ;
		}

		//System.out.println(list) ;
		
		for(i=0;i<list.size()-1;i++){
			if(list.get(i+1)==list.get(i)+2)
				count++ ;
		}
		
		return count ;	
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j,k ;
		for(k=0;k<ntest;k++){		
			int n = scr.nextInt() ;
			long startTime = System.nanoTime() ;
			int count = findSuperPrime(n) ;
			long estimatedTime = System.nanoTime() - startTime ; 
			System.out.println(estimatedTime) ;
			System.out.println(count) ;
		}
	}
}