//Check if two trees are identical

import java.io.* ;
import java.util.* ;

public class Tree10{
	Node root;
	static class Node{
		Node left,right;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static boolean check(Node root1, Node root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1!=null && root2!= null)
			return (root1.data == root2.data && check(root1.left,root2.left) && check(root1.right,root2.right)) ;
		else
			return false; 
	}
	public static void main(String[] args){
		Tree10 tree1 = new Tree10();
		tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
  		
  		Tree10 tree2 = new Tree10();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(10);
        tree2.root.left.right = new Node(5);

        System.out.println(check(tree1.root, tree2.root));
	}

}