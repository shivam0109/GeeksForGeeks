//Determine if a tree is height balanced 
//No leaf is much farther away from the root than any other leaf. 

//Definition of much farther :
//left subtree should be balanced 
//right subtree should be balanced 
//abs(height(left subtree) - height(right subtree)) = 0 or 1. 
//An empty tree is balanced

import java.io.* ;
import java.util.* ;

public class Tree11{
	Node root;
	static class Node{
		int data;
		Node left, right;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}

	static class Height{
		int height = 0;
	}

	//Calling height separately makes time O(n2). 

	static int height(Node root){
		if(root == null)
			return 0;
		else
			return 1+Math.max(height(root.left),height(root.right));
	}
		
	static boolean checkbalanced(Node root){
		if(root == null)
			return true;
		// else{
		// 	boolean flag = false;
		// 	if(height(root.left)-height(root.right)==0 || Math.abs(height(root.left)-height(root.right)==1))
		// 		flag = true;
		// 	return (checkbalanced(root.left) && checkbalanced(root.right) && flag);					
		// }
		if(Math.abs(height(root.left)-height(root.right)) > 1)
			return false;
		else 
			return (checkbalanced(root.left) && checkbalanced(root.right)) ;			
	}		

	public static void main(String[] args){
		Tree11 tree = new Tree11();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
  		boolean ans = checkbalanced(tree.root);
  		System.out.println(ans);
	}
}