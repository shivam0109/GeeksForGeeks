//Evaluate a postfix expression. 

import java.util.* ;
import java.io.* ;

public class Stack6{
	static final int max = 100;
	int top;
	int a[] = new int[max];

	boolean isEmpty(){
		return(top<0);
	}

	boolean push(int x){
		if(top>=max-1){
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
			return -1;
		}
		else{
			int x = a[top];
			top = top-1;
			return x;
		}
	}

	int peek(){
		if(top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else{
			return a[top];
		}
	}

	static int mathop(char c, int x, int y){
		switch(c){
			case '^' : return x^y ;
			case '/' : return x/y ;
			case '*' : return x*y ;
			case '+' : return x+y ;
			case '-' : return x-y ;
		}
		return -1;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		String input = scr.nextLine();
		Stack6 s = new Stack6();
		int i;
		char c;
		for(i=0;i<input.length();i++){
			c = input.charAt(i);
			if(Character.isDigit(c)){
				int num = c - '0' ;
				s.push(num);
			}
			else{
				int y = s.pop();
				int x = s.pop();
				int ans = mathop(c,x,y);
				s.push(ans);
			}
			//System.out.println(s.peek());
		}
		System.out.println(s.pop());
	}

}