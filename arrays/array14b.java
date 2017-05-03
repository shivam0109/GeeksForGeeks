//Write a program to print all the LEADERS in the array. 
//An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. 
//For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

import java.io.* ;
import java.util.* ;

public class array14b{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j;
		for(j=0;j<ntest;j++){
			List<Integer> arrlist = new ArrayList<Integer>();
			int size = scr.nextInt();
			int arr[] = new int[size];
			for(i=0;i<size;i++)
				arr[i] = scr.nextInt();
			arrlist.add(arr[size-1]);
			i = size-2;
			int max = arr[size-1];
			while(i>=0){
				if(arr[i]>=max){
					arrlist.add(arr[i]);
					max = arr[i];
				}
				i = i -1;
			}
			i = arrlist.size()-1;
			while(i>=0){
				System.out.printf("%d ",arrlist.get(i));
				i = i-1;
			}
			System.out.printf("\n");
		}
	}
}