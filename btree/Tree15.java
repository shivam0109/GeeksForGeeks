//Given a binary tree, print out all of its root-to-leaf paths one per line.
//

import java.io.* ;
import java.util.* ;

public class Tree15{
	Node root;
	static class Node{
		Node left,right;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static void printArr(int[] arr, int len){
		int i;
		for(i=0;i<len;i++)
			System.out.printf("%d ",arr[i]) ;
		System.out.printf("\n") ;
	}
	static void rootToLeafPaths(Node root, int[] arr, int len){
		if(root!=null){
			arr[len] = root.data ;
			len = len+1 ;

			if(root.left == null && root.right==null)
				printArr(arr,len);

			rootToLeafPaths(root.left,arr,len);
			rootToLeafPaths(root.right,arr,len) ;
		}
	}
	public static void main(String[] args){
		Tree15 tree = new Tree15();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        int arr[] = new int[100] ;
        rootToLeafPaths(tree.root,arr,0) ;
	}
}

