/*
Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.
*/

import java.io.* ;
import java.util.* ;

public class ReverseK{
	Node head ;
	static class Node{
		Node next ;
		int data ;
		Node(int d){
			data = d;
			next = null ;
		}
	}
	public Node reverseK(Node node, int k){
		if(node==null || node.next==null)
			return node ;
		Node curr  = node ;
		Node prev = null ;
		Node next = null ;
		int count = 0 ;
		while(count<k && curr!=null){
			next = curr.next ; 
			curr.next = prev ;
			prev = curr ;
			curr = next ;
			count++ ;
		}
		node.next = reverseK(next,k) ; 
		return prev ; 
	}
	public void printList(Node head){
		Node temp = head ;
		while(temp!=null){
			System.out.printf(" %d", temp.data) ;
			temp = temp.next ;
		}
		System.out.printf("\n") ;
	}
	public static void main(String[] args){
		ReverseK rk = new ReverseK() ;
		rk.head = new Node(1) ;
		rk.head.next = new Node(2) ;
		rk.head.next.next = new Node(3) ;
		rk.head.next.next.next = new Node(4) ;
		rk.head.next.next.next.next = new Node(5) ;
		rk.head.next.next.next.next.next = new Node(6) ;
		rk.head.next.next.next.next.next.next = new Node(7) ;
		rk.head.next.next.next.next.next.next.next = new Node(8) ;
		rk.printList(rk.head) ; 
		Node newHead = rk.reverseK(rk.head,3) ;
		rk.printList(newHead) ; 
	}
}