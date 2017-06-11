//Convert an arbitrary Binary Tree to a tree that holds Children Sum Property


import java.io.* ;
import java.util.* ;

public class Tree29{
	Node root;
	static class Node{
		Node left,right; 
		int data;
		Node(int d){
			data = d;
			left = null ;
			right = null ;
		}
	}
	static void balanceNode(Node root){
		if(root.left!=null && root.right!=null){
			if(root.data-root.right.data>root.left.data)
				root.left.data = root.data - root.right.data ;
			if(root.data-root.left.data>root.right.data)
				root.right.data = root.data - root.left.data ;
			else
				root.data = root.left.data + root.right.data ;
		}
		if(root.left==null && root.right!=null){
			if(root.data > root.right.data)
				root.right.data = root.data ;
		}
		if(root.right==null && root.left!=null){
			if(root.data > root.left.data)
				root.left.data = root.data ;
		}
	}
	static void convertTree(Node root){
		int leftData = 0;
		int rightData = 0 ;
		if(root==null || (root.left==null && root.right==null))
			return ;
		if(root.left==null)
			leftData = 0;
		if(root.right==null)
			rightData = 0;
		else{
			leftData = root.left.data ;
			rightData = root.right.data ;
		}
		if(root.data == leftData+rightData){
			convertTree(root.left) ;
			convertTree(root.right) ;
		}
		if(root.data != leftData+rightData){
			convertTree(root.left) ;
			convertTree(root.right) ;
			balanceNode(root) ;
			balanceNode(root.left) ;
			balanceNode(root.right) ;
		}		
	}
	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left);
		System.out.printf("%d ",root.data) ;
		inorder(root.right) ;
	}
	public static void main(String[] args){
		Tree29 tree = new Tree29() ;
		tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(30);
  		
        convertTree(tree.root) ;
        inorder(tree.root) ;
		System.out.printf("\n") ;
	}
}