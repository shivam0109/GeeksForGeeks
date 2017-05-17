//Print Ancestors of a given node in binry tree

import java.io.* ;
import java.util.* ;

public class Tree14{
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
	static boolean printAncestor(Node root, int x){
		boolean left,right ;
		if(root == null)
			return false;
		if(root.left == null && root.right == null)
			return false;
		if(root.left!=null && root.left.data == x){
			System.out.printf("%d ",root.data) ;
			return true;
		}
		if(root.right!=null && root.right.data == x){
			System.out.printf("%d ",root.data);
			return true;
		}
		left = printAncestor(root.left,x) ;
		right = printAncestor(root.right,x) ;
		if(left==true)
			printAncestor(root,root.left.data);
		if(right==true)
			printAncestor(root,root.right.data);
		return left||right ;
	}
	public static void main(String[] args){
		Tree14 tree = new Tree14() ;
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(8);
      	tree.root.right.right.left = new Node(6);
      	tree.root.right.right.right = new Node(7);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
	
		// tree.root = new Node(1);
		// tree.root.left = new Node(2);
		// tree.root.right = new Node(3);
		// tree.root.left.left = new Node(4) ;
		// tree.root.left.right = new Node(5) ;
		// tree.root.left.right.right = new Node(7) ;
	
		boolean ans = printAncestor(tree.root,10);
		if(ans == false)
			System.out.println(false);
		else
			System.out.printf("\n");
	}
}