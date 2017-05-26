//Write a function that returns true if the given Binary Tree is SumTree else false. 
//A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree

import java.io.* ;
import java.util.* ;

public class Tree20_2{
	Node root; 
	static class Node{
		int data,sum ;
		Node left,right ;
		Node(int d){
			data = d;
			sum = 0;
			left = right = null ;
		}
	}
	
	static boolean isSumTree(Node root){
		boolean left,right;
		boolean isSum = true;
		if(root == null){
			isSum = true;
			return isSum;
		}
		//System.out.println(root.data) ;
		if(root.left==null && root.right==null){
			root.sum = root.data;
			isSum = true;
			return isSum ; 
		}
		
		left = isSumTree(root.left) ;
		right = isSumTree(root.right) ;

		if(root.left==null && root.right!=null){
			root.sum = root.right.sum + root.data ;
		}

		if(root.left!=null && root.right==null){
			root.sum = root.left.sum + root.data ;
		}

		if(root.left!=null && root.right!=null){
			root.sum = root.left.sum + root.right.sum + root.data ;
		}

		if((root.left!=null && root.right!=null) && (root.left.sum + root.right.sum == root.data))
			isSum = true ;
		else if((root.left==null && root.right!=null) && (root.right.sum == root.data))
			isSum = true ;
		else if((root.left!=null && root.right==null) && (root.left.sum == root.data))
			isSum = true ;
		else 
			isSum = false ;

		System.out.println(root.data) ;
		System.out.println(isSum) ;		
		
		return left&&right&&isSum ; 
	}

	public static void main(String[] args){
		Tree20_2 tree = new Tree20_2() ;
		tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
       	System.out.println(isSumTree(tree.root)) ;
	}	
}