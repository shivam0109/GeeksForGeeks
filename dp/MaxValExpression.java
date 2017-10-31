/*
Given an expression which contains numbers and two operators ‘+’ and ‘*’, 
we need to find maximum and minimum value which can be obtained by evaluating this expression by different parenthesization.
*/

import java.io.* ;
import java.util.* ;

public class MaxValExpression{
	public void printMat(int mat[][], int m, int n){
		for(int i=0; i<m ;i++){
			for(int j=0; j<n ;j++)
				System.out.printf("%d ",mat[i][j]) ;
			System.out.printf("\n") ;
		}
	}
	public int[] findVal(ArrayList<Integer> num, ArrayList<Character> op){
		int n = num.size() ;
		System.out.println(num.size()) ; 
		int maxdp[][] = new int[n][n] ; 
		int mindp[][] = new int[n][n] ; 
		for(int i=0; i<n ;i++){
			for(int j=0; j<n ;j++){
				maxdp[i][j] = 0 ;
				mindp[i][j] = Integer.MAX_VALUE ; 
				if(i==j){
					mindp[i][j] = num.get(i) ;
					maxdp[i][j] = num.get(i) ;
				} 
			}
		}
		int i,j,k,l ; 
		for(l=1;l<n;l++){
			for(i=0;i<n-l;i++){
				j = i+l ;
				int maxVal = 0 ;
				int minVal = Integer.MAX_VALUE ; 
				for(k=i;k<j;k++){
					if(op.get(k)=='+'){
						maxVal = Math.max(maxVal,maxdp[i][k]+maxdp[k+1][j]) ;
						minVal = Math.min(minVal,mindp[i][k]+mindp[k+1][j]) ; 
					}
					if(op.get(k)=='*'){
						maxVal = Math.max(maxVal,maxdp[i][k]*maxdp[k+1][j]) ;
						minVal = Math.min(minVal,mindp[i][k]*mindp[k+1][j]) ; 
					}
				}
				maxdp[i][j] = maxVal ; 
				mindp[i][j] = minVal ;  
			}
		}
		printMat(maxdp,n,n) ; 
		printMat(mindp,n,n) ; 
		int val[] = new int[2] ;
		val[0] = maxdp[0][n-1] ; 
		val[1] = mindp[0][n-1] ;
		return val ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		scr.nextLine() ; 
		while(ntest-->0){
			String str = scr.nextLine() ;
			ArrayList<Integer> num = new ArrayList<Integer>() ;
			ArrayList<Character> op = new ArrayList<Character>() ;
			String temp = "" ;
			for(int i=0; i<str.length() ;i++){
				if(str.charAt(i)=='+' || str.charAt(i)=='*'){
					op.add(str.charAt(i)) ;
					num.add(Integer.valueOf(temp)) ;
					temp = "" ;
				}
				else
					temp = temp.concat(String.valueOf(str.charAt(i))) ; 
			}
			num.add(Integer.valueOf(temp)) ; 
			int val[] = new int[2] ;
			MaxValExpression mv = new MaxValExpression() ;
			val = mv.findVal(num,op) ; 
			System.out.println("Max: " + val[0] + " " + "Min: " + val[1]) ; 
		}
	}
}