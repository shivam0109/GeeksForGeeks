//Write a program to find the majority element in the array. A majority element in an array A[] of size n 
//is an element that appears more than n/2 times (and hence there is at most one such element)
//If input array doesn't contain a majority element, then output "NO Majority Element"

//Using Hash table to find the number of occurences of each element and then compare it by size/2 
import java.util.*;
import java.io.*;

public class array2{
	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i;
		for(i=0;i<ntest;i++){
			int size = scr.nextInt();
			int j;
			int flag = 0;
			int arr[] = new int[size];
			for(j=0;j<size;j++){
				arr[j] = scr.nextInt();
			}
			HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
			for(j=0;j<size;j++){
				if(count.containsKey(arr[j])){
					count.put(arr[j],count.get(arr[j])+1);
				}
				else{
					count.put(arr[j],1);
				}
			}
			Set set = count.entrySet();
			Iterator iter = set.iterator();
			//int answer;
			while(iter.hasNext()){
				Map.Entry mentry = (Map.Entry)iter.next();
				if(Integer.valueOf((int)mentry.getValue())>(size/2)){
					System.out.println(mentry.getKey());
					flag = 1;
					break;
				}
			}
			if(flag==0){
				System.out.println("No Majority Element");
			}
		}
	}
}