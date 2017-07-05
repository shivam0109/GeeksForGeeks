//Given a sorted array of integers, every element appears twice except for one. 
//Find that single one in linear time complexity and without using extra memory.

//USE XOR 
import java.io.* ;
import java.util.* ;

public class SingleAppearanceElement{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			int arr[] = new int[n] ;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt() ;
			int ans = arr[0];
			for(i=1;i<n;i++)
				ans = ans^arr[i] ;
			System.out.println(ans) ;
		}
	}
}