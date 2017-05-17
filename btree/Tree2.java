//Breadth-First-Traversal for a tree 

import java.io.* ;
import java.util.* ;

public class Tree2{
	Node root = null;
	static class Node{
		Node left,right;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}

	//function to find height 
	static int height(Node root){
		int lheight;
		int rheight;
		if(root==null)
			return 0;
		else{
			lheight = height(root.left);
			rheight = height(root.right);
			//System.out.println("lheight: "+ lheight);
			//System.out.println("rheight: "+ rheight);
			return Math.max((lheight+1),(rheight+1));
		}
	}
	
	//function to print given level
	static void printGivenLevel(Node root, int level){
		if(root==null)
			return ;
		if(level==0)
			System.out.printf("%d ",root.data);
			//System.out.println(1);
		else{
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}

	//function to print level order traversal
	static void printLevelOrder(Node root){
		int h = height(root);
		System.out.printf("Height : %d\n", h);
		int i;
		for(i=0;i<h;i++){
			printGivenLevel(root,i);
			System.out.printf("\n");
		}
	}

	public static void main(String[] args){
		Tree2 tree = new Tree2();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);
       	printLevelOrder(tree.root);
	}
}