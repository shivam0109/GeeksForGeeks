//Create a data structure twoStacks that represents two stacks. 
//Implementation of twoStacks should use only one array, i.e., 
//both stacks should use the same array for storing elements. 
//Following functions must be supported by twoStacks.

//push1(int x) –> pushes x to first stack
//push2(int x) –> pushes x to second stack

//pop1() –> pops an element from first stack and return the popped element
//pop2() –> pops an element from second stack and return the popped element

//Implementation of twoStack should be space efficient.


//One stack from bottom to top and other from top to bottom. 


import java.io.* ;
import java.util.*;

public class Stack4{
	static final int max = 100;	
	int top1;
	int top2;
	int a[] = new int[max];

	Stack4(){
		top1 = -1;
		top2 = max;
	}

	boolean isEmpty1(){
		return(top1<0);
	}

	boolean isEmpty2(){
		return(top2>=max);
	}

	boolean push1(int x){
		if(top1>=top2-1){
			System.out.println("Stack1 Overflow");
			return false;
		}
		else{
			top1 = top1 + 1;
			a[top1] = x;
			return true;
		}
	}

	boolean push2(int x){
		if(top2<=top1+1){
			System.out.println("Stack2 Overflow");
			return false;
		}
		else{
			top2 = top2-1;
			a[top2] = x;
			//System.out.printf("top2: %d\n",top2);
			return true;
		}
	}

	int pop1(){
		if(top1<0){
			System.out.println("Stack1 Underflow");
			return -1;
		}
		else{
			int x = a[top1];
			top1 = top1-1;
			return x;
		}
	}

	int pop2(){
		//System.out.printf("max: %d top2: %d",max,top2);
		if(top2>=max){
			System.out.println("Stack2 Underflow");
			//System.out.println(a[top2]);
			return -1;
		}
		else{
			int x = a[top2];
			top2 = top2 + 1;
			return x;
		}
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		Stack4 sq = new Stack4();
		int ntest = scr.nextInt();
		int i,j;
		for(j=0;j<ntest;j++){
			int nq = scr.nextInt();
			for(i=0;i<nq;i++){
				int a = scr.nextInt();
				if(a==1){
					int b = scr.nextInt();
					if(b==1){
						int c = scr.nextInt();
						sq.push1(c);
					}
					else{
						System.out.printf("%d ",sq.pop1());
					}
				}
				else{
					int b = scr.nextInt();
					if(b==1){
						int c = scr.nextInt();
						sq.push2(c);
					}
					else{
						System.out.printf("%d ",sq.pop2());
					}
				}
			}
			System.out.printf("\n");			
		}
	}
}	