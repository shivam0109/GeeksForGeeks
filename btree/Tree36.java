//Print all nodes at distance k from a given node
//Given a binary tree, a target node in the binary tree, and an integer value k, 
//print all the nodes that are at distance k from the given target node.


//This can be divided into 2 parts. 
//Print nodes which are at a distance k below the target node and
//Print nodes which are at a distance of k-dl-2 in right subtree or k-dr-2 in left subtree. 

import java.io.* ;
import java.util.* ;

public class Tree36{
	Node root;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	static void printKBelow(Node root, int level, int k){
		if(root==null || k<0)
			return ;
		if(level==k){	
			System.out.printf("%d ",root.data);
			return ;
		}
		printKBelow(root.left,level+1,k);
		printKBelow(root.right,level+1,k);
	}

	static int printKDistance(Node root, Node target, int k){
		if(root==null)
			return -1;
		if(root.data==target.data){
			printKBelow(target,0,k);
			return 0;		
		}
		int dl = printKDistance(root.left,target,k);
		if(dl!=-1){
			if(dl+1==k)
				System.out.printf("%d ",root.data);
			else
				printKBelow(root.right,0,k-dl-2);
			return 1+dl ;
		}
		int dr = printKDistance(root.right,target,k);
		if(dr!=-1){
			if(dr+1==k)
				System.out.printf("%d ",root.data);
			else
				printKBelow(root.left,0,k-dr-2);
			return 1+dr;
		}
		return -1;
	}

	public static void main(String[] args){
		Tree36 tree = new Tree36() ;
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right ; 
        printKDistance(tree.root,target,2) ;
		System.out.printf("\n");
	}

}