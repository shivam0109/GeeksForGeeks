//Inorder tree traversal without recursion 

//Use Stack : Data Structure to implement recursion.
//recursion uses stack so in general, use stack to implement recursion.

import java.io.*;
import java.util.* ;

public class Tree3{
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

	static void inorder(Stack<Node> s, Node current){
		Node temp;
		while(!s.empty() || current!=null){
			while(current!=null){
				s.push(current);
				current = current.left;
			}
			if(current==null && !s.empty()){
				temp = s.pop();
				System.out.printf("%d ",temp.data);
				current = temp.right;
			}
		}
	}

	public static void main(String[] args){
		Stack<Node> s = new Stack<Node>();		
		Tree3 tree = new Tree3();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);
       	inorder(s,tree.root) ;
       	System.out.printf("\n");
	}
}