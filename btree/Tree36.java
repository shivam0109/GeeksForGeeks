//Print all nodes at distance k from a given node
//Given a binary tree, a target node in the binary tree, and an integer value k, 
//print all the nodes that are at distance k from the given target node.

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
		printKBelow(root.left,level+1);
		printKBelow(root.right,level+1);
	}
}