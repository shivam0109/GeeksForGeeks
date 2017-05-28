//convert a tree to double tree 
//create a new duplicate for each node, and insert the duplicate as the left child of the original node.

import java.io.* ;
import java.util.* ;

public class Tree28{
	Node root;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = right = null ;
		}
	}
	static void doubleTree(Node root){
		if(root==null)
			return ;
		Node temp = new Node(root.data) ;
		Node temp2 = root.left ; 
		root.left = temp ;
		temp.left = temp2 ;
		doubleTree(root.left.left) ;
		doubleTree(root.right) ;
	}
	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left) ;
		System.out.printf("%d ",root.data);
		inorder(root.right) ;
	}
	public static void main(String[] args){
		Tree28 tree = new Tree28() ;
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        doubleTree(tree.root) ;
        inorder(tree.root) ;
        System.out.printf("\n") ;
	}
}