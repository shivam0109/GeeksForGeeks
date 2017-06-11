//Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. 
//Print all sums through different vertical lines.

//We need to find horizontal distance of each node from root. 
//If 2 nodes have the same horizontal distance from root, they have they lie on same vertical line. 

//Create a hashmap to store horizontal distances and sum at each horizontal distance. Traverse the tree recursively. 

import java.io.* ;
import java.util.* ;

public class Tree31{
	Node root;
	static class Node{
		Node left,right ;
		int data;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}

	static void findHD(Node root, int hd, HashMap<Integer, Integer> hmap){
		if(root==null)
			return ;
		if(hmap.containsKey(hd))
			hmap.put(hd,hmap.get(hd)+root.data) ;
		else
			hmap.put(hd,root.data);
		findHD(root.left,hd-1,hmap);
		findHD(root.right,hd+1,hmap);
	}

	public static void main(String[] args){
		Tree31 tree = new Tree31() ;
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3) ;
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>() ;
		findHD(tree.root,0,hmap);
		if (hmap != null) {
            System.out.println(hmap.entrySet());
        }
	}
}