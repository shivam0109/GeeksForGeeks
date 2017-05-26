//Check whether a given Binary Tree is Complete or not 

import java.io.* ;
import java.util.* ;

public class Tree23{
	Node root ;
	static class Node{
		Node left,right ;
		int data ;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	static int height(Node root){
		if(root==null)
			return 0;
		else
			return 1+Math.max(height(root.left),height(root.right)) ;
	}

	static boolean isComplete(Node root,Queue<Node> q){
		Node curr = root;
		q.add(curr) ;
		int nodecount ;
		int ht = height(root);
		int currht = ht ;
		boolean flag = true ; 
		while(!q.isEmpty()){
			nodecount = q.size() ;
			while(nodecount>0){
				curr = q.poll() ;
				System.out.println("current height: " + currht) ;
				if(currht>2){
					System.out.println("In 1 " + curr.data );
					if(curr.left==null || curr.right==null){
						flag = false ;
						break ;
					}
					if(curr.left!=null)
						q.add(curr.left) ;
					if(curr.right!=null)
						q.add(curr.right) ;
				}
				else{					
					System.out.println("In 2 " + curr.data );
					if(curr.left==null && curr.right!=null){
						flag = false ;
						break ;
					}
					
					if(curr.left!=null)
						q.add(curr.left) ;
					
					if(curr.right!=null)
						q.add(curr.right);
					
					if(!q.isEmpty()){
						Node temp = q.peek();
						if((curr.left==null && curr.right==null)&&(temp.left!=null||temp.right!=null)){
							flag = false;
							break ;
						}
					}
				}
				nodecount--;
			}
			currht-- ;
			if(flag==false)
				break ; 
		}
		return flag ; 
	}
	
	public static void main(String[] args){
		Tree23 tree = new Tree23() ;
		tree.root = new Node(1) ;
		tree.root.left = new Node(2) ;
		tree.root.right = new Node(3) ;		
		// tree.root.left.left = new Node(4) ;
		//tree.root.left.right = new Node(4) ;
		tree.root.right.left = new Node(5) ;
		tree.root.right.right = new Node(6) ;

		Queue<Node> q = new LinkedList<Node>();
		boolean ans = isComplete(tree.root,q) ;
		System.out.println(ans) ;
	}
	
}