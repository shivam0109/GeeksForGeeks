/*
Given an array of non negative integers A, and a range (B, C), 
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)
*/ 

import java.io.* ;
import java.util.* ;

public class NumRange{
	public void output(ArrayList<Integer> list, int a, int b){
		for(int i=a; i<=b ;i++){
			System.out.printf("%d ",list.get(i)) ;
		}
		System.out.printf("\n") ; 
	}

	public int numRange(ArrayList<Integer> a, int b, int c) {
		int start = 0;
		int end = 0 ;
		int size = a.size() ;
		int currSum = a.get(start) ;
		int count = 0 ;
		boolean flag = false;
		while(end<size){
			//System.out.println("currsum: " + currSum) ;
			//System.out.println("start: " + start + " end: " + end) ;
			if(a.get(end)>c){
				//System.out.println("In 1") ;
				start = end+1 ;
				end = start ;
				if(start<size)
					currSum = a.get(start) ;
			}

			else if(currSum>c){
				System.out.println("In 2") ;				
				output(a,start,end-1) ;
				count++ ; 
				currSum -= a.get(start) ; 
				start++ ;
			}

			else{
				System.out.println("In 3") ;
				if(currSum>=b){
					count++ ;
					output(a,start,end) ; 
				}
				end++ ;
				if(end<size)
					currSum += a.get(end) ; 
			}
		}
		return count ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			ArrayList<Integer> list = new ArrayList<Integer>() ; 
			NumRange nr = new NumRange() ;
			int n = scr.nextInt() ;
			for(int i=0 ; i<n; i++)
				list.add(scr.nextInt()) ;
			int a = scr.nextInt() ;
			int b = scr.nextInt() ;
			//System.out.println("a: " + a + " b: " + b) ; 
			System.out.println(nr.numRange(list,a,b)) ; 
		}
	}
}