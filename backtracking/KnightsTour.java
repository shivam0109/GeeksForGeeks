/*
The knight is placed on the first block of an empty board and, moving according to the rules of chess, 
must visit each square exactly once.
*/ 

import java.io.* ;
import java.util.* ;

public class KnightsTour{
	public boolean isSafe(ArrayList<ArrayList<Integer>> mat, int x, int y){
		int n = mat.size() ;
		return (x >= 0 && x < n && y >= 0 &&
                y < n && mat.get(x).get(y) == -1);
	}
	public void printMat(ArrayList<ArrayList<Integer>> mat){
		for(int i=0; i<mat.size(); i++){
			for(int j=0; j<mat.get(i).size(); j++)
				System.out.printf("%d ",mat.get(i).get(j)) ;
			System.out.printf("\n") ; 
		}
	}
 	public boolean backtrack(ArrayList<ArrayList<Integer>> mat, int count, int row, int col, int n, int xMove[], int yMove[]){
 		// System.out.println(count) ;
 		//printMat(mat) ;
 		if(count==n*n){
 			printMat(mat) ; 
 			return true;
 		}
 		for(int k=0;k<8;k++){
 			int next_x = row+xMove[k] ;
 			int next_y = col+yMove[k] ; 
 			if(isSafe(mat,next_x,next_y)){
 				mat.get(next_x).set(next_y,count) ; 
 				if(backtrack(mat,count+1,next_x,next_y,n,xMove,yMove)) 
 					return true ;
 				mat.get(next_x).set(next_y,-1) ;  
 			}
 		}
 		return false;
 	}
 	public void knightsTour(int n){
 		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>() ;
 		for(int i=0; i<n ;i++){
 			ArrayList<Integer> temp = new ArrayList<Integer>() ;
 			for(int j=0; j<n ;j++)
 				temp.add(-1) ;
 			mat.add(temp) ; 
 		}
 		int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        mat.get(0).set(0,0) ;
        backtrack(mat,1,0,0,n,xMove,yMove);
 	}
 	public static void main(String[] args){
 		int n = 8 ; 
 		KnightsTour kt = new KnightsTour() ;
 		kt.knightsTour(n) ; 
 	}
}