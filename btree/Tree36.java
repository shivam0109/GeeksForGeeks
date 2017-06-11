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
	
}