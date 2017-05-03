//Reverse a linked list using recursion 

import java.util.* ;
import java.io.* ;

public class LinkedList5{
	Node head;
	static class Node{
		int data;
		Node next ;
		Node(int d){
			data = d;
			next = null;
		}
	}
	//function to reverse a LinkedList
	static Node reverse(Node curr, Node prev){
		if(curr.next == null){
			head = curr;
			curr.next = prev ;
			return null;
		}
		Node next1 = curr.next;
		curr.next = prev;
		reverse(next1,curr);
		return head;
	}
	//function to print LinkedList
	static void printlist(Node node){
		Node temp = node;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
	public static void main(String[] args){
		LinkedList5 llist = new LinkedList5();
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

		printlist(llist.head);

		reverse(llist.head,null);

		printlist(head);
	}
}