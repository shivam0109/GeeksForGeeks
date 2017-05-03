//Find next larger element on the right side in O(n).


import java.io.* ;
import java.util.* ;

public class Stack7{
	
	static final int max = 100;
	int top;
	int arr[] = new int[max];

	Stack7(){
		top = -1;
	}

	boolean push(int x){
		if(top>=max){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			top = top+1;
			arr[top] = x;
			return false;
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

	int peek(){
		if(top<0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else
			return arr[top];
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int size = scr.nextInt();
			//int arr[] = new int[size];
			int ans[] = new int[size];
			int x ;
			for(i=0;i<size;i++)
				ans[i] = -1;

			Stack7 s = new Stack7();
			int i = 0;
			s.push(scr.nextInt());
			for(j=1;j<size;j++){
				x = scr.nextInt();
				while(!s.isEmpty() && x>=s.peek()){
					ans[i] = x;
					s.pop();
				}
				s.push(x);
				i++;
			}

			for(i=0;i<size;i++)
				System.out.printf("%d ",ans[i]);

			System.out.printf("\n");
		}		
	}
}