//Remove nodes on root to leaf paths of length < K


import java.io.* ;
import java.util.* ;

public class Tree40{
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = right = null;
		}
	}
	static boolean pruneToK(Node root, int k){
		if(root==null && k>0)
			return false;
		if(k<=0)
			return true;
		boolean left = pruneToK(root.left,k-1);
		boolean right = pruneToK(root.right,k-1);

		if(!left)
			root.left = null;
		if(!right)
			root.right = null;

		return left||right ;
	}

	static void inorder(Node root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.printf("%d ",root.data);
		inorder(root.right);
	}

	public static void main(String[] args){
		Tree40 tree = new Tree40();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(8);
		inorder(tree.root) ;
		System.out.printf("\n");
		pruneToK(tree.root,4);
		inorder(tree.root) ;
		System.out.printf("\n");	
	}
}