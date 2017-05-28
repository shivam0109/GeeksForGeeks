//Boundary Traversal for binary trees. 

import java.io.* ;
import java.util.* ;

public class Tree26_2{
	Node root;
	static class Node{
		Node left,right ;
		int data ;
		Node(int d){
			data = d;
			left = null;
			right = null ;
		}
	}
	static void printLeaf(Node root){
		if(root==null)
			return ;
		
		if(root.left==null && root.right == null)
			System.out.printf("%d ",root.data) ;

		printLeaf(root.left) ;
		printLeaf(root.right) ;
	}
	static void printLeft(Node root){
		while(root.left!=null){
			System.out.printf("%d ",root.data) ;
			root = root.left ;
		} 
	}
	static void printRight(Node root){
		root = root.right ;
		while(root.right!=null){
			System.out.printf("%d ",root.data) ;
			root = root.right ;
		}
	}
	public static void main(String[] args){
		Tree26_2 tree = new Tree26_2() ;
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);

        printLeft(tree.root) ;
        printLeaf(tree.root) ;
        printRight(tree.root) ;
	}
}