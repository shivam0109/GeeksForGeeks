/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.
*/

/*
Make an optimal substructure using boolean 2d matrix. If dp[n-1][sum] is true, we can make sum using the array. 
Now to printPath, we need to see if sum can be made using current element, or i,j-arr[i] or i-1,j. 
For each of the cases, proceed recursively. 
*/

import java.io.* ;
import java.util.* ;

public class CombinationSum{
	static List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ;
	static HashMap<ArrayList<Integer>,Integer> map = new HashMap<ArrayList<Integer>,Integer>() ;
	static int count = 0 ;
	public void printMatrix(boolean mat[][], int m, int n){
		int i,j ;
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				System.out.print(mat[i][j] + " ") ;
			}
			System.out.printf("\n") ; 
		}
	}
	public void display(List<Integer> v){
       System.out.println(v);
    }
    public void display2(List<List<Integer>> list){
    	System.out.println(list) ; 
    }
	public void printPath(int arr[], boolean mat[][], int sum, ArrayList<Integer> list, int i, int j){
		System.out.println("i: " + i + " j: " + j) ; 
		if(sum==0){
			display(list) ;
			if(!map.containsKey(list)){
				ArrayList<Integer> list2 = new ArrayList<Integer>(list) ; 
				map.put(list2,1);
			} 
			list.clear() ; 
			return ; 	
		}
		if(i==0 && mat[i][j]){
			list.add(arr[0]) ;
			printPath(arr,mat,sum-arr[i],list,0,j-arr[i]) ;  
		}
		if(i>=1 && mat[i-1][j]){
			ArrayList<Integer> p = new ArrayList<Integer>(list) ; 
			printPath(arr,mat,sum,p,i-1,j) ; 
		}
		if(i>=1 && j>=arr[i] && mat[i-1][j-arr[i]]){
			ArrayList<Integer> q = new ArrayList<Integer>(list) ;
			q.add(arr[i]) ;
			printPath(arr,mat,sum-arr[i],q,i-1,j-arr[i]) ;
		}
		if(i>=1 && j>=arr[i] && mat[i][j-arr[i]] && j-arr[i]>=arr[i]){
			ArrayList<Integer> r = new ArrayList<Integer>(list) ;
			r.add(arr[i]) ;
			printPath(arr,mat,sum-arr[i],r,i,j-arr[i]) ; 
		}
		if(i>=1 && j>=arr[i] && mat[i][j-arr[i]] && j-arr[i]>=arr[i] && (j-arr[i])%arr[i]==0){
			ArrayList<Integer> s = new ArrayList<Integer>(list) ;
			s.add(arr[i]) ;
			printPath(arr,mat,sum-arr[i],s,i,j-arr[i]) ; 
		} 	
	}
	public void combinationSum(int arr[], int target){
		int n = arr.length ;
		boolean dp[][] = new boolean[n][target+1] ; 
		int i,j ;
		Arrays.sort(arr) ; 
		//fill first column. 
		for(i=0;i<n;i++)
			dp[i][0] = true;

		//fill first row. 
		for(j=1;j<target+1;j++){
			if(j%arr[0]==0)
				dp[0][j] = true ; 		
			else
				dp[0][j] = false;
		}

		//fill rest of matrix 
		for(i=1;i<n;i++){
			for(j=1;j<target+1;j++){
				if(j<arr[i])
					dp[i][j] = dp[i-1][j] ;
				else{
					if(dp[i-1][j-arr[i]] || dp[i][j-arr[i]] || dp[i-1][j]){
						dp[i][j] = true ; 
					}
					else
						dp[i][j] = false;
				} 
			}
		}

		printMatrix(dp,n,target+1) ;
		ArrayList<Integer> p = new ArrayList<Integer>() ;
		printPath(arr,dp,target,p,n-1,target) ;
		
		Set keyset = map.keySet() ;
		//System.out.println(keyset) ; 
		Iterator<ArrayList<Integer>> iter = keyset.iterator() ; 
		while(iter.hasNext()){
			ArrayList<Integer> l = iter.next() ;
			//display(l) ;
			arrlist.add(l) ; 
		} 
		//return arrlist ;  
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
			CombinationSum csum = new CombinationSum() ;
			csum.combinationSum(arr,k) ;
			System.out.println(arrlist) ; 		
			//System.out.println(i) ; 
		}
	}
}