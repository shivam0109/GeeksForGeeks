//Find the closest leaf from a target node 

import java.io.* ;
import java.util.* ;

public class Tree37{
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
	static boolean isLeaf(Node node){
		return (node.left==null && node.right==null) ;
	}
	
	static int getLeafDistance(Node root){
		if(root==null)
			return Integer.MAX_VALUE-2 ;
		if(isLeaf(root))
			return 0;
		else
			return 1+Math.min(getLeafDistance(root.left),getLeafDistance(root.right)) ;
	}

	static int getDistance(Node root, int data){
		int leftmin = 0;
		int rightmin = 0;
		if(root==null)
			return -1;
		
		if(root.data==data){
			System.out.println("found");
			return -2;
		}

		int dleft = getDistance(root.left,data);
		if(dleft==-2){
			leftmin = Math.min(getLeafDistance(root.left),getLeafDistance(root.right)+2);
			System.out.println("leftmin: " + leftmin);
			return leftmin;
		}
		if(dleft>=0){
			System.out.println("dleft: " + dleft);
			return dleft ;
		}	
		int dright = getDistance(root.right,data);
		if(dright==-2){
			rightmin = Math.min(getLeafDistance(root.right),getLeafDistance(root.left)+2);
			System.out.println("rightmin: " + rightmin);
			return rightmin;
		}
		if(dright>=0){
			System.out.println("dright: " + dright);
			return dright ;
		}

		return -1;
	}

	public static void main(String[] args){
		Tree37 tree = new Tree37();
		tree.root = new Node(1) ;
		tree.root.left = new Node(2) ;
		tree.root.right = new Node(3) ;
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.right.left.left = new Node(7);
		tree.root.right.right.right = new Node(8);
		tree.root.right.left.left.left = new Node(9);
		tree.root.right.left.left.right = new Node(10);
		tree.root.right.right.right.left = new Node(11);

		//int minleaf = getLeafDistance(tree.root);
		//System.out.println(minleaf);
		
		int closestLeaf = getDistance(tree.root,5);
		System.out.println(closestLeaf);
	}	
}
