//Find diameter of a tree in O(n). 

import java.io.* ;
import java.util.* ;

public class Tree6_2{
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static class Height{
		int h = 0;
	}
	static int diameter(Node root, Height height){
		if(root==null){
			height.h = 0;
			return 0;
		}
		Height lheight = new Height();
		Height rheight = new Height();
		lheight.h++ ;
		rheight.h++ ;
		height.h = 1 + Math.max(lheight.h,rheight.h) ;
		System.out.println(height.h);
		return Math.max(1+lheight.h+rheight.h,Math.max(diameter(root.left,lheight),diameter(root.right,rheight))) ;
	}
	public static void main(String[] args){
		Tree6_2 tree = new Tree6_2();
		Height height = new Height();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);	
       	System.out.println("Diameter: " + diameter(tree.root, height));
	}	
}