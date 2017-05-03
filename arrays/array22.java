//Count Negative Numbers in a Column-Wise and Row-Wise Sorted Matrix in O(m+n)

import java.io.* ;
import java.util.* ;

public class array22{
	static int countneg(int mat[][], int m, int n){
		//Start with top right corner 
		int i=0;
		int j=n-1;
		int count = 0;
		while(i<m && j>=0){
			if(mat[i][j]<0){
				count += (j+1);
				i = i+1;
			}
			else
				j = j-1;
		}
		return count;
	}
	public static void main(String[] args){
		int mat[][] = new int[][]{
			{-3,-2,-1,1},
			{-2,2,3,4},
			{4,5,7,8}
		};
		System.out.println(countneg(mat,3,4)); 
	}
}	