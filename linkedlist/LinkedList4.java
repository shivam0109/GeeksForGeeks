//Reverse a Linked List

import java.io.* ;
import java.util.* ;

public class LinkedList4{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null ;
		}
	}
	public static void main(String[] args){
		LinkedList4 llist = new LinkedList4() ;
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);

		llist.head.next = second;
		second.next = third ;
		third.next = fourth;
		fourth.next = fifth ;
		fifth.next = sixth ;

		Node temp = llist.head ;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");

		Node prev = null;
		Node current = llist.head ;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev ;
			prev = current ;
			current = next ;
		}
		
		llist.head = prev ;
		temp = llist.head ;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}