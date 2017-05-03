//Sort a stack using recursion.

//On similar lines with reverse a stack using recursion. 

import java.io.* ;
import java.util.* ;

public class Stack12{
	int top = -1;
	static final int max = 100;
	int arr[] = new int[max];

	boolean isEmpty(){
		return (top<0);
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

	int peek(){
		if(top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else
			return arr[top];
	}

	int pop(){
		if(top<0){
			System.out.println("Stack Underflow");
			return  -1;
		}
		else{
			int x = arr[top];
			top = top-1;
			return x;
		}
	}

	static void insert(Stack12 s, int item){
		if(s.isEmpty() || s.peek() <= item){
			s.push(item);
		}
		else{
			int temp = s.pop();
			insert(s,item);
			s.push(temp);	
		}
	}

	static void sort(Stack12 s){
		if(!s.isEmpty()){
			int temp = s.pop();
			sort(s);
			insert(s,temp);
		}							
	}

	static void printstack(Stack12 s){
		while(!s.isEmpty()){
			System.out.printf("%d ",s.pop());
		}
		System.out.printf("\n");
	}

	public static void main(String[] args){
		Stack12 s = new Stack12();
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int i;
		for(i=0;i<size;i++)
			s.push(scr.nextInt());
		sort(s);
		printstack(s);
	}

}