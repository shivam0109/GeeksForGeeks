//Another O(n) solution to find if a tree is height balanced. 

import java.io.* ;
import java.util.* ;

public class Tree11_3{
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
	//Calling height in the same function. 
	static boolean checkbalanced(Node root, Height height){
		//Empty tree is height balanced. 
		if(root == null){
			height.h = 0;
			return true;
		}
		Height lheight = new Height();
		Height rheight = new Height();
		
		//Check if left and right subtrees are height balanced 
		boolean l = checkbalanced(root.left,lheight);
		boolean r = checkbalanced(root.right,rheight);

		//Calculate height of node. 
		height.h = 1 + Math.max(lheight.h,rheight.h);

		System.out.println("root " + root.data + " Height " + height.h) ;
		if(Math.abs(lheight.h-rheight.h)>=2)
			return false;
		else
			return l&&r ;
	}

	public static void main(String[] args){
		Tree11_3 tree = new Tree11_3();
		Height height = new Height();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //tree.root.left.left.left = new Node(8);
  		boolean ans = checkbalanced(tree.root, height);
  		System.out.println(ans);
	}
}