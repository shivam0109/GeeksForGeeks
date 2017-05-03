//The stock span problem is a financial problem where we have a series of n daily price quotes for a stock 
//and we need to calculate span of stock’s price for all n days. 

//The span Si of the stock’s price on a given day i is defined as the 
//maximum number of consecutive days just before the given day, 
//for which the price of the stock on the current day is less than or equal to its price on the given day.
//For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
//then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}

import java.io.* ;
import java.util.* ;

public class Stack8{
	public static void main(String[] args){
		Stack<Integer> s = new Stack<Integer>();
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int price[] = new int[size];
		int i;
		for(i=0;i<size;i++)
			price[i] = scr.nextInt();
		System.out.printf("%d ",1);
		s.push(0);
		for(i=1;i<size;i++){
			//System.out.println("peek " + s.peek());
			while(!s.empty() && price[s.peek()]<=price[i])
				s.pop();

			if(s.empty())
				System.out.printf("%d ",i+1);
			else
				System.out.printf("%d ",i-s.peek());
			
			s.push(i);
		}
		System.out.printf("\n");
	}
}