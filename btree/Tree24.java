//Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in 
//left and right children, construct the Binary Tree and return root.

import java.io.* ;
import java.util.* ;

public class Tree24{
	Node root;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = null ;
			right = null ;
		}
	}
	static int findRoot(int[] in, int start, int end){
		int i ;
		int rootIndex = start;
		int max = in[start];
		for(i=start+1;i<=end;i++){
			if(in[i]>max){
				max = in[i];
				rootIndex = i;
			}
		}
		return rootIndex ;
	}
	static Node buildSplTree(int[] in, int start, int end){
		if(start>end)
			return null ;
		if(start==end){
			Node temp = new Node(in[start]) ;
			return temp ;
		}
		else{
			int rootIndex = findRoot(in,start,end) ;
			Node root = new Node(in[rootIndex]) ;

			root.left = buildSplTree(in,start,rootIndex-1) ;
			root.right = buildSplTree(in,rootIndex+1,end) ;

			return root ;
		}
	}
	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left) ;
		System.out.printf("%d ", root.data) ;
		inorder(root.right) ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int n = scr.nextInt() ;
		int i;
		int arr[] = new int[n] ; 
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt() ;

		Node root = buildSplTree(arr,0,n-1) ;
		inorder(root) ;
		System.out.printf("\n")
	}
}