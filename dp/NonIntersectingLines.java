/*
Given a number N, return number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
Two ways are different if there exists a chord which is present in one way and not in other.

Kind of like multiply dp. 
Try to see which new pairs are being formed and develop a formula for it. 

Always use long for large numbers. 
*/
import java.util.*;

public class NonIntersectingLines{
    public void printArray(long[] arr, int n){
        for(int i= 0; i<n; i++)
            System.out.printf("%d ",arr[i]) ;
        System.out.printf("\n") ; 
    }
    public int chordCnt(int A) {
        long dp[] = new long[A+1] ; 
        //Arrays.fill(dp, 0);
        int i,j,k ;
        if(A==0)
            return 1 ; 
        dp[0] = 1 ;
        dp[1] = 1 ; 
        for(i=2;i<A+1;i++){
            j = 0 ;
            k = 0;
            while(j<=i-1){
                dp[i] = (dp[i] + (dp[j]*dp[i-1-j])%(long)((Math.pow(10,9)+7)))%(long)((Math.pow(10,9)+7));            
                // if(i==30)
                //     System.out.println(j) ; 
                j++;
            }    
        }
        printArray(dp,A+1) ;
        long ans = (long)(dp[A] % (long)((Math.pow(10,9)+7))) ; 
        return (int)(ans) ; 
    }
    public static void main(String[] args) {
        NonIntersectingLines sol = new NonIntersectingLines();
        int a = sol.chordCnt(31);
    }
}
