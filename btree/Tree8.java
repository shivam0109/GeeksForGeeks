//Count number of leaves in a binary tree. 

import java.io.* ;
import  java.util.* ;

public class Tree8{
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
	static int getLeafCount(Node root){
		if(root==null)
			return 0;
		else if(root!=null && root.left == null && root.right==null)
			return 1 ;
		else 
			return getLeafCount(root.left) + getLeafCount(root.right);
	}
	public static void main(String[] args){
		Tree8 tree = new Tree8();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);       	
       	System.out.println(getLeafCount(tree.root));
	}
}