//Convert infix expression to postfix expression. 

//Algo: 
//1. If input is operand, output it.
//2. Create a function of precedence of operators.
//3. A lower order operator can't stay with higher operator.
//4. If a lower order operator is input, pop the stack until the input op has a higher precedence.
//5. Push it to the stack.
//6. Brackets are special. They have precedence 0 and when a bracket closes, pop all the operators inside the bracket.

import java.io.* ;
import java.util.* ;

public class Stack2{
	
	static final int max = 1000;
	int top;
	char a[] = new char[max];
	
	Stack2(){
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
			System.out.println("Stack Underflow");
			return (char)'1' ;
		}
		else{
			char c = a[top];
			top = top-1;
			return c;
		}
	}

	char peek(){
		return a[top];
	}

	static int prec(char c){
		switch(c){
			case '^' : return 3;
			case '/' : return 2;
			case '*' : return 2;
			case '+' : return 1;
			case '-' : return 1;
		}
		return 0;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		String input = scr.nextLine();
		String output = "" ;
		Stack2 s = new Stack2();
		int i;
		char c;
		for(i=0;i<input.length();i++){
			c = input.charAt(i);
			
			if((c>='a' && c<='z') || (c>='A' && c<='B')){
				output += c;
				continue;
			}

			if(c=='('){
				s.push(c);
				continue;
			}

			if(c==')'){
				while(s.peek()!='('){
					output += s.pop();
				}
				s.pop();
				continue;
			}

			if(s.isEmpty()){
				s.push(c);
				continue;
			}

			else{
				if(prec(c)>prec(s.peek())){
					s.push(c);
					continue;
				}
				else{
					while(prec(c)<=prec(s.peek())){
						output += s.pop();
						if(s.isEmpty())
							break;
					}
					s.push(c);
				}
			}

		}

		if(!s.isEmpty())
			output += s.pop();

		System.out.println(output);
	
	}

}