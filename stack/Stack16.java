//Given an integer array of size n, 
//find the maximum of the minimum’s of every window size in the array. 
//Note that window size varies from 1 to n.

import java.io.*;
import java.util.* ;

public class Stack16{
	static final int max = 100;
	int top;
	Stack16(){
		top = -1;
	}
	static int arr[] = new int[max];

	boolean isEmpty(){
		return(top<0);
	}

	boolean push(int x){
		if(top>=max){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			top = top+1;
			arr[top] = x
			return true;
		}
	}

	int peek(){
		if(top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			return arr[top];
		}
	}

	int pop(){
		if(top<0){
			System.out.println("Stack UNderflow");
			return -1;
		}
		else{
			int x = arr[top];
			top = top-1;
			return x;
		}
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int i;
		int size = scr.nextInt();
		int arr[] = new int[size];
		for(i=0;i<size;i++)
			arr[i] = scr.nextInt();
		
	}
}