//find diameter of a binary tree
//diameter is defined as maximum number of nodes that occur while travelling through two leaves. 

import java.io.* ;
import java.util.* ;

public class Tree6{
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
	static int height(Node root){
		if(root==null)
			return 0;
		else
			return Math.max(height(root.left)+1,height(root.right)+1);
	}
	static int diameter(Node root){
		if(root == null)
			return 0;
		else 
			return Math.max(height(root.left)+height(root.right)+1,Math.max(diameter(root.left),diameter(root.right))) ;
	}
	public static void main(String[] args){
		Tree6 tree = new Tree6();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);	
       	System.out.println(diameter(tree.root));
	}
}