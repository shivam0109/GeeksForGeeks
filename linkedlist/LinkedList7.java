//Merge two sorted linked lists
//Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, 
//and merges the two together into one list which is in increasing order. 
//SortedMerge() should return the new list. The new list should be made by splicing
//together the nodes of the first two lists.

import java.util.* ;
import java.io.* ;

public class LinkedList7{
	Node head;
	static class Node{
		int data;
		Node next ;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static void printlist(Node node){
		Node temp = node;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
	}
	public static void main(String[] args){
		LinkedList7 llist1 = new LinkedList7();
		LinkedList7 llist2 = new LinkedList7();
	
		llist1.head = new Node(5);
		Node a = new Node(10);
		Node b = new Node(15);

		llist1.head.next = a ;
		a.next = b;

		llist2.head = new Node(2);
		Node c = new Node(3);
		Node d = new Node(20);

		llist2.head.next = c ;
		c.next = d;

		Node temp1 = llist1.head ;
		Node temp2 = llist2.head ;

		LinkedList7 llist3 = new LinkedList7();
		if(temp1.data < temp2.data){
			llist3.head = temp1 ;
			temp1 = temp1.next;
		}
		else{
			llist3.head = temp2;
			temp2 = temp2.next ;
		}

		Node temp3 = llist3.head ;

		while(temp1!= null && temp2!= null){
			if(temp1.data < temp2.data){
				temp3.next = temp1;
				temp1 = temp1.next ;
			}
			else{
				temp3.next = temp2 ;
				temp2 = temp2.next ;
			}
			temp3 = temp3.next ;
		}

		if(temp1 == null){
			while(temp2 != null){
				temp3.next = temp2;
				temp2 = temp2.next;
				temp3 = temp3.next;
			}
		}

		else{
			while(temp1 != null){
				temp3.next = temp1;
				temp1 = temp1.next;
				temp3 = temp3.next;
			}
		}
		printlist(llist3.head);
	}	
}