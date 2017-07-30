/*
Write a function to find the longest common prefix string amongst an array of strings.
*/


import java.io.* ;
import java.util.* ;

public class LongestCommonPrefix1{
	public int findMinLength(String[] strs){
        int i=0 ;
        int minLen = strs[0].length() ;
        int minLenIndex = 0 ;
        int len = strs.length ;
        for(i=1;i<len;i++){
            if(strs[i].length()<minLen){
                minLen = strs[i].length() ;
                minLenIndex = i ;
            }
        }
        return minLenIndex ;
    }
    public String commonPrefix(String str1, String str2){
        int len1 = str1.length() ;
        int len2 = str2.length() ;
        int i=0 ;
        int j=0 ;
        String common = "" ;
        while(i<len1 && j<len2){
            if(str1.charAt(i)==str2.charAt(j)){
                common = common.concat(String.valueOf(str1.charAt(i))) ;
                i++ ;
                j++ ;
            }
            else
                break ;
        }
        return common ;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "" ;
        int minLenIndex = findMinLength(strs) ;
        String compareWith = strs[minLenIndex] ;
        int i ;
        String ans = "" ;
        for(i=0;i<strs.length;i++){
            if(i==0)
                ans = commonPrefix(compareWith,strs[0]) ;
            else
                ans = commonPrefix(ans,strs[i]) ;
        }
        return ans ;
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		int n = scr.nextInt() ;
    		String[] strs = new String[n] ; 
    		for(int i=0; i<n ;i++){
    			strs[i] = scr.next() ;
    		}
    		LongestCommonPrefix1 lcp = new LongestCommonPrefix1() ;
    		String prefix = lcp.longestCommonPrefix(strs) ;
    		System.out.println(prefix) ; 
    	}
    }
}