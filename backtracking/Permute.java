/*
Permutations of 1 to n. 
*/

import java.io.* ;
import java.util.* ;

public class Permute{
	public void backtrack(ArrayList<Integer> list , int[] arr, int n){
		if(list.size()==n){
			System.out.println(list) ;
			//list.clear() ;
			return ; 
		}
		else{
			for(int i=0 ; i<n ; i++){
				if(list.contains(arr[i]))
					continue ;
				list.add(arr[i]) ;
				backtrack(list,arr,n) ;
				list.remove(list.size()-1) ; 
			}
		}
	}
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5} ;
		Permute p = new Permute() ;
		p.backtrack(new ArrayList<Integer>(), arr, 5) ; 
	}
}