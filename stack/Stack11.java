//reverse a stack using recursion

//idea is to first pop the elements and push them back again using recursive function insertAtBottom. 
//then write a recursive function which calls insertAtBottom to insert every element in the stack.
//first 0 goes to bottom(1st element of empty stack), then 1 goes to bottom, then 2 and so on.

import java.io.* ;
import java.util.* ;


public class Stack11{
	int top = -1;
	static final int max = 100;
	int arr[] = new int[max];

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
			arr[top] = x;
			return true;
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

	static void insertAtBottom(Stack11 s, int item){
		System.out.println("element : " + item + " ");
		if(s.isEmpty())
			s.push(item);
		else{
			int temp = s.pop();
			insertAtBottom(s,item);
			s.push(temp);
		}
	}

	static void reverse(Stack11 s){
		if(!s.isEmpty()){
			int temp = s.pop();
			System.out.println("before temp " + temp + " ");
			reverse(s);
			System.out.println("temp " + temp + " ");
			insertAtBottom(s,temp);
		}
	}

	public static void main(String[] args){
		Stack11 s = new Stack11();
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		reverse(s);
		System.out.printf("%d %d %d %d %d",s.pop(),s.pop(),s.pop(),s.pop(),s.pop());
	}
}