/*
Multiply two strings. 
*/
public class MultiplyTwoStrings {
    public String addZeros(String str, int num){
        for(int i=0; i<num; i++)
            str = str.concat("0") ; 
        return str ; 
    }
    public String removeLeadingZeros(String str){
        int len = str.length() ;
		int i=0 ;
		for(i=0;i<len;i++){
			if(str.charAt(i)!='0')
				break ;
		}
		if(i==len)
			return "0" ; 
		return str.substring(i,len) ; 
    }
    public String addTwoStrings(String str1, String str2){
        //System.out.println("String1: " + str1 + " String2: " + str2) ;
        int len1 = str1.length() ;
        int len2 = str2.length() ;
        if(len1==0)
            return str2 ;
        if(len2==0)
            return str1 ;
        if(len2>len1)
            return addTwoStrings(str2,str1) ;
        String addString = "" ;
        int num = 0 ;
        int num1 = 0 ;
        int num2 = 0 ;
        int i=len1-1 ;
        int j=len2-1 ;
        boolean carry = false ;
        while(i>=0 && j>=0){
            num1 = Integer.valueOf(str1.charAt(i))-48 ;
            num2 = Integer.valueOf(str2.charAt(j))-48 ;
            if(carry)
                num = num1+num2+1 ;
            else
                num = num1+num2 ;
            //System.out.println("num: " + num) ;
            if(num>=10){
                carry = true ;
                num = num-10 ;
            }
            else
                carry = false ; 
            // addString = addString.concat(String.valueOf(num)) ;
            addString = String.valueOf(num).concat(addString) ;
            i-- ;
            j-- ;
        }
        while(i>=0){
            num1 = Integer.valueOf(str1.charAt(i))-48 ;
            if(carry)
                num = num1+1 ;
            else
                num = num1 ;
            if(num>=10){
                carry = true ;
                num = num-10 ;
            }
            else
                carry = false ;
            // addString = addString.concat(String.valueOf(num)) ;
            addString = String.valueOf(num).concat(addString) ;
            i-- ;
        }
        if(carry)
            addString = "1".concat(addString) ;
        return addString ; 
    }
    public String multiply(String str1, String str2) {
        int len1 = str1.length() ;
        int len2 = str2.length() ;
        if(len1==0 || len2==0)
            return "" ;
        if(len2>len1)
            return multiply(str2,str1) ; 
        int i=len2-1 ;
        int j=len1-1 ;
        int num1 = 0 ;
        int num2 = 0 ;
        String ans = "" ; 
        int carry = 0 ;
        int mul = 0 ;
        String ansLevel = "" ;
        while(i>=0){
            ansLevel = "" ;
            num1 = Integer.valueOf(str2.charAt(i))-48 ;
            j = len1-1 ;
            while(j>=0){
                //System.out.println("Inside second loop") ;
                num2 = Integer.valueOf(str1.charAt(j))-48 ;
                mul = num1*num2 + carry ; 
                carry = mul/10 ;
                mul = mul%10 ;
                // System.out.println("Mul: " + mul) ;
                // System.out.println("carry: " + carry) ;
                //ansLevel = ansLevel.concat(String.valueOf(mul)) ;
                ansLevel = String.valueOf(mul).concat(ansLevel) ;
                j-- ;
            }
            //ansLevel = reverse(ansLevel) ;
            if(carry!=0){
                ansLevel = String.valueOf(carry).concat(ansLevel) ;
                carry = 0 ;
            }
            //System.out.println("Before adding zeros ansLevel: " + ansLevel); 
            ansLevel = addZeros(ansLevel,len2-i-1) ;
            //System.out.println("After adding zeros ansLevel: " + ansLevel);
            //System.out.println("Before adding strings ans: " + ans) ;
            ans = addTwoStrings(ans,ansLevel) ; 
            //System.out.println("After adding two strings: " + ans) ;
            i-- ;
        }
        if(carry!=0)
            ans = String.valueOf(carry).concat(ans) ;
        ans = removeLeadingZeros(ans) ;
        return ans ; 
    }
    public static void main(String[] args){
    	String str1 = "123"  ;
    	String str2 = "987"  ;
    	MultiplyTwoStrings mul = new MultiplyTwoStrings() ;
    	System.out.println(mul.multiply(str1,str2)) ; 
    }
}