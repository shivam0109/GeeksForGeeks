//Print all nodes that are at a distance k from leaf node.

import java.io.* ;
import java.util.* ;

public class Tree35{
	Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int d){
			data = d;
			left = right = null;
		}
	}

	static boolean isLeaf(Node root){
		if(root==null)
			return false;
		else if(root.left==null && root.right==null)
			return true;
		else
			return false;
	}

	static void printElement(int[] arr, int len, int k){
		if(k>=len)
			return ;
		System.out.printf("%d ", arr[len-k-1]) ;
		
	}

	static void kDistance(Node root, int arr[], int last, int k){
		if(root==null)
			return ;
		
		arr[last] = root.data ; 
		
		if(isLeaf(root))	
			printElement(arr,last+1,k) ;
		
		kDistance(root.left,arr,last+1,k) ;
		kDistance(root.right,arr,last+1,k); 
	}

	public static void main(String[] args){
		Tree35 tree = new Tree35() ;
		int arr[] = new int[100] ;
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
		//Queue<Integer> q = new LinkedList<Integer>() ;
        kDistance(tree.root,arr,0,2) ;	
	}
}