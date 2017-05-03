//reverse a string using stack

import java.io.*;
import java.util.*;
import java.lang.* ;


public class Stack3{
	static final int max = 1000;
	int top;
	char a[] = new char[max];


	Stack3(){
		top = -1;
	}

	boolean isEmpty(){
		return (top<0);
	}

	boolean push(char c){
		if(top>=max){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			top = top + 1;
			a[top] = c;
			return true;
		}
	}

	char pop(){
		if(top<0){
			System.out.println("Stack UNderflow");
			return (char)'1';
		}
		else{
			char c = a[top];
			top = top-1;
			return c;
		}
	}

	public static void main(String[] args){
		Stack3 s = new Stack3();
		Scanner scr = new Scanner(System.in);
		String str = scr.nextLine();
		int i;
		char c;
		for(i=0;i<str.length();i++){
			c = str.charAt(i) ;
			s.push(c);
		}
		while(!s.isEmpty()){
			System.out.printf("%c",s.pop());
		}
		System.out.printf("\n");
	}
}