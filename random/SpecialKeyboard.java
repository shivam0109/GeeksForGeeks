//Imagine you have a special keyboard with the following keys: 
//Key 1:  Prints 'A' on screen
//Key 2: (Ctrl-A): Select screen
//Key 3: (Ctrl-C): Copy selection to buffer
//Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed. 

//If you can only press the keyboard for N times (with the above four keys), 
//write a program to produce maximum numbers of A's. 
//That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).

import java.io.* ;
import java.util.* ;

public class SpecialKeyboard{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int i;
			int arr[] = new int[n+1];
			for(i=1;i<=n;i++){
				if(i<7)
					arr[i] = i;
				else 
					arr[i] = Math.max(3*arr[i-4],4*arr[i-5]) ;
			}
			System.out.println(arr[n]);
		}
	}
}