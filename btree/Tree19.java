//A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. 
//An empty tree is considered as foldable.

import java.io.* ;
import java.util.* ;

public class Tree19{
	Node root;
	static class Node{
		int data;
		Node left, right ;
		Node(int d){
			left = null;
			right = null;
			data = d;
		}
	}
	static void mirror(Node root){
		if(root == null)
			return ;
		else{
			Node temp = root.left ;
			root.left = root.right;
			root.right = temp ; 
		}
		mirror(root.left);
		mirror(root.right);
	}
	static boolean isSameStruct(Node root1, Node root2){
		boolean left,right ;
		boolean struct = true;
		if((root1 == null && root2!=null) || (root1!=null && root2==null)){
			struct = false; 
			return struct;
		}
		// if(root1 == null && root2 == null){
		// 	struct = true ;
		// 	return struct ;
		// }
		left = isSameStruct(root1.left,root2.left) ;
		right = isSameStruct(root1.right, root2.right);
		return left&&right&&struct ;
	}

	static void inorder(Node root){
		if(root==null)
			return ;
		else{
			inorder(root.left);
			System.out.printf("%d ",root.data);
			inorder(root.right);
		}
	}

	public static void main(String[] args){
		Tree19 tree = new Tree19();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.left = new Node(5);
  		mirror(tree.root.left);
  		boolean res = isSameStruct(tree.root.left,tree.root.right);
  		//inorder(tree.root);
  		System.out.println(res);
  		mirror(tree.root.left);
	}
}


