//Remove all nodes which don’t lie in any path with sum>= k
//A node can be part of multiple paths. So we have to delete it only in case when all paths from it have sum less than K.

import java.io.* ;
import java.util.* ;

public class Tree39{
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}

	static boolean isGreaterK(Node root,int k){
		if(root==null && k>0)
			return false;
		if(root==null && k<=0)
			return true;
		if(k<=0)
			return true; 

		boolean left = isGreaterK(root.left,k-root.data);
		boolean right = isGreaterK(root.right,k-root.data);	
		
		if(!left)
			root.left = null;

		if(!right)
			root.right = null;
	
		return left||right ; 
	}

	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left);
		System.out.printf("%d ",root.data);
		inorder(root.right);
	}

	public static void main(String[] args){
		Tree39 tree = new Tree39();
		tree.root = new Node(1) ;
		tree.root.left = new Node(2) ;
		tree.root.right = new Node(3) ;
	    tree.root.left.left = new Node(4);
	    tree.root.left.right = new Node(5);
	    tree.root.right.left = new Node(6);
	    tree.root.right.right = new Node(7);
	    tree.root.left.left.left = new Node(8);
	    tree.root.left.left.right = new Node(9);
	    tree.root.left.right.left = new Node(12);
	    tree.root.right.right.left = new Node(10);
	    tree.root.right.right.left.right = new Node(11);
	    tree.root.left.left.right.left = new Node(13);
	    tree.root.left.left.right.right = new Node(14);
	    tree.root.left.left.right.right.left = new Node(15);

	    inorder(tree.root) ;
	    System.out.printf("\n");
	    isGreaterK(tree.root,20) ;
	    inorder(tree.root) ;
	    System.out.printf("\n");
	}
}