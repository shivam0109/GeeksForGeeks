//Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. 
//Print all sums through different vertical lines.

//We need to find horizontal distance of each node from root. 

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
	static int findHD(int data, Node root){
		int hdleft,hdright ;
		if(root.data == data || root==null)
			return 0;
		
		hdleft = findHD(data,root.left)-1 ;
		hdright = findHD(data,root.right)+1 ;

		int hd = hdleft + hdright ;
		return hd ;
	}
}