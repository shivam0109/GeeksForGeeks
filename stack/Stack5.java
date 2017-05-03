//Program to check for balanced paranthesis. 

import java.io.* ;
import java.util.* ;

public class Stack5{
	static final int max = 1000;
	int top;
	char a[] = new char[max];

	boolean isEmpty(){
		return(top<0);
	}

	boolean push(char c){
		if(top>=max-1){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			top = top +1;
			a[top] = c;
			return true;
		}
	}

	char pop(){
		if(top<0){
			System.out.println("Stack Underflow");
			return (char)'1';
		}
		else{
			char c = a[top];
			top = top-1;
			return c ;
		}
	}

	char peek(){
		if(top<0){
			System.out.println("Stack Underflow");
			return (char)'1';
		}
		else
			return a[top];
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		String input = scr.nextLine();
		int i;
		int flag = 0;
		char c;
		Stack5 s = new Stack5();
		for(i=0;i<input.length();i++){

			c = input.charAt(i);

			if(c=='('||c=='{'||c=='['){
				s.push(c);
				continue;
			}
			
			if(c==')'){
				while(s.peek()!='('){
					s.pop();
					if(s.isEmpty()){
						flag = 1;
						System.out.println(1);
						break;
					}
				}
				if(flag==1)
					break;
				else
					continue;
			}

			if(c=='}'){
				while(s.peek()!='{'){
					s.pop();
					if(s.isEmpty()){
						flag = 1;
						System.out.println(2);
						break;
					}
				}
				if(flag==1)
					break;
				else
					continue;
			}

			if(c==']'){
				while(s.peek()!='['){
					s.pop();
					if(s.isEmpty()){
						flag = 1;
						System.out.println(3);
						break;
					}
				}
				if(flag==1)
					break;
				else
					continue;
			}			

		}

		if(flag==1)
			System.out.println("unbalanced");
		else
			System.out.println("balanced");

	}
}