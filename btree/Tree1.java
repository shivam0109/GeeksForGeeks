//Binary Tree Traversals
//Inorder : Left Root Right 
//Preorder : Root Left Right 
//Postorder : Left Right Root 
import java.io.* ;
import java.util.* ;

public class Tree1{
	Node root ;
	static class Node{
		int data;
		Node left,right ;
		Node(int x){
			data = x;
			left = null;
			right = null;
		}
	}
	static void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.printf("%d ",root.data);
			inorder(root.right);
		}
	}
	static void preorder(Node root){
		if(root!=null){
			System.out.printf("%d ",root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	static void postorder(Node root){
		if(root!=null){
			postorder(root.left);
			postorder(root.right);
			System.out.printf("%d ",root.data);
		}
	}
	public static void main(String[] args){
		Tree1 bt = new Tree1();
		bt.root = new Node(25);
		bt.root.left = new Node(15);
		bt.root.right = new Node(50);
		bt.root.left.left = new Node(10);
		bt.root.left.right = new Node(22);
		bt.root.left.left.left = new Node(4);
		bt.root.left.left.right = new Node(12);
		bt.root.left.right.left = new Node(18);
		bt.root.left.right.right = new Node(24);
		bt.root.right.left = new Node(35);
		bt.root.right.right = new Node(70);
		bt.root.right.left.left = new Node(31);
		bt.root.right.left.right = new Node(44);
		bt.root.right.right.left = new Node(66);
		bt.root.right.right.right = new Node(90);
		//inorder(bt.root);
		//preorder(bt.root);
		postorder(bt.root);
		System.out.printf("\n");	
	}
}