//Boundary Traversal for binary trees. 

import java.io.* ;
import java.util.* ;

public class Tree26{
	Node root;
	static class Node{
		Node left,right ;
		int data ;
		Node(int d){
			data = d;
			left = null;
			right = null ;
		}
	}
	static Queue<Node> travelLeft(Node root, Queue<Node> q){
		while(root.left!=null){
			if(!isLeaf(root)){
				q.add(root) ;
			}
			root = root.left ;
		}
		return q ;
	}
	static Queue<Node> travelRight(Node root, Queue<Node> q){
		while(root.right!=null){
			if(!isLeaf(root)){
				q.add(root) ;
			}
			root = root.right ;
		}
		return q ;	
	}
	static boolean isLeaf(Node root){
		boolean flag = false ;
		if(root.left == null && root.right == null)
			flag = true;
		return flag ; 
	}
	static void printLeaf(Node root){
		if(root==null)
			return ;
		if(isLeaf(root))
			System.out.printf("%d ", root.data) ;
		printLeaf(root.left) ;
		printLeaf(root.right) ;
	}
	static void printQueue(Queue<Node> q){
		Node curr ;
		while(!q.isEmpty()){
			curr = q.poll();
			System.out.printf("%d ",curr.data);
		}
	}
	public static void main(String[] args){
		Tree26 tree = new Tree26() ;
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);

        Queue<Node> q = new LinkedList<Node>() ;
        q.add(tree.root) ;
        travelLeft(tree.root.left,q) ;
        printQueue(q) ;
        printLeaf(tree.root) ;
        travelRight(tree.root.right,q) ;
        printQueue(q) ;
        System.out.printf("\n") ;
	}
}