/*
Given a number n and we have to find n-th number such that it’s digits only consist 0, 1, 2, 3, 4 or 5.
*/ 

import java.io.* ;
import java.util.* ;

public class NthNumber{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int i,j ;
			int n = scr.nextInt() ;
			ArrayList<Integer> alist = new ArrayList<Integer>() ;
			
			for(i=0;i<6;i++)
				alist.add(i) ;  
			
			for(i=0;i<n-1;i++){
				for(j=0;j<6;j++){
					if(alist.get(i)*10!=0)
						alist.add(alist.get(i)*10+alist.get(j)) ;
				}
			}

			System.out.println(alist.get(n-1)) ; 
		}
	}
}