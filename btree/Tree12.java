//Find max width of a tree. 
//Width is number of elements in each level. 

import java.io.* ;
import java.util.* ;

public class Tree12{
	Node root ;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static int height(Node root){
		if(root == null)
			return 0;
		else 
			return 1 + Math.max(height(root.left),height(root.right)) ;
	}
	static int widthGivenLevel(Node root, int level){
		if(root==null)
			return 0;
		if(level == 0)
			return 1; 
		else
			return widthGivenLevel(root.left,level-1) + widthGivenLevel(root.right,level-1);
	}

	static int findWidth(Node root){
		int maxcount = 0;
		int h = height(root);
		int i;
		for(i=0;i<h;i++){
			int count = widthGivenLevel(root,i);
			System.out.println("Count at level "+i+" "+count);
			if(count > maxcount)
				maxcount = count ;
		}
		return maxcount ;
	}
	public static void main(String[] args){
		Tree12 tree = new Tree12();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(8);
      	tree.root.right.right.left = new Node(6);
      	tree.root.right.right.right = new Node(7);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	System.out.println(findWidth(tree.root)) ;
	}
}