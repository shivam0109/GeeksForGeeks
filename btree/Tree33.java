//Lowest Common Ancestor. 	
//The farthest node from root whose left subtree contains one key and right subtree contains another is the LCA. 

import java.util.* ;
import java.io.* ;

public class Tree33{
	static boolean flag1 = false ;
	static boolean flag2 = false ;
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

	static Node lca(Node root, int d1, int d2){
		if(root==null)
			return null;
		
		if(root.data == d1){
			flag1 = true;
			return root;
		}

		if(root.data == d2){
			flag2 = true;
			return root;
		}

		Node left_lca = lca(root.left,d1,d2);
		Node right_lca = lca(root.right,d1,d2);

		if(left_lca!=null && right_lca!=null)
			return root;

		else{
			if(left_lca!=null)
				return left_lca;
			else 
				return right_lca;
		}
	}

	public static void main(String[] args){
		Tree33 tree = new Tree33() ;
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        //if v1&&v2 ---> both present. 
        System.out.println(lca(tree.root, 4,5).data);
        System.out.println(lca(tree.root, 4,6).data);
        System.out.println(lca(tree.root, 4,3).data);
        System.out.println(lca(tree.root, 4,2).data);
	}
}