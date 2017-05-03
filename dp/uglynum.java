//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
//The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
//Given a number n, the task is to find n’th Ugly number using DP.

//we know 1 is an ugly number. to find the next ugly number we multiply 1 by 2,3 and 5 and take min. 
//next ugly number is 2 and w eincrease the pointer of 2 by 1. We repeat this for n.  

import java.io.* ;
import java.util.* ;

public class uglynum{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int i,j,k;
		int ntest = scr.nextInt();
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			arr[0] = 1;
			int i2 = 0;
			int i3 = 0;
			int i5 = 0;
			int next = 1;
			int next2 = 2;
			int next3 = 3; 
			int next5 = 5;
			for(i=1;i<n;i++){
				next = Math.min(next2,Math.min(next3,next5));
				arr[i] = next;
				if(next==next2){
					i2 = i2 + 1;
					next2 = arr[i2]*2;
				}
				if(next == next3){
					i3 = i3 + 1;
					next3 = arr[i3]*3;
				}
				if(next==next5){
					i5 = i5 + 1;
					next5 = arr[i5]*5;
				}	
			}
			for(i=0;i<n;i++)
				System.out.printf("%d ",arr[i]);
			System.out.printf("\n");
			System.out.println(next);
		}
	}
}