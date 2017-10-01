/*
You are given a string. The only operation allowed is to insert characters in the beginning of the string. 
How many minimum characters are needed to be inserted to make the string a palindrome string
*/
import java.io.* ;
import java.util.* ;

public class MinCharPalin{
	public int[] expandAroundCenter(String str, int left, int right, int n){
        int ind[] = new int[2] ;
        while(left>=0 && right<=n-1){
            if(str.charAt(left)!=str.charAt(right))
                break ;
            left-- ;
            right++ ;
        }
        left++ ;
        right-- ;
        if(right<left){
            ind[0] = -1 ;
            ind[1] = -1 ;
        }
        else{ 
            ind[0] = left ;
            ind[1] = right ;
        }
        return ind ;
    }
    public int solve(String str) {
        int n = str.length() ;
        if(n==0 || n==1)
            return 0 ;
        if(n==2){
            if(str.charAt(0)==str.charAt(1))
                return 0 ;
            else
                return 1 ;
        }
        int i;
        int ind[] = new int[2] ;
        ind[0] = -1 ;
        ind[1] = -1 ; 
        int minLen = n ;
        for(i=0;i<=n/2;i++){
            //System.out.println("odd i " + i) ; 
            ind = expandAroundCenter(str,i,i,n) ;
            //System.out.println("left " + ind[0]) ;
            if(ind[0]==0)
               minLen = Math.min(minLen,n-ind[1]-1) ;  
            //System.out.println("even i " + i) ;
            ind = expandAroundCenter(str,i,i+1,n) ;
            //System.out.println("left: " + ind[0]) ;
            if(ind[0]==0)
                minLen = Math.min(minLen,n-ind[1]-1) ; 
        }
        return minLen ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-->0){
    		String str = scr.nextLine() ;
    		MinCharPalin mCharPal = new MinCharPalin() ;
    		System.out.println(mCharPal.solve(str)) ; 
    	}
    }
}