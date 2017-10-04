/*
Multiply two Strings.
*/ 

/*
Create a product array of length n1+n2+1. This would be the max length of the product string.
Now, i points to first string. j points to second string.
The element at i+j+1 would be the sum of all multiples corr to i+j+1.
After crating the product array, traverse from right and modify the elements and carry to get answer at i+j+1th place. 
*/

import java.io.* ;
import java.util.* ;

public class MultiplyTwoStringsBetter{
	public String multiply(String str1, String str2){
		int len1 = str1.length() ;
        int len2 = str2.length() ;
        int prod[] = new int[len1+len2] ;
        int i,j ;
        for(i=len1-1;i>=0;i--){
            for(j=len2-1;j>=0;j--){
                int num1 = Integer.valueOf(str1.charAt(i))-48 ;
                int num2 = Integer.valueOf(str2.charAt(j))-48 ;
                prod[i+j+1] += num1*num2 ; 
            }
        }
        //printArray(prod,len1+len2) ; 
        int len = prod.length ;
        int k;
        int carry = 0 ;
        for(k=len-1;k>=0;k--){
            prod[k] += carry;
            carry = prod[k]/10 ;
            prod[k] = prod[k]%10 ;
        }
        //printArray(prod,len1+len2) ;
        String str = "" ;
        k=0;
        while(k<prod.length && prod[k]==0)
            k++ ;
        if(k==prod.length)
            return "0" ;
        while(k<prod.length){
            str = str.concat(String.valueOf(prod[k])) ; 
            k++ ;
        }
        return str ;
	}
	public static void main(String[] args){
    	String str1 = "123"  ;
    	String str2 = "987"  ;
    	MultiplyTwoStringsBetter mul = new MultiplyTwoStringsBetter() ;
    	System.out.println(mul.multiply(str1,str2)) ; 
    }
}