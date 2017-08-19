/*
Given an input string and a dictionary of words, 
find out if the input string can be segmented into a space-separated sequence of dictionary words
*/ 

/*
Key Concept : If we can make substring i,k and k+1,j from dictionary, we can make i,j from dictionary. 
Base Case : To see if i,i is in the dictionary or not. 
Fill the matrix diagonally. 
*/
import java.io.* ;
import java.util.* ;

public class WordBreak{
	public boolean canBreak(int i, int j, boolean[][] dp){
        int k ;
        for(k=i;k<j;k++){
            if(dp[i][k] && dp[k+1][j])
                return true ;
        }
        return false ; 
    }
    public void printMat(boolean[][] mat, int n){
    	int i,j;
    	for(i=0;i<n;i++){
    		for(j=0;j<n;j++)
    			System.out.print(mat[i][j] + " ") ;
    		System.out.printf("\n") ;
    	}
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Integer> map = new HashMap<String,Integer>() ;
        int i,j,l;
        for(i=0;i<wordDict.size();i++)
            map.put(wordDict.get(i),1) ;
        int n = s.length() ;
        if(n==0)
            return true ;
        boolean dp[][] = new boolean[n][n] ; 
        for(i=0;i<n;i++){
            if(map.containsKey(String.valueOf(s.charAt(i))))
                dp[i][i] = true ;
            else
                dp[i][i] = false ; 
        }	
        for(l=1;l<n;l++){
            for(i=0;i<n-l;i++){
            	System.out.println("i: " + i + " l: " + l) ;
                j = l+i ;
                if(map.containsKey(s.substring(i,j+1)) || canBreak(i,j,dp))
                    dp[i][j] = true ;
                else
                    dp[i][j] = false ;
            }
        }
        printMat(dp,n) ;
        return dp[0][n-1] ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ; 
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		String str ; 
    		List<String> list = new ArrayList<String>() ;
    		int i ;
    		for(i=0;i<n;i++){
    			str = scr.next() ;
    			list.add(str) ;
    		}
    		str = scr.next() ;
			WordBreak wb = new WordBreak() ;
			System.out.println(wb.wordBreak(str,list)) ; 
    	}
    }
}