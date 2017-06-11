//Find distance b/w two keys of a tree.

import java.util.* ;
import java.io.* ;

public class Tree34{
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

	static int findHeight(Node root, int d, int level){
		int value = -1;
		if(root==null)
			return -1;
		if(root.data==d)
			value = level;
		int left = findHeight(root.left,d,level+1);
		int right = findHeight(root.right,d,level+1);
		if(left!=-1)
			value = left;
		if(right!=-1)
			value = right;
		return value ;
	}

	static Node findLca(Node root, int d1, int d2){
		if(root==null)
			return root;
		if(root.data == d1 || root.data == d2)
			return root;
		Node leftLca = findLca(root.left,d1,d2);
		Node rightLca = findLca(root.right,d1,d2);

		if(leftLca!=null && rightLca!=null)
			return root;

		else{
			if(leftLca!=null)
				return leftLca;
			else
				return rightLca;
		}
	}

	static int findDistance(Node root, int d1, int d2){
		Node lcaNode = findLca(root,d1,d2) ;
		int lca = lcaNode.data ;
		int dis1 = findHeight(root,lca,0);
		int dis2 = findHeight(root,d1,0);
		int dis3 = findHeight(root,d2,0) ;
		System.out.println(lca + " " + dis1 + " " + dis2 + " " + dis3);
		return dis3+dis2-2*dis1 ;
	}

	public static void main(String[] args){
		Tree34 tree = new Tree34() ;
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.left.left = new Node(8);
        tree.root.right.right = new Node(7);

        System.out.println(findDistance(tree.root,8,5)) ;
		//printAncestor(tree.root,8);
	}
}