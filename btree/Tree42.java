//Construct Full Binary Tree from given preorder and postorder traversals

import java.io.* ;
import java.util.* ;

public class Tree42{
	Node root;
	static class Node{
		int data;
		Node left,right ;
		Node(int d){
			left = null;
			right = null;
			data = d; 
		}
	}

	static int findIndex(int[] arr, int len, int key){
		int i;
		for(i=0;i<len;i++){
			if(arr[i]==key)
				break;
		}
		return i ;
	}

	static Node constructTree(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight){
		if(preLeft<=preRight){
			Node root = new Node(pre[preLeft]) ; 
			if(preLeft+1<=preRight){
				int leftIndex = findIndex(post,postRight+1,pre[preLeft+1]) ;
				int leftlen = leftIndex-postLeft+1;  
				root.left = constructTree(pre,post,preLeft+1,preLeft+leftlen,postLeft,leftIndex) ; 
				root.right = constructTree(pre,post,preLeft+leftlen+1,preRight,leftIndex+1,postRight-1) ; 
			}
			return root ;
		}
		else
			return null;  
	}

	static void inorder(Node root){
		if(root==null)
			return ;
		inorder(root.left) ;
		System.out.printf("%d ", root.data) ;
		inorder(root.right) ; 
	}

	public static void main(String[] args){
		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
        int size = pre.length ; 
        Node node = constructTree(pre,post,0,size-1,0,size-1) ; 
        inorder(node) ;
        System.out.printf("\n") ; 
	}
}