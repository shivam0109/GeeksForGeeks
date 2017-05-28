//Construct a special tree from given preorder traversal
//special binary tree where every node has either 0 or 2 children. One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. 
//The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. 
//Write a function to construct the tree from the given two arrays.

//It is difficult to calculate nleft and nright. So, we should make a recursive call with index which specifies the 
//position in array. 

import java.io.* ;
import java.util.* ;

public class Tree27{
	static int index = 0;
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			data = d;
			left = right = null ;
		}
	}
	static Node buildTree(int[] pre, char[] preLN, int len, Node root){
		if(index==len)
			return null ;

		root = new Node(pre[index]) ;
		int currIndex = index ; 
		index++ ;
		
		System.out.println("index " + index);
		
		if(preLN[currIndex] == 'N'){
			root.left = buildTree(pre,preLN,len,root.left) ;
			root.right = buildTree(pre,preLN,len,root.right) ;
		} 

		return root; 
	}
	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left) ;
		System.out.printf("%d ",root.data) ;
		inorder(root.right) ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int len = scr.nextInt();
		int i;
		int pre[] = new int[len] ;
 		for(i=0;i<len;i++)
 			pre[i] = scr.nextInt() ;
 		char preLN[] = new char[len] ;
 		for(i=0;i<len;i++)
 			preLN[i] = scr.next().charAt(0) ;

 		Node root = buildTree(pre,preLN,len,null) ;
 		inorder(root) ;
 		System.out.printf("\n") ;
 	}
}