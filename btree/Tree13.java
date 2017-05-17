//Level Order Traversal Using Queue 
//Time : O(n) Space : O(n) 

import java.io.* ;
import java.util.* ;

public class Tree13{
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
	static int getMaxWidth(Node root, Queue<Node> q){
		Node temp ;
		q.add(root) ;
		int count = 0;
		int maxcount = 0;
		while(!q.isEmpty()){
			count = q.size() ;
			maxcount = Math.max(count,maxcount) ;
			while(count>0){
				temp = q.poll();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				count-- ;	
			}
		}
		return maxcount;
	}
	public static void main(String[] args){
		Tree13 tree = new Tree13();
		Queue<Node> q = new LinkedList<Node>() ;
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(8);
      	tree.root.right.right.left = new Node(6);
      	tree.root.right.right.right = new Node(7);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	System.out.println(getMaxWidth(tree.root,q)) ;
	}
}