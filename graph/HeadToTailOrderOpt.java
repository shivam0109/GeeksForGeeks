/*
A head to tail ordering of strings is the one in which the last letter of the previous word 
is the same as the first letter of the following word. 
For eg. ‘Geekforgeeks’ can be followed by ‘ software’.
*/

import java.io.* ;
import java.util.* ;

public class HeadToTailOrderOpt{
	public boolean isOrderingPossible(char start[], char end[]){
		int i;
		int possibleHead = 0 ;
		int possibleTail = 0;
		for(i=0;i<26;i++){
			if(Math.abs(start[i]-end[i])>1)
				return false; 
			if(start[i]-end[i]==1)
				possibleHead++ ;
			if(end[i]-start[i]==1)
				possibleTail++ ;
		}
		if(possibleTail>1 || possibleHead>1)
			return false;
		return true ;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			char[] start = new char[26] ;
			char[] end = new char[26] ;
			int n = scr.nextInt() ;
			HeadToTailOrderOpt g = new HeadToTailOrderOpt() ;
			for(i=0;i<n;i++){
				String str = scr.next() ;
				char s = str.charAt(0) ;
				char e = str.charAt(str.length()-1) ; 
				start[s-'a']++ ;
				end[e-'a']++ ;
			}
			boolean ans = g.isOrderingPossible(start,end) ;
			if(ans)
				System.out.println("Head to tail ordering is possible.") ;
			else
				System.out.println("Head to tail ordering is not possible.") ;
 		}
	}
}