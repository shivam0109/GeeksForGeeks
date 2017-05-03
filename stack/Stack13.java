//Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. 
//For simplicity, assume that all bars have same width and the width is 1 unit.

import java.io.* ;
import java.util.* ;

public class Stack13{
	static int[] leftbig(int arr[]){
		Stack<Integer> s = new Stack<Integer>();
		int ans[] = new int[arr.length];
		int i;
		s.push(0);
		ans[0] = 1;
		for(i=1;i<arr.length;i++){
			while(!s.isEmpty() && arr[s.peek()] >= arr[i])
				s.pop();
			if(s.isEmpty())
				ans[i] = i+1;
			else
				ans[i] = i-s.peek();
			s.push(i);
		}
		return ans;		
	}

	static void reversearr(int arr[]){
		int i;
		int temp;
		for(i=0;i<arr.length/2;i++){
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}

	static int max(int arr[]){
		int i;
		int max = arr[0];
		for(i=1;i<arr.length;i++){
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int arr[] = new int[size];
			int arr2[] = new int[size];
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt();
				arr2[i] = arr[i];
			}
			int leftans[] = new int[size];
			int rightans[] = new int[size];
			leftans = leftbig(arr);
			
			//for(i=0;i<size;i++)
			//	System.out.printf("%d ",leftans[i]);
			//System.out.printf("\n");
			
			reversearr(arr);
			rightans = leftbig(arr);
			reversearr(rightans);
			
			//for(i=0;i<size;i++)
			//	System.out.printf("%d ",rightans[i]);
			//System.out.printf("\n");
			

			for(i=0;i<size;i++)
				leftans[i] = leftans[i] + rightans[i] - 1;
			
			for(i=0;i<size;i++)
				leftans[i] = leftans[i]*arr2[i];
			
			//for(i=0;i<size;i++)
			//	System.out.printf("%d ",leftans[i]);
			//System.out.printf("\n");

			System.out.println(max(leftans));
		}
	}
}