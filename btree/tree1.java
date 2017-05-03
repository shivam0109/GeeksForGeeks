//Binary Tree Basics

import java.io.* ;
import java.util.* ;

public class tree1{
	Node root;
	static class Node{
		Node right;
		Node left;
		int key;
		Node(int d){
			key = d;
			left = null;
			right = null;
		}
	}
	public static void main(String[] args){
		tree1 bt = new tree1();
	}
}