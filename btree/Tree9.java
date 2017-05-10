//Print all root-leaf paths. 

import java.io.* ;
import java.util.* ;

public class Tree9{
	Node root;
	static class Node{
		int data;
		Node left, right ;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static void printpath(Node root){
		if(root==null)
			return;
		else if(root.left==null && root.right==null){
			System.out.printf("%d\n",root.data);
			return;
		}
		else{
			System.out.printf("%d ",root.data);
			printpath(root.left);
			System.out.printf("%d ",root.data);
			printpath(root.right);		
		}
	}
	public static void main(String[] args){
		Tree9 tree = new Tree9();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);
       	printpath(tree.root);  
       	System.out.printf("\n");
	}
}