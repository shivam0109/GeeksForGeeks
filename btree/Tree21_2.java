//Check if a binary tree is subtree of another binary tree 
// Time : O(n)
 

//Inorder and Pre/Postorder Traversal uniquely defines a tree. 
//Find inorder and Preorder of both the trees and identify if one is substring/ subarray of other. 

import java.io.* ;
import java.util.* ;

public class Tree21_2{
	Node root;
	static class Node{
		int data;
		Node left,right ;  
		Node(int d){
			Node left = null ;
			Node right = null ;
			data = d;
		}
	}
	static void inorder(Node root, ArrayList<Integer> list){
		if(root==null){
			list.add(-1);
			return ;
		}
		inorder(root.left,list) ;
		list.add(root.data) ; 
		inorder(root.right,list) ; 
	}
	static void preorder(Node root, ArrayList<Integer> list){
		if(root==null){
			list.add(-1);
			return ;
		}
		list.add(root.data) ; 
		inorder(root.left,list) ;
		inorder(root.right,list) ; 
	}
	static boolean isSubarray(ArrayList<Integer> list1, ArrayList<Integer> list2){
		if(Collections.indexOfSubList(list1,list2) != -1)
			return true;
		else 
			return false; 
	}
	public static void main(String[] args){
		Tree21_2 tree1 = new Tree21_2() ; 
		tree1.root = new Node(1) ;
		tree1.root.left = new Node(2) ;
		tree1.root.right = new Node(4) ;
		tree1.root.left.left = new Node(3) ;
		tree1.root.right.right = new Node(5) ;

		Tree21_2 tree2 = new Tree21_2() ;
		tree2.root = new Node(1) ;
		tree2.root.left = new Node(2) ;
		tree2.root.right = new Node(4) ;
		tree2.root.left.left = new Node(3) ;
	
		ArrayList<Integer> inList1 = new ArrayList<Integer>() ;
		ArrayList<Integer> inList2 = new ArrayList<Integer>() ;
		ArrayList<Integer> preList1 = new ArrayList<Integer>() ;
		ArrayList<Integer> preList2 = new ArrayList<Integer>() ;
		
		inorder(tree1.root,inList1) ;
		inorder(tree2.root,inList2) ; 
		preorder(tree1.root,preList1) ;
		preorder(tree2.root,preList2) ; 
		
		inList1.add(-2) ;
		inList2.add(-2) ;
		preList1.add(-2) ;
		preList2.add(-2) ; 
		
		System.out.println(isSubarray(inList1,inList2) && isSubarray(preList1,preList2)) ; 
	}	
}