/*
Find longest Arithmetic Progression in an integer array and return its length. 
More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that 
sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression
*/

import java.io.* ;
import java.util.* ;

public class LongestAP{
	public int removeDup(int[] arr, int n){
        int i = 1;
        int count = 1;
        for(i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                arr[count] = arr[i] ;
                count++ ;
            }
        }
        return count ; 
    }
    public int zeroAP(int[] arr, int n){
        int count = 1;
        int maxCount = 1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1])
                count++ ;
            else
                count = 1 ;
            maxCount = Math.max(maxCount,count) ; 
        }
        return maxCount ; 
    }
    public int solve(final int[] A) {
        int n = A.length ;
        int arr[] = Arrays.copyOfRange(A,0,n) ;
        if(n<=2)
            return n ; 
        int i,j,k; 
        Arrays.sort(arr) ; 
        int ans1 = zeroAP(arr,n) ;
        int len = removeDup(arr,n) ;
        int dp[][] = new int[len][len] ;
        for(j=0;j<len;j++)
            dp[len-1][j] = 2 ;
        for(i=0;i<len;i++)
            dp[i][len-1] = 2 ;
        int llap = 2 ;
        for(j=len-2;j>=0;j--){
            i = j-1 ;
            k = j+1 ;
            while(i>=0 && k<=n-1){
                if(arr[i]+arr[k]<2*arr[j])
                    k++ ;
                else if(arr[i]+arr[k]>2*arr[j]){
                    dp[i][j] = 2;
                    i-- ;
                }
                else{
                    dp[i][j] = dp[j][k] + 1;
                    llap = Math.max(llap,dp[i][j]) ;
                    i-- ; 
                    k++ ;
                }
            }
            while(i>=0){
                dp[i][j] = 2;
                i-- ;
            }
        }
        printMat(dp,len) ; 
        return Math.max(llap,ans1) ;
    }
    public void printMat(int[][] mat, int n){
    	for(int i=0; i<n; i++){
    		for(int j=0 ; j<n; j++)
    			System.out.printf("%d ",mat[i][j]) ;
    		System.out.printf("\n") ;
    	}
    	System.out.printf("\n") ;
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
    		LongestAP lap = new LongestAP() ;
    		System.out.println(lap.solve(arr));
    	}
    }
}