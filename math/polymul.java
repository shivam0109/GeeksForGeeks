//Multiply 2 polynomials.

import java.io.* ;
import java.util.* ;

public class polymul{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int i,j,k;
		int ntest = scr.nextInt();
		for(k=0;k<ntest;k++){
			int n1 = scr.nextInt();
			int n2 = scr.nextInt();
			int arr1[] = new int[n1];
			int arr2[] = new int[n2];		
			for(i=0;i<n1;i++)
				arr1[i] = scr.nextInt();
			for(i=0;i<n2;i++)
				arr2[i] = scr.nextInt();
			int res[] = new int[n1+n2-1];
			for(i=0;i<n1+n2-1;i++)
				res[i] = 0;
			int mul;
			for(i=0;i<n1;i++){
				for(j=0;j<n2;j++){
					mul = arr1[i]*arr2[j];
					res[i+j] += mul;					
				}
			}
			for(i=0;i<n1+n2-1;i++)
				System.out.printf("%d ",res[i]);
			System.out.printf("\n");
		}
	}
}