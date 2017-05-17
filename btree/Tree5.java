//mirror of a tree 

import java.io.* ;
import java.util.* ;

public class Tree5{
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			left = null;
			right = null;
			data = d;
		}
	}
	static void mirror(Node root){
		// if(root!=null)
		// 	System.out.println(root.data);
		Node temp;
		if(root==null)
			return;
		else{
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}			
		mirror(root.left);
		mirror(root.right);
	}
	static void inorder(Node root){
		if(root == null)
			return ;
		inorder(root.left);
		System.out.printf("%d ",root.data);
		inorder(root.right);
	}
	public static void main(String[] args){
		Tree5 tree = new Tree5();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);
       	mirror(tree.root);
       	inorder(tree.root);
       	System.out.printf("\n");
	}
}