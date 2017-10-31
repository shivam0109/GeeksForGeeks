/*
Number of subtrees with diameter k
*/

import java.io.* ;
import java.util.* ;

public class DiameterK{
	Node root ;
	static class Node{
		Node left,right ;
		int data ;
		Node(int d){
			data = d ;
			left = null ;
			right = null ;
		}
	}
	public int height(Node root){
		if(root==null)
			return 0 ;
		return 1+Math.max(height(root.left),height(root.right)) ; 
	}
	public int diameter(Node root, ArrayList<Integer> count, int k){
		if(root==null)
			return 0 ;
		int l = diameter(root.left,count,k) ;
		int r = diameter(root.right,count,k) ;
		int d = Math.max(1+height(root.left)+height(root.right),Math.max(l,r)) ; 
		if(d==k)
			count.set(0,count.get(0)+1) ;
		return d ; 
	}
	public static void main(String[] args){
		DiameterK tree = new DiameterK();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        //tree.root.right.right.left = new Node(8);
        ArrayList<Integer> count = new ArrayList<Integer>() ;
        count.add(0) ;
        int dia = tree.diameter(tree.root,count,3) ; 
        System.out.println(dia + " " + count.get(0)) ; 
	}
}