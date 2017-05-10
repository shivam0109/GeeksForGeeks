//Threaded Binary Tree 

import java.io.* ;
import java.util.* ;

public class Tree7{
	static class Node{
		int data;
		Node left, right ;
		boolean rightThread ;	
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static Node leftmost(Node root){
		if(root==null)
			return null;
		else{
			while(root.left!=null)
				root = root.left ;
			return root;
		}
	}
	static void inOrder(Node root){
		Node cur = 
	}	
}