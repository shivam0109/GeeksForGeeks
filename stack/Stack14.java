//Length of Longest Valid Substring.
//Given a string consisting of opening and closing parenthesis, 
//find length of the longest valid parenthesis substring.

import java.io.* ;
import java.util.* ;

public class Stack14{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		Stack<Character> s = new Stack<Character>();
		String str = scr.nextLine();
		int i;
		int count = 0;
		for(i=0;i<str.length();i++){
			int flag = 0;
			char c = str.charAt(i);
			if(c=='('){
				s.push(c);
				System.out.println("( pushed");
				continue;
			}
			else{
				while(!s.empty()){
					if(s.pop() == '('){
						System.out.println("found");
						flag = 1;
						break;
					}
				}
				if(flag==1){
					count = count + 2;
					System.out.println("Increasing count");
				}
				else{
					System.out.println("Not found");
				}	
			}
		}
		System.out.println(count);
	}
}