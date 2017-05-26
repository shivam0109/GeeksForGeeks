//Given two binary trees, check if the first tree is subtree of the second one.

import java.io.* ;
import java.util.* ;

public class Tree21{
	Node root;	
	static class Node{
		int data;
		Node left,right;
		Node(int d){
			left = null;
			right = null;
			data = d;
		}
	}

	static boolean isIdentical(Node root1, Node root2){
		if(root1==null && root2==null)
			return true;
		else if(root1==null && root2!=null)
			return false;
		else if(root2==null	&& root1!=null)
			return false;
		else 
			return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right) && (root1.data==root2.data) ;
	}

	static boolean isSubtree(Node root, Node root2){
		if(root==null)
			return false ;
		boolean rootSub = isIdentical(root,root2) ;
		return rootSub || isSubtree(root.left,root2) || isSubtree(root.right,root2) ;
	}

	public static void main(String[] args){
		Tree21 tree1 = new Tree21() ;
		Tree21 tree2 = new Tree21();
		tree1.root = new Node(26);
        tree1.root.right = new Node(3);
        tree1.root.right.right = new Node(3);
        tree1.root.left = new Node(10);
        tree1.root.left.left = new Node(4);
        tree1.root.left.left.right = new Node(30);
        tree1.root.left.right = new Node(6);

        tree2.root = new Node(10);
        tree2.root.right = new Node(6);
        tree2.root.left = new Node(109);
        tree2.root.left.right = new Node(30);
  		
        System.out.println(isSubtree(tree1.root, tree2.root)) ;
	}
}