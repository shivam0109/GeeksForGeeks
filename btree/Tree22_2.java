//Connect Nodes at Same Level in O(1) space. 

import java.io.* ;
import java.util.* ;

public class Tree22_2{
	Node root;
	static class Node{
		int data;
		Node left, right, next;
		Node(int d){
			data = d;
			left = null;
			right = null;
			next = null; 
		}
	}
	//To return leftmost child of nodes at same level as input node. 
	static Node findNext(Node node){
		Node temp = node.next;
		while(temp!=null){
			if(temp.left!=null)
				return temp.left ;
			if(temp.right!=null)
				return temp.right ; 
			temp = temp.next ; 
		}
		return null ;
	}

	static void connectNode(Node node){
		if(node==null)
			return ;
		//First connect the nodes and then traverse left. 
		if(node.next!=null)
			connectNode(node.next) ; 

		if(node.left!=null){
			if(node.right!=null){
				node.left.next = node.right ;
				node.right.next = findNext(node) ;
			}
			else
				node.left.next = findNext(node) ; 
			connectNode(node.left) ; 
		}
		
		else if(node.right!=null){
			node.right.next = findNext(node) ;
			connectNode(node.right) ;
		}
		else
			connectNode(findNext(node)) ;
	}

	public static void main(String[] args){
		Tree22_2 tree = new Tree22_2() ;
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.right.right = new Node(90);
  
        // Populates next pointer in all nodes
        tree.connectNode(tree.root);
  
        // Let us check the values of next pointers
        int a = tree.root.next != null ? 
                          tree.root.next.data : -1;
        int b = tree.root.left.next != null ? 
                          tree.root.left.next.data : -1;
        int c = tree.root.right.next != null ?
                            tree.root.right.next.data : -1;
        int d = tree.root.left.left.next != null ?
                        tree.root.left.left.next.data : -1;
        int e = tree.root.right.right.next != null ? 
                        tree.root.right.right.next.data : -1;
          
        // Now lets print the values
        System.out.println("Following are populated next pointers in "
                + " the tree(-1 is printed if there is no next)");
        System.out.println("next of " + tree.root.data + " is " + a);
        System.out.println("next of " + tree.root.left.data + " is " + b);
        System.out.println("next of " + tree.root.right.data + " is " + c);
        System.out.println("next of " + tree.root.left.left.data + 
                                                              " is " + d);
        System.out.println("next of " + tree.root.right.right.data + 
                                                              " is " + e);
	}
}