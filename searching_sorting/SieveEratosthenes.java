//The classical Sieve of Eratosthenes algorithm takes O(N log (log N)) time to find all prime numbers less than N. 
//In this article, a modified Sieve is discussed that works in O(N) time.

import java.io.* ;
import java.util.* ;

public class SieveEratosthenes{
	static void optimalSieve(int n){
		ArrayList<Integer> primeList = new ArrayList<Integer>() ;
		int isPrime[] = new int[n+1] ;
		int spf[] = new int[n+1] ;
		int i,j;
		isPrime[0] = 1;
		isPrime[1] = 1;
		for(i=2;i<=n;i++){
			if(isPrime[i]==0){
				primeList.add(i) ;
				spf[i] = i ;
			}
			for(j=0;j<primeList.size() && i*primeList.get(j)<=n && primeList.get(j)<= spf[i]; j++){
				isPrime[i*primeList.get(j)] = 1; 
				spf[i*primeList.get(j)] = primeList.get(j) ;
			}
		}

		for(i=0;i<primeList.size();i++)
			System.out.printf("%d ",primeList.get(i)) ;
		System.out.printf("\n") ;
	}
	public static void main(String[] args){
		int n = 100 ;
		optimalSieve(n) ;
	} 
}
