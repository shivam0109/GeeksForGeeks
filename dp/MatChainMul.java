//Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
//The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
//(AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
//A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.

import java.io.* ;
import java.util.* ;

public class MatChainMul{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int arr[] = new int[n];
		int i;
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt();
		
	}
}