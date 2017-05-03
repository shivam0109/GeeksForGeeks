//Celebrity Problem. Solve in O(n) and O(1) extra space.

//In a party of N people, only one person is known to everyone. Such a person may be present in the party, 
//if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. 
//Find the stranger (celebrity) in minimum number of questions.

import java.io.* ;
import java.util.* ;

public class Stack15{
	static int knows(int j1, int j2, int mat[][]){
		return mat[j1][j2];
	}
	static int everknows(int j,int mat[][]){
		int i;
		int sum = 0;
		for(i=0;i<mat.length;i++){
			sum += mat[i][j];
		}
		if(sum==mat.length-1)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int i,j;
		int n = scr.nextInt();
		int mat[][] = new int[n][n];
		
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				mat[i][j] = scr.nextInt();
			}
		}
		int left = 0;
		int right = n-1;
		while(left<right){
			if(knows(left,right,mat)==1)
				left += 1;
			else
				right = right-1;
		}

		if(everknows(left,mat)==1)
			System.out.println(left);
		else
			System.out.println(-1);
	}
}