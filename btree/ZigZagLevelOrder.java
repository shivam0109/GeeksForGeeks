/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between). */

/*
One way to do is perform level order traversal and store the result in list of lists. 
There after, reverse the odd indexed lists. 
*/

/*
Other way without reversing the list is to add element in back of the list if level is odd, 
else add in front. 
*/

import java.io.* ;
import java.util.* ;

public class ZigZagLevelOrder{
	Node root = null ;
	static class Node{
		Node left, right ;
		int data ;
		Node(int d){
			left = null ;
			right = null ;
			data = d  ;
		}
	}
	public List<List<Integer>> zigzag(Node root){
		List<List<Integer>> arrlist = new ArrayList<List<Integer>>() ; 
		traversal(root,arrlist,0) ;
		return arrlist ;
	}
	public void traversal(Node root, List<List<Integer>> arrlist, int level){
		if(root==null)
			return ;
		
		if(arrlist.size()<=level){
			List<Integer> list = new LinkedList<Integer>() ;
			arrlist.add(list) ; 
		}

		if(level%2==0){
			List<Integer> levelList = arrlist.get(level) ; 
			levelList.add(root.data) ; 
		}
		else{
			List<Integer> levelList = arrlist.get(level) ;
			levelList.add(0,root.data) ;
		}
		
		traversal(root.left,arrlist,level+1) ;
		traversal(root.right,arrlist,level+1) ; 
	}
	public static void main(String[] args){
		ZigZagLevelOrder tree = new ZigZagLevelOrder();
		tree.root= new Node(1);
       	tree.root.left= new Node(2);
      	tree.root.right= new Node(3);
      	tree.root.right.right = new Node(6);
      	tree.root.right.right.left = new Node(9);
       	tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.root.left.right.left = new Node(7);
       	tree.root.left.right.right = new Node(8);
       	System.out.println(tree.zigzag(tree.root));
	}
}