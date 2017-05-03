//Given a singly linked list, write a function to swap elements pairwise. 
//For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5, and 
//if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.

import java.io.* ;
import java.util.* ;

public class LinkedList17{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static Node buildlist(int size){
		Scanner scr = new Scanner(System.in);
		LinkedList17 llist = new LinkedList17();
		llist.head = new Node(scr.nextInt());
		Node temp = llist.head;
		int i;
		for(i=1;i<size;i++){
			temp.next = new Node(scr.nextInt());
			temp = temp.next;
		}
		return llist.head;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node head1 = buildlist(size);
		Node odd = head1 ;
		Node even = head1.next ;
		int x;
		while(odd!=null && even!=null){
			x = odd.data;
			odd.data = even.data;
			even.data = x;
			odd = odd.next.next;
			if(even.next!=null)
				even = even.next.next;
		}
		Node temp = head1;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
		System.out.println(head1.data);
	}
} 
