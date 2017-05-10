//O(n) solution to determine if a tree is height balanced 

//If min distance of leaf from root is atmost 1 less than max distance of leaf from root. 
//Then tree is height balanced.

import java.io.* ;
import java.util.* ;

public class Tree11_2{
	Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static int minDis(Node root){
		if(root==null)
			return 0;
		else
			return 1 + Math.min(minDis(root.left),minDis(root.right));
	}
	static int height(Node root){
		if(root==null)
			return 0;
		else 
			return 1 + Math.max(height(root.left),height(root.right));
	}
	public static void main(String[] args){
		Tree11_2 tree = new Tree11_2();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //tree.root.left.left.left = new Node(8);
        if(height(tree.root)-minDis(tree.root) > 1)
        	System.out.println("false");
        else
        	System.out.println("true"); 
	}
}