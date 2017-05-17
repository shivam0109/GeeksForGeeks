//Given a binary tree, write a function that returns true if the tree satisfies below property.
//For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children

import java.io.* ;
import  java.util.* ;

public class Tree18{
	Node root ;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static boolean checkChildrenSum(Node root){
		boolean left,right;
		boolean isSum = false;
		if(root==null){
			isSum = true;
			return isSum;
		}
		if(root.left==null && root.right == null)
			isSum = true;
		if(root.left == null && root.right!=null){
			if(root.right.data == root.data)
				isSum = true;
			else
				isSum = false;
		}
		if(root.right == null && root.left!=null){
			if(root.left.data == root.data)
				isSum = true;
			else
				isSum = false;
		}
		if(root.right!=null && root.left!=null){
			if(root.left.data + root.right.data == root.data)
				isSum = true;
			else
				isSum = false;
		}
		left = checkChildrenSum(root.left);
		right = checkChildrenSum(root.right);
		return left&&right&&isSum;
	}
	public static void main(String[] args){
		Tree18 tree = new Tree18();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(4);
        boolean res = checkChildrenSum(tree.root);
        System.out.println(res);
	}	
}