//Convert a given tree to its sum tree

import java.io.* ;
import java.util.* ;

public class Tree30{
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = null;
			right = null ;
		}
	}
	static void traversal1(Node root){
		int left,right ;
		if(root==null)
			return ;		
		
		if(root.left==null)
			left = 0;
		else
			left = root.left.data ;
		
		if(root.right==null)
			right = 0 ;
		else
			right = root.right.data ;
	
		root.data = left + right ;
		traversal1(root.left) ;
		traversal1(root.right) ;
	}
	static void traversal2(Node root){
		int left,right ;
		if(root==null)
			return ;
		traversal2(root.left) ;
		traversal2(root.right) ;
		if(root.left==null)
			left = 0;
		else
			left = root.left.data ;
		if(root.right==null)
			right = 0;
		else 
			right = root.right.data ;
		
		//System.out.println("root  " + root.data) ;
		root.data = root.data + left + right ;
	}
	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left) ;
		System.out.printf("%d ", root.data) ;
		inorder(root.right) ;
	}
	public static void main(String[] args){
		Tree30 tree = new Tree30() ;
		tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(5);
        tree.root.right.right.right.right = new Node(6);
        tree.root.right.right.right.right.right = new Node(7);
        tree.root.right.right.right.right.right.left = new Node(8);

       	traversal1(tree.root) ;
       	//inorder(tree.root) ;
       	//System.out.printf("\n") ;
       	traversal2(tree.root) ;
       	inorder(tree.root) ;
       	System.out.printf("\n") ;
	}	
}