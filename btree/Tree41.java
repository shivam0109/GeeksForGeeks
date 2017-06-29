//Reverse alternate levels of a perfect binary tree

//Simple Solution is to traverse tree level by level
//If level is odd, store it in an array and reverse it. 

import java.io.* ;
import java.util.* ;

public class Tree41{
	Node root;
	static class Node{
		char data;
		Node left,right ;
		Node(char d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	static void reverseAlternateUtil(Node root1, Node root2, int level){
		if(root1==null || root2 ==null)
			return ;
		if(level%2==0){
			char temp = root1.data ;
			root1.data = root2.data;
			root2.data = temp;
		}
		reverseAlternateUtil(root1.left,root2.right,level+1);
		reverseAlternateUtil(root1.right,root2.left,level+1);
	}
	
	static void inorder(Node root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.printf("%c ",root.data);
		inorder(root.right);
	}

	static void reverseAlternate(Node root){
		reverseAlternateUtil(root.left,root.right,0) ;
	}

	public static void main(String[] args){
		Tree41 tree = new Tree41();
		tree.root = new Node('a') ;
		tree.root.left = new Node('b');
		tree.root.right = new Node('c');
		tree.root.left.left = new Node('d');
		tree.root.left.right = new Node('e');
		tree.root.right.left = new Node('f');
		tree.root.right.right = new Node('g');
		tree.root.left.left.left = new Node('h');
		tree.root.left.left.right = new Node('i');
		tree.root.left.right.left = new Node('j');
		tree.root.left.right.right = new Node('k');
		tree.root.right.left.left = new Node('l');
		tree.root.right.left.right = new Node('m');
		tree.root.right.right.left = new Node('n');
		tree.root.right.right.right = new Node('o');

		inorder(tree.root);
		System.out.printf("\n") ;
		reverseAlternate(tree.root);
		inorder(tree.root) ;
		System.out.printf("\n") ;
	}

}