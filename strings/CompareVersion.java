/*
Compare two version numbers version1 and version2.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", 
it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
*/ 

/*
Corner Cases: 
Can't use parseInt : Write custom method to compare two numbers as strings. 
Remove Leading Zeros.
1.0,1.000000000000 and 1 are same. 
*/

import java.io.* ;
import java.util.* ;

public class CompareVersion{
	public boolean allZero(String[] arr, int len, int index){
        int i;
        //System.out.println("index: " + index) ; 
        for(i=index;i<len;i++){
            String str = arr[i] ;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)!='0')
                    return false ;
            }
        }
        return true ;
    }
    public String removeLeadingZeros(String str){
        int i=0 ;
        int len = str.length() ;
        while(i<len && str.charAt(i)=='0')
            i++ ;
        if(i==len)
            return "0" ;
        return str.substring(i,len) ; 
    }
	public int compareUtil(String str1, String str2){
		str1 = removeLeadingZeros(str1) ;
		str2 = removeLeadingZeros(str2) ; 
		int len1 = str1.length() ;
		int len2 = str2.length() ;
		int i=0 ;
		int j=0 ;
		if(str1.equals(str2))
			return 0 ;
		if(len1>len2)
		    return 1 ;
		if(len2>len1)
		    return -1 ;
		for(i=0;i<len1;i++){
		    if(str1.charAt(i)>str2.charAt(i))
		        return 1 ;
		    if(str1.charAt(i)<str2.charAt(i))
		        return -1 ;
		}
		return 0 ;
	}
	public int compareVersion(String ver1, String ver2) {
	    if(ver1.equals(ver2))
			return 0 ;
		String[] v1 = ver1.split("\\.") ; 
		String[] v2 = ver2.split("\\.") ;
		int m = v1.length ;
		int n = v2.length ;
		int i = 0 ;
		int j = 0 ;
		while(i<m && j<n){
			String str1 = v1[i] ;
			String str2 = v2[j] ;
			//System.out.println("version1 element: " + str1) ;
			//System.out.println("version2 element: " + str2) ;
			int bigger = compareUtil(str1,str2) ;
			//System.out.println("bigger: " + bigger) ; 
			if(bigger!=0)
				return bigger ;
			i++ ;
			j++ ;
		}
		if(i!=m){
			if(!allZero(v1,m,i))
			    return 1 ;
		}
		if(j!=n){
			if(!allZero(v2,n,j))
			    return -1 ;
		}
		return 0 ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		scr.nextLine() ;
		while(ntest-- > 0){
			String ver1 = scr.nextLine() ;
			String ver2 = scr.nextLine() ;
			CompareVersion cmp = new CompareVersion() ;
			//System.out.println("parsing: " + Integer.parseInt("01")) ; 
			System.out.println(cmp.compareVersion(ver1,ver2)) ;  
		}
	}
}