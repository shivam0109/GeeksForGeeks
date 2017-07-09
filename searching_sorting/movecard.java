//We have N cards with each card numbered from 1 to N. 
//All cards are randomly shuffled. We are allowed only operation moveCard(n) which moves the card with value n to the top of the pile. 
//You are required to find out the minimum number of moveCard() operations required to sort the cards in increasing order.

//We dont need to disturb already sorted orders.
//If 5 comes after 4, we dont need to do movecard(4) 

//Start from n-1. If n comes after n-1, we dont need movecard(n-1).
//Time : O(n2)  
import java.io.* ;
import java.util.* ;

public class movecard{
	static int[] findIndex(int[] arr, int n, int len){
		int i;
		int ind[] = new int[2] ;
		for(i=0;i<len;i++){
			if(arr[i]==n)
				ind[0] = i;
			if(arr[i]==n+1)
				ind[1] = i;
		}
		return ind ;
	}
	static void move(int[] arr, int index, int num){
		int i;
		int temp1 = 0;
		int temp2 = arr[0];
		for(i=1;i<=index;i++){
			temp1 = arr[i] ;
			arr[i] = temp2 ;
			temp2 = temp1 ; 
		}
		arr[0] = num ;
	}
	static int findMinMoves(int[] arr, int n){
		int i;
		int count = 0;
		int ind[] = new int[2] ;
		for(i=n-1;i>=1;i--){
			//if index of i is greater than index of i+1, count++ 
			ind = findIndex(arr,i,n) ; 			
			if(ind[0]>ind[1]){
				count++ ;
				move(arr,ind[0],i);
			}
		}
		return count ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int ans = findMinMoves(arr,n) ; 
			System.out.println(ans) ;
		}
	}	
}