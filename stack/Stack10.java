//reverse a stack using recursion

import java.io.* ;
import java.util.* ;

public class Stack10{
	static final int max = 100;
	int top;
	int arr[] = new int[max];
	int bottom;

	Stack10(){
		top = -1;
		bottom = 0;
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

	boolean isEmpty(){
		return(top<0);
	}

	int pop(){
		if(top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			int x = arr[top];
			top = top-1;
			return x;
		}
	}

	int pop2(){
		if(bottom>top){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{			
			int x = arr[bottom];
			bottom = bottom + 1;
			return x;
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

	static void recprint(Stack10 s){
		if(s.bottom<=s.top){
			System.out.println(s.pop2());
			//System.out.printf("top: %d ",top);
			recprint(s);
		}
	}

	public static void main(String[] args){
		Stack10 s = new Stack10();
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		recprint(s);
	}

}