//Egg Dropping Puzzle
//The goal is not to see which is the critical floor but to see which floor to choose to achieve minimum number of trials.

import java.io.* ;
import java.util.* ;

public class eggdrop{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k,m;
		for(m=0;m<ntest;m++){
			int n = scr.nextInt();
			int h = scr.nextInt();
			int mat[][] = new int[n][h+1];

			for(i=0;i<n;i++){
				for(j=0;j<h+1;j++){
					if(j==0)
						mat[i][j] = 0;
					else if(i==0)
						mat[i][j] = j;
					else{
						int min = mat[0][j];
						//System.out.println(min);
						for(k=1;k<=j;k++){
							int x = 1+Math.max(mat[i-1][k-1],mat[i][j-k]);
							if(x<min)
								min = x;
						}
						//System.out.println(min);
						mat[i][j] = min;
					}
				}
			}

			for(i=0;i<n;i++){
				for(j=0;j<h+1;j++){
					System.out.printf("%d ",mat[i][j]);
				}
				System.out.printf("\n");
			}
			System.out.println(mat[n-1][h]);
		}
	}
}