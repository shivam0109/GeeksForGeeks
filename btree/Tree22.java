//Connect nodes at same level

import java.io.* ;
import java.util.* ;

public class Tree22{
	Node root ;
	static class Node{
		Node left,right,next;
		int data; 
		Node(int d){
			data = d;
			left = null;
			right = null;
			next = null ;
		}
	}
	static void connectNodes(Node root, Queue<Node> q){
		Node curr = root; 
		q.add(curr) ;
		int nodecount ; 
		while(!q.isEmpty()){
			nodecount = q.size() ;
			while(nodecount>0){
				curr = q.poll() ;
				if(curr.left!=null)
					q.add(curr.left) ;
				if(curr.right!=null)
					q.add(curr.right) ;
				if(nodecount!=1){
					curr.next = q.peek() ;
				}
				nodecount--;	
			}
		}
	}
	static void levelTraversal(Node root){
		while(root!=null){
			System.out.printf("%d ",root.data) ;
			root = root.next ; 
		}
		System.out.printf("\n") ;
	}
	public static void main(String[] args){
		Tree22 tree = new Tree22() ;
		tree.root = new Node(1) ;
		tree.root.left = new Node(2) ;
		tree.root.right = new Node(3) ;		
		tree.root.left.left = new Node(4) ;
		tree.root.left.right = new Node(4) ;
		tree.root.right.left = new Node(5) ;
		tree.root.right.right = new Node(6) ;

		Queue<Node> q = new LinkedList<Node>() ;
		
		connectNodes(tree.root,q) 	;
		levelTraversal(tree.root) ;
		levelTraversal(tree.root.left) ;
		levelTraversal(tree.root.left.left) ;
	}
}