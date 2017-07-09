//We have N cards with each card numbered from 1 to N. 
//All cards are randomly shuffled. We are allowed only operation moveCard(n) which moves the card with value n to the top of the pile. 
//You are required to find out the minimum number of moveCard() operations required to sort the cards in increasing order.

//Find LIS containing n.
//n-LIS will be the ans. Time : O(n) 

import java.io.* ;
import java.util.* ;

public class moveCardOpt{
	static int findLIS(int arr[], int n){
		int lis=0,i ;
		int prev = n-1;
		int nIndex = 0;
		
		for(i=0;i<n;i++){
			if(arr[i]==n)
				nIndex = i ;
		}

		for(i=nIndex;i>=0;i--){
			if(arr[i]==prev){
				prev-- ;
				lis++ ; 
			}
		}
		
		return lis ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int lis = findLIS(arr,n) ;
			System.out.println(n-lis-1) ; 
		}
	}
}