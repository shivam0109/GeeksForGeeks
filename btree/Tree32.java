//Convert a given Binary Tree to Doubly Linked List | Set 1


//The key concept is that the prev of a node in List will be the rightmost element in left subtree and 
//next of a node will be leftmost in right subtree for an inorder traversal.


import java.io.* ;
import java.util.* ;

public class Tree32{
	Node root ;
	static class Node{
		Node left,right ;
		int data ;
		Node(int d){
			data = d ;
			left = null ;
			right = null ;
		}
	}
	
	static Node treeToListIn(Node node){
		Node left,right ;
		if(node==null)
			return node ;
		if(node.left!=null){
			left = treeToList(node.left);
			while(left.right!=null)
				left = left.right ;
			
			left.right = node;
			node.left = left ;
		}
		if(node.right!=null){
			right = treeToList(node.right);
			while(right.left!=null)
				right = right.left ;
			right.left = node;
			node.right = right ;
		}
		return node;
	}

	static Node treeToListPre(Node node){
		if(node==null)
			return node ;
		if()
	}

	static void printList(Node node){
		while(node.left!=null)
			node = node.left;
		while(node!=null){
			System.out.printf("%d ",node.data);
			node = node.right ;
		}
		System.out.printf("\n") ;
	}

	public static void main(String[] args){
		Tree32 tree = new Tree32() ;
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		Node node = treeToList(tree.root);
		printList(node) ;
	}
}