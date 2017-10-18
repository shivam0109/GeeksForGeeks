//Intro to Stack using arrays
//Stack has 4 methods : Push, Pop, isEmpty and Peek/Top. 


//top is the last index. 
import java.io.* ;
import java.util.* ;

public class Stack1{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];

	Stack1(){
		top = -1;
	}
	
	boolean isEmpty(){
		return (top<0);
	}

	boolean push(int x){
		if(top>=MAX){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			top = top+1;
			a[top] = x;
			return true;
		}
	}

	int pop(){
		if(top<0){
			System.out.println("Stack Underflow");
			return 0;
		}
		else{
			int x = a[top];
			top = top-1;
			return x;
		}
	}

	public static void main(String[] args){
		Stack1 s = new Stack1();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}
}