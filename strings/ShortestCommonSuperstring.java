/*
Given a set of strings. Find the length of smallest string which
has all the strings in the set as substring

Input: [“abcd”, “cdef”, “fgh”, “de”]
Output: 8 (Shortest string: “abcdefgh”)

*/

import java.io.* ;
import java.util.* ;

public class ShortestCommonSuperstring{
	public boolean isSubstring(String str1, String str2, int m, int n){
		int i,j ;
		for(i=0;i<m-n;i++){
			if(str1.substring(i,n+i).equals(str2))
				return true ;
		}
		return false ;
	}
	public String shortestUtil(String str1, String str2){
		int m = str1.length() ;
		int n = str2.length() ;
		if(m==0)
			return str2 ;
		if(n==0)
			return str1 ; 
		// if(m<n)
		// 	return shortestUtil(str2,str1) ; 
		if(isSubstring(str1,str2,m,n))
			return str1 ;
		int i=0 ;
		int j=0 ;
		boolean flag = false ;
		while(i<m && j<n){
			if(str1.charAt(i)!=str2.charAt(j)){
				j=0 ;
				i++ ;
				flag = false ;
			}
			else{
				i++ ;
				j++ ; 
				flag = true ; 
			}
		}
		if(flag)
			return str1.concat(str2.substring(j,n)) ;
		return str1.concat(str2) ;  

	}
	public void generatePermutation(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> bigList, int arr[], int n){
		if(list.size()==n){
			ArrayList<Integer> tempList = new ArrayList<Integer>(list) ;
			bigList.add(tempList) ; 
			return ;   
		}
		else{
			for(int i=0;i<n;i++){
				if(list.contains(arr[i]))
					continue ;
				list.add(arr[i]) ;
				generatePermutation(list,bigList,arr,n) ;
				list.remove(list.size()-1) ; 
			}
		}
	}
	public String shortestCommonSuperStr(String[] arr){
		int n = arr.length ;
		if(n==0)
			return "" ;
		if(n==1)
			return arr[0] ;
		int i;
		int index[] = new int[n] ;
		for(i=0;i<n;i++)
			index[i] = i ;
		ArrayList<ArrayList<Integer>> listOfList = new ArrayList<ArrayList<Integer>>() ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		generatePermutation(list,listOfList,index,n) ; 
		for(i=0;i<listOfList.s)
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		scr.nextLine() ;
		while(ntest-->0){
			String allStrings = scr.nextLine() ;
			String[] inArray = allStrings.split("\\s") ; 
			ShortestCommonSuperstring scs = new ShortestCommonSuperstring() ;
			System.out.println(scs.shortestCommonSuperStr(inArray)) ; 
		}
	}
}