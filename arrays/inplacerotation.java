//Inplace rotate square matrix by 90 degrees

import java.util.* ;
import java.io.* ;

public class inplacerotation{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int i,j;
		int mat[][] = new int[size][size];
		for(i=0;i<size;i++){
			for(j=0;j<size;j++)
				mat[i][j] = scr.nextInt();
		}
		int store;
		for(j=0;j<size/2;j++){
			for(i=j;i<size-j-1;i++){
				store = mat[i][j];
				mat[i][j] = mat[j][size-i-1];
				mat[j][size-i-1] = mat[size-i-1][size-j-1];
				mat[size-i-1][size-j-1] = mat[size-j-1][i];
				mat[size-j-1][i] = store;
			}
		}
		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
				System.out.printf("%d ",mat[i][j]);
			}
			System.out.printf("\n");
		}
	}
}