//Binary Tree Basics

import java.io.* ;
import java.util.* ;

public class Tree1{
	Node root;
	static class Node{
		Node right;
		Node left;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static void inorder(Node root){
		Node temp = root ;
		if(temp.left == null)
			System.out.printf("%d ",temp.data);
		else{
			inorder(temp.left);
			System.out.printf("%d ",temp.data);
			inorder(temp.right);
		}
	}
	static void preorder(Node root){
		Node temp = root;
		System.out.printf("%d ",temp.data);
		if(temp.left!=null)
			preorder(temp.left);
		if(temp.right!=null)
			preorder(temp.right);
	}
	public static void main(String[] args){
		Tree1 bt = new Tree1();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.left.left.left = new Node(6);
		bt.root.left.left.right = new Node(7);
		bt.root.right.left = new Node(8);
		bt.root.right.right = new Node(9);
		//inorder(bt.root);
		preorder(bt.root);
		System.out.printf("\n");		
	}
}