//Write a function that returns true if the given Binary Tree is SumTree else false. 
//A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree

import java.io.* ;
import java.util.* ;

public class Tree20{
	Node root ;
	static class Node{
		Node left,right;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null ;
		}
	}
	static int treeSum(Node root){
		int leftSum = 0;
		int rightSum = 0;
		int sum = 0;
		if(root == null){
			sum = 0 ;
			return sum ;
		}
		else
			sum = root.data ;

		leftSum = treeSum(root.left);
		rightSum = treeSum(root.right);

		return sum+leftSum+rightSum ;   
	}
	static boolean isSumTree(Node root){
		boolean left,right;
		boolean isSum = false;
		if(root == null || (root.left==null && root.right==null)){
			isSum = true;
			return isSum; 
		}
		if(treeSum(root.left) + treeSum(root.right) == root.data){
			isSum = true ;
		}
		System.out.println(isSum) ;
		left = isSumTree(root.left);
		right = isSumTree(root.right);
		return left&&right&&isSum ;
	}
	public static void main(String[] args){
		Tree20 tree = new Tree20() ;
		tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
       	System.out.println(isSumTree(tree.root)) ;
	}
}