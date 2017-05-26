//Find the maximum sum leaf to root path in a Binary Tree
//First get the max Sum and then using maxSum get the path. 

import java.io.* ;
import java.util.* ;

public class Tree25{
	Node root ;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = null;
			right = null ;
		}
	}
	static void printSum(int[] arr, int len){
		int i;
		int sum = 0;
		for(i=0;i<len;i++){
			sum += arr[i] ;
		}
		System.out.printf("%d\n", sum) ;
	}
	static int maxRootToLeaf(Node root, int[] path, int pathlen){
		if(root==null)
			return 0;
		if(root.left == null && root.right == null){
			path[pathlen] = root.data ; 
			pathlen++ ;
			//printSum(path,pathlen) ;
			return root.data ;
		}
		path[pathlen] = root.data ; 
		pathlen ++ ;
		maxRootToLeaf(root.left,path,pathlen) ;
		maxRootToLeaf(root.right,path,pathlen) ;
		return root.data + Math.max(maxRootToLeaf(root.left,path,pathlen),maxRootToLeaf(root.right, path, pathlen)) ;		
	}
	public static void main(String[] args){
		Tree25 tree = new Tree25() ;
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
  		
  		int[] path = new int[500] ;
  		int pathlen = 0; 
  		System.out.println(maxRootToLeaf(tree.root, path, pathlen)) ;
	}
}