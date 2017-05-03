//You have N stacks of books. Each stack of books has some non zero height Hi equal to the number of books on that stack 
//( considering all the books are identical and each book has a height of 1 unit ). 
//In one move, you can select any number of consecutive stacks of books such that 
//the height of each selected stack of books Hi <= K . Once such a sequence of stacks is chosen , 
//You can collect any number of books from the chosen sequence of stacks .
//What is the maximum number of books that you can collect this way ?

import java.util.* ;
import java.io.* ;

public class booksdp{
	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int k = scr.nextInt();
			int arr[] = new int[size];
			int dp[] = new	int[size];
			int i;
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt();
				if(arr[i]>k){
					arr[i] = 0;
				}
			}
			dp[0] = arr[0];
			for(i=1;i<size;i++){
				if(arr[i]!=0){
					dp[i] = dp[i-1] + arr[i];
				}
				else{
					dp[i] = 0 ;
				}
			}
			Arrays.sort(dp);
			System.out.println(dp[size-1]);
		}
	}
}