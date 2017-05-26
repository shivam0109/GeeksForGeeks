//Write a function that returns true if the given Binary Tree is SumTree else false. 
//A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree


import java.io.* ;
import java.util.* ;

public class Tree20_3{
	Node root;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static boolean isSumTree(Node root){
		boolean left,right;
		boolean isSum = true ;
		if(root==null || (root.left==null && root.right==null)){
			isSum = true;
			return isSum ;
		}
		else if(root.left!=null && root.right!=null && (root.right!=null || root.left!=null)){
			if(root.data == 2*(root.left.data + root.right.data))
				isSum = true ;
			else
				isSum = false ;
		}
		else if(root.left!=null && root.right!=null &&(root.right!=null || root.left!=null)){
			if(root.data == 2*(root.left.data + root.right.data))
				isSum = true ;
			else
				isSum = false ;
		}
		else if(root.left == null && (root.right.left == null && root.right.right == null)){
			if(root.data == root.right.data)
				isSum = true;
			else 
				isSum = false;
		}
		else if(root.left == null && (root.right.left != null || root.right.right != null)){
			if(root.data == 2*root.right.data)
				isSum = true;
			else 
				isSum = false;
		}
		else if(root.right == null && (root.left.left == null && root.right.right == null)){
			if(root.data == root.left.data)
				isSum = true;
			else 
				isSum = false;
		}		
		else if(root.right == null && (root.left.left != null || root.right.right != null)){
			if(root.data == 2*root.left.data)
				isSum = true;
			else 
				isSum = false;
		}
		System.out.println(root.data);
		System.out.println(isSum);
		left = isSumTree(root.left);
		right = isSumTree(root.right);
		return left&&right&&isSum ;
	}

	public static void main(String[] args){
		Tree20_3 tree = new Tree20_3() ;
		tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
       	System.out.println(isSumTree(tree.root)) ;
	}
}