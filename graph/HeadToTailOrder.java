/*
A head to tail ordering of strings is the one in which the last letter of the previous word 
is the same as the first letter of the following word. 
For eg. ‘Geekforgeeks’ can be followed by ‘ software’.
*/

import java.io.* ;
import java.util.* ;

public class HeadToTailOrder{

	public boolean isHeadToTailUtil(String[] arr, String str, int index, boolean[] visited, int size, int curr){
		if(curr==size)
			return true ;
		int i;
		for(i=0;i<size;i++){
			String str2 = arr[i] ;
			if(!visited[i] && str2.charAt(0)==str.charAt(str.length()-1)){
				visited[i] = true ;
				if(isHeadToTailUtil(arr,str2,i,visited,size,curr+1))
					return true ;
				visited[i] = false ;
			}
		}
		return false ;
	}

	public boolean isHeadToTail(String[] arr, int size){
		boolean visited[] = new boolean[size] ; 
		boolean flag = false ; 
		for(int i =0; i<size; i++){
			if(!visited[i]){
				visited[i] = true ; 
				flag = isHeadToTailUtil(arr,arr[i],i,visited,size,1) ; 
				if(flag)
					break ;
				visited[i] = false ;
			}
		}
		return flag ;
	}
	
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j;
		HeadToTailOrder g = new HeadToTailOrder() ; 
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			String[] arr = new String[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.next() ;
			boolean ans = g.isHeadToTail(arr,n) ; 
			if(ans)
				System.out.println("Head to tail ordering is possible.") ;
			else
				System.out.println("Head to tail ordering is not possible.") ;
		}
	}
}