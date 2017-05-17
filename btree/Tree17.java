//Consider a coding system for alphabets to integers where ‘a’ is represented as 1, ‘b’ as 2, .. ‘z’ as 26. 
//Given an array of digits (1 to 9) as input, write a function that prints all valid interpretations of input array.

import java.io.* ;
import java.util.* ;

public class Tree17{
	Node root;
	static class Node{
		Node left,right;
		String data;
		Node(String d){
			data = d;
			left = null;
			right = null;
		}
	}
	static Node arrayToTree(int[] arr, int len){
		
	}
	public static void main(String[] args){
		Tree17 tree = new Tree17();
		Scanner scr = new Scanner(System.in);
		int len = scr.nextInt();
		int arr[] = new int[len];
		int i;
		for(i=0;i<len;i++)
			arr[i] = scr.nextInt();		
		tree.root = arrayToTree(arr,len);
	}
}