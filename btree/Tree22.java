//Connect nodes at same level

import java.io.* ;
import java.util.* ;

public class Tree22{
	Node root;
	static class Node{
		int data;
		Node left,right,next ;
		Node(int d){
			data = d;
			left = null;
			right = null;
			next = null ;
		}
	}
	static void levelOrder(Node root, Queue<Node> q){
		Node curr,prev,temp ;
		q.add(root);
		int nodeCount = 0;
		while(!q.isEmpty()){
			nodeCount = q.size() ;
			prev = q.peek() ;
			while(nodeCount>0){
				curr = q.poll() ;
				if(nodeCount!=q.size())
					prev.next = curr ;
				
				System.out.printf("%d ",curr.data);
				
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
				
				nodeCount-- ;
				prev = curr ;
			}
			System.out.printf("\n") ;
		}
	}
	static void printNext(Node root){
		if(root==null)
			return;
		printNext(root.left) ;							
		System.out.printf("%d ", root.data) ;
		if(root.next!=null)
			System.out.println("root " + root.data + " next " + root.next.data);
		printNext(root.right);

	}
	public static void main(String[] args){
		Tree22 tree1 = new Tree22();
		tree1.root = new Node(26);
        tree1.root.right = new Node(3);
        tree1.root.right.right = new Node(3);
        tree1.root.left = new Node(10);
        tree1.root.left.left = new Node(4);
        tree1.root.left.left.right = new Node(30);
        tree1.root.left.right = new Node(6);

        Queue<Node> queue = new LinkedList<Node>() ;
        levelOrder(tree1.root, queue) ;
        printNext(tree1.root) ;
        System.out.printf("\n") ;        
	}

}