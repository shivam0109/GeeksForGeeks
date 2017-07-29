/*
Given a string, find the length of the longest substring without repeating characters.
*/

import java.io.* ;
import java.util.* ;

public class LSubWithoutRep{
	public int lengthOfLongestSubstring(String str) {
        if(str.equals(""))
            return 0 ;
        int[] arr = new int[256] ;
        int start = 0;
        int end = 0;
        int maxLen = 1;
        int currLen = 0;
        for(int i=0; i<256; i++)
            arr[i] = -1; 
        while(end<=str.length()-1){
            //System.out.println("start " +start + " end " + end) ;
            char c = str.charAt(end) ;
            //System.out.println(c) ;
            if(arr[c]==-1){
                //System.out.println("In 1: " + c) ;
                arr[c] = end ;
                end++ ;
                currLen++ ; 
            }
            else if(arr[c]!=-1 && arr[c]>=start){
                //System.out.println("In 2: " + c) ;
                start = arr[c] + 1;
                currLen = end-start+1 ;
                arr[c] = end ;
                end++ ;
            }
            else{
                //System.out.println("In 3: " + c) ;
                arr[c] = end ;
                end++ ;
                currLen++ ;
            }
            if(currLen>maxLen)
                maxLen = currLen ;
        }
        return maxLen ; 
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-- > 0){
    		String str = scr.next() ;
    		LSubWithoutRep obj = new LSubWithoutRep() ;
    		int ans = obj.lengthOfLongestSubstring(str) ; 
    		System.out.println(ans) ;
    	}
    }
}