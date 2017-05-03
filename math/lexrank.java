//Given a string, find its rank among all its permutations sorted lexicographically. 
//For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6. 
//String does not contain any duplicate elements. 

import java.io.* ;
import java.util.* ;

public class lexrank{
	static int fact(int k){
		if(k==0)
			return 1;
		else{
			int i=1;
			int fact = 1;
			for(i=1;i<=k;i++)
				fact = fact*i;
			return fact;
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			String str = scr.next();		
			int rank=1;
			for(i=0;i<str.length();i++){
				int bigger = 0;
				for(j=i+1;j<str.length();j++){
					if(str.charAt(j)<str.charAt(i))
						bigger += 1;
				}
				// System.out.printf("rank:%d bigger:%d length:%d ",rank,bigger,str.length()-i);
				// System.out.printf("\n");
				rank = rank+bigger*fact(str.length()-i-1);
			}
			System.out.println(rank);
		}
	}	
}