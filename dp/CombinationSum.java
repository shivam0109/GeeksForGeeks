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
	public void printPath(int arr[], int i, boolean dp[][], int sum, List<Integer> p){
		if(i==0){
			if(sum==0){
				display(p) ; 
				p.clear() ; 
				return ;
			}
			if(arr[i]==sum && dp[0][sum]){
				p.add(arr[i]) ;
				arrlist.add(p) ;
				p.clear() ; 
				return ;  
			}
			if(arr[i]!=sum && dp[0][sum]){
				p.add(arr[i]) ;
				printPath(arr,i,dp,sum-arr[i],p) ; 
			}
		}

		if(i-1>=0 && dp[i-1][sum]){
			printPath(arr,i-1,dp,sum,p) ;
		}

		if(i-1>=0 && sum-arr[i]>=0 && dp[i-1][sum-arr[i]]){
			p.add(arr[i]) ;
			printPath(arr,i-1,dp,sum-arr[i],p) ;  
		}

		if(sum-arr[i]>=0 && dp[i][sum-arr[i]]){
			p.add(arr[i]) ;
			printPath(arr,i,dp,sum-arr[i],p) ; 
		}
	}

	public void combinationSum(int arr[], int target){
		int n = arr.length ;
		boolean dp[][] = new boolean[n][target+1] ; 
		int i,j ;
		
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
		printPath(arr,n-1,dp,target,p) ;
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
			for(i=0;i<arrlist.size();i++){
				System.out.println(arrlist.get(i)) ; 
			}		
		}
	}
}