//Write a program to find the majority element in the array. A majority element in an array A[] of size n 
//is an element that appears more than n/2 times (and hence there is at most one such element)
//If input array doesn't contain a majority element, then output "NO Majority Element"

//Using voting method..Initialize maj_index = 0 and count = 1.
//If the next element is same then we increase the count, if different, we decrease the count.
//If count reaches 0, we change the majority index to the current index and set count = 1.
//This gives us possible majority index. We have to check this by comparing it by size/2. 
import java.util.*;
import java.io.*;

public class array2b{
	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int arr[] = new int[size];
			int i;
			int maj_index = 0, count = 1;
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt();
			}
			for(i=1;i<size;i++){
				if(arr[maj_index] == arr[i])
					count = count + 1;
				else 
					count = count - 1;
				if(count == 0){
					maj_index = i;
					count = 1;
				}
			}
			System.out.println(maj_index);
			int count2 = 0;
			for(i=0;i<size;i++){
					if(arr[i]==arr[maj_index]){
						count2 = count2 + 1;
				}
			}
			if(count2>size/2)
				System.out.println(arr[maj_index]);
			else 
				System.out.println("No Majority Element");
			
		}
	}
}