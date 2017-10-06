/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

*/ 

import java.io.* ;
import java.util.* ;

public class ZigZagPattern{
	public void printMatrix(char[][] mat, int m, int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				System.out.printf("%c ",mat[i][j]) ;
			System.out.printf("\n") ; 
		}
	}
	public void pattern1(char[][] mat, int m, int n, int col, String s, int index, int len){
        int row = 0;
        if(col>=n)
            return ;
        else{
            for(row=0;row<m;row++){
                if(index<len){
                    mat[row][col] = s.charAt(index) ;
                }
                index++ ;
            }
        }
        //System.out.println("Index in fun "+index);
    	//printMatrix(mat,m,n) ;
    }
    public int pattern2(char[][] mat, int m, int n, int col, String s, int index, int len){
        int row = m-2 ;
        while(row>=1 && index<len){
            mat[row][col] = s.charAt(index) ;
            index++ ;
            row-- ;
            col++ ;
        }
        //printMatrix(mat,m,n) ; 
        return col ; 
    }
    public int findCol(int len, int nrow){
        int i = 0 ;
        int col=0 ;
        while(i<len){
            if(i%(nrow-1)==0){
                i+=nrow ;
            }
            else{
                i+=1 ;
            }
            col++ ;
        }
        return col ; 
    }
    public String getString(char mat[][], int m, int n){
        int i,j ;
        String str = "" ;
        for(i=0; i<m; i++){
            for(j=0;j<n;j++){
                if(mat[i][j]!='1')
                    str = str.concat(String.valueOf(mat[i][j])) ; 
            }
        }
        return str ;
    }
    public String convert(String s, int numRows) {
        int len = s.length() ;
        if(numRows==1)
        	return s ; 
        int numCols = findCol(len,numRows) ;
        //System.out.println("col req: " + numCols) ; 
        char[][] mat = new char[numRows][numCols] ;
        int i,j; 
        for(i=0;i<numRows;i++){
            for(j=0;j<numCols;j++){
                mat[i][j] = '1' ;
            }
        }
        j = 0;
        i = 0;
        int index = 0 ;
        while(j<numCols){
            if(j%(numRows-1)==0){
                pattern1(mat,numRows,numCols,j,s,index,len) ;
            	j++ ;
            	index += numRows ; 
            }
            else{
                j = pattern2(mat,numRows,numCols,j,s,index,len) ;
                index += numRows-2 ;
            }
            //System.out.println("j " + j +" index "+index) ;
        }
        return getString(mat,numRows,numCols) ; 
    }
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
        scr.nextLine() ;
		while(ntest-- >0){
			ZigZagPattern zigzag = new ZigZagPattern() ;
			String str = scr.nextLine() ;
			int numRows = scr.nextInt() ;
			String ans = zigzag.convert(str,numRows) ;
			System.out.println(ans) ; 
		}
	}
}