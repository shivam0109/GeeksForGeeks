/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.
*/

import java.io.* ;
import java.util.* ;

public class CombinationSum2{
	public void printMatrix(boolean mat[][], int m, int n){
		int i,j ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				System.out.print(mat[i][j] + " ") ;
			}
			System.out.printf("\n") ; 
		}
	}
	public void display(ArrayList<Integer> list){
		System.out.println(list) ; 
	}
	public void printPath(int[] arr, boolean[][] mat, int sum, int i, int j, ArrayList<Integer> list, HashMap<ArrayList<Integer>,Integer> map){
		if(sum==0){
			if(!map.containsKey(list)){
				ArrayList<Integer> list2 = new ArrayList<Integer>(list) ; 
				map.put(list2,1) ; 
			}
			//display(list) ; 
			list.clear() ;
			return ; 
		}
		if(i==0 && mat[0][j] && sum!=0){
			list.add(arr[0]) ;
			//display(list) ; 
			if(!map.containsKey(list)){
				ArrayList<Integer> list3 = new ArrayList<Integer>(list) ; 
				map.put(list3,1) ; 
			}
			list.clear() ; 
			return ; 
		}
		if(i>=1 && mat[i-1][j]){
			ArrayList<Integer> p = new ArrayList<Integer>(list) ;
			printPath(arr,mat,sum,i-1,j,p,map) ; 
		}
		if(i>=1 && j-arr[i]>=0 && mat[i-1][j-arr[i]]){
			ArrayList<Integer> q = new ArrayList<Integer>(list) ;
			q.add(arr[i]) ; 
			printPath(arr,mat,sum-arr[i],i-1,j-arr[i],q,map) ; 
		}
	}
	public List<List<Integer>> combinationSum2(int[] arr, int target) {
		int n = arr.length ;
		if(n==0 || target<0)
			return new ArrayList<List<Integer>>() ;
		int i,j ;
		boolean dp[][] = new boolean[n][target+1] ;
		Arrays.sort(arr) ; 
		for(i=0;i<n;i++)
			dp[i][0] = true ;
		
		for(j=1;j<target+1;j++){
			if(j==arr[0]){
				dp[0][j] = true ;
				break ; 
			} 
		}

		for(i=1;i<n;i++){
			for(j=1;j<target+1;j++){
				if(j<arr[i])
					dp[i][j] = dp[i-1][j] ;
				else
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]] ; 
			}
		}

		//printMatrix(dp,n,target+1) ;
		if(!dp[n-1][target])
			return new ArrayList<List<Integer>>() ;
		ArrayList<Integer> p = new ArrayList<Integer>() ; 
		HashMap<ArrayList<Integer>,Integer> map = new HashMap<ArrayList<Integer>,Integer>() ; 
		List<List<Integer>> list = new ArrayList<List<Integer>>() ;  
		printPath(arr,dp,target,n-1,target,p,map) ;  
    	
		Set keyset = map.keySet() ;
		Iterator<ArrayList<Integer>> iter = keyset.iterator() ; 
		while(iter.hasNext()){
			ArrayList<Integer> x = iter.next() ;
			list.add(x) ; 
		}
    	return list ; 
    }

    public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ; 
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int k = scr.nextInt() ;
			CombinationSum2 csum2 = new CombinationSum2() ;
			List<List<Integer>> arrlist = csum2.combinationSum2(arr,k) ;
			System.out.println(arrlist) ; 		
			//System.out.println(i) ; 
		}
	}
}
