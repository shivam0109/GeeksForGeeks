/*
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.
*/

import java.io.* ;
import java.util.* ;

public class MaxSumPath{
	Node root ;
	static class Node{
		int data ;
		Node left,right ;
		Node(int d){
			left = null ;
			right = null ;
			data = d ;
		}
	}
	public int maxSum(Node root, ArrayList<Integer> sum){
		if(root==null)
			return 0 ;
		int left = maxSum(root.left,sum) ;
		int right = maxSum(root.right,sum) ;
		int maxSingle = Math.max(root.data + Math.max(left,right),root.data) ;
		int maxTotal = Math.max(root.data+left+right, maxSingle) ; 
		sum.set(0,Math.max(sum.get(0),maxTotal)) ;
		return maxSingle ;  
	}
	public static void main(String[] args){
		MaxSumPath tree = new MaxSumPath();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        ArrayList<Integer> sum = new ArrayList<Integer>() ;
        sum.add(Integer.MIN_VALUE) ;
        tree.maxSum(tree.root,sum) ;
        System.out.println(sum.get(0)) ; 
	}
}