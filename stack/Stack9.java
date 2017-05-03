//reverse a stack

import java.io.* ;
import java.util.* ;

public class Stack9{
	static final int max = 100;
	int top = -1;
	int bottom = 0;
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

	int pop(){
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

	public static void main(String[] args){
		Stack9 s = new Stack9();
		boolean a = false;
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		a = s.push(4);
		//System.out.println(a);
		System.out.printf("%d %d %d %d %d",s.pop(),s.pop(),s.pop(),s.pop(),s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop()); 

	}
}