//LinkedList basics

import java.io.* ;
import java.util.*;

public class LinkedList1{
	//Node class
	static class Node{
		int data;
		Node next;
		//Constructor
		Node(int d){
			data = d;
			next = null ;
		}
	}
	Node head;
	public static void main(String[] args){
		LinkedList1 llist = new LinkedList1();
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		llist.head.next = second;
		second.next = third;
		//traverse the LinkedList
		Node temp = llist.head;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
		Node newnode = new Node(5);
		//insert a node at the front
		newnode.next = llist.head;
		llist.head = newnode;
		temp = llist.head;
		//traverse after inserting the node
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
		//insert a node after a given node.
		Node newnode2 = new Node(10);
		//insert after second node
		temp = second.next;
		second.next = newnode2;
		newnode2.next = temp;
		temp = llist.head ;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
		//insert at last
		Node newnode3 = new Node(15);
		newnode3.next = null;
		if(llist.head == null)
			llist.head = newnode3 ;
		else{
			temp = llist.head;
			while(temp.next!=null){
				temp = temp.next ;
			}
		}
		temp.next = newnode3;
		//traverse the new linked list		
		temp = llist.head;
		while(temp!= null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}