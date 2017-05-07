//Determine size of a tree

import java.io.* ;
import java.util.* ;

public class Tree4{
	Node root = null;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static int findsize(Node root){
		int lsize;
		int rsize;
		if(root==null)
			return 0;
		else{
			lsize = findsize(root.left);
			rsize = findsize(root.right);
			return lsize+rsize+1;						
		}
	}
	public static void main(String[] args){
		Tree4 tree = new Tree4();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);
       	System.out.println(findsize(tree.root));
	}
}