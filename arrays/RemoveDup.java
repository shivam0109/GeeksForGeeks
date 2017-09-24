/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
*/

import java.io.* ;
import java.util.* ;

public class RemoveDup{
	public int removeDuplicates(ArrayList<Integer> a) {
	    int n = a.size() ;
	    if(n==0)
	        return 0 ;
	    if(n==1)
	        return 1 ;
	    int slow = 0 ;
	    int fast = 0 ;
	    while(fast<n){
	    	int x = a.get(slow) ;
	    	int y = a.get(fast) ; 
	        System.out.printf("%d %d\n", a.get(slow),a.get(fast)) ;
	        if(a.get(slow)==a.get(fast)){
	            System.out.println("In 1") ; 
	            System.out.printf("%d %d\n",slow,fast) ;
	            fast++ ;
	        }
	        else{
	            System.out.println("In 2") ;
	            System.out.printf("%d %d\n",slow,fast) ;
	            slow++ ;
	            a.set(slow,a.get(fast)) ;
	            fast++ ;
	        }
	    }
	    return slow+1 ;   
	}
	public static void main(String[] args){
		RemoveDup rd = new RemoveDup() ;
		Scanner scr = new Scanner(System.in) ;
		int n = scr.nextInt() ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		for(int i=0 ;i<n; i++)
			list.add(scr.nextInt()) ;
		System.out.println(rd.removeDuplicates(list)) ; 
	}
}