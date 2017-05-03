//Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order. 
//Both the Linked list can be of different sizes.

import java.io.* ;
import java.util.* ;

public class LinkedList25{
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
		LinkedList25 llist = new LinkedList25();
		Scanner scr = new Scanner(System.in);
		llist.head = new Node(scr.nextInt());
		int i;
		Node temp = llist.head;
		for(i=1;i<size;i++){
			temp.next = new Node(scr.nextInt());
			temp = temp.next;
		}
		return llist.head;
	}
	static Node mergeResult(Node head1,Node head2){
		Node temp1 = head1 ;
		Node temp2 = head2 ;
		Node store = null;
		Node store2 = null;
		while(temp1!=null && temp2!=null){
			if(temp1.data<=temp2.data){
				store2 = temp1.next ;
				temp1.next = store ;
				store = temp1;
				temp1 = store2 ;
			}
			else{
				store2 = temp2.next;
				temp2.next = store;
				store = temp2;
				temp2 = store2;
			}
		}
		if(temp1!=null && temp2 == null){
			while(temp1!=null){
				store2 = temp1.next;
				temp1.next = store;
				store = temp1;
				temp1 = store2;
			}
		}
		if(temp1==null && temp2 != null){
			while(temp2!=null){
				store2 = temp2.next;
				temp2.next = store;
				store = temp2;
				temp2 = store2;
			}
		}
		return store;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size1 = scr.nextInt();
		Node head1 = buildlist(size1);
		int size2 = scr.nextInt();
		Node head2 = buildlist(size2);
		Node newhead = mergeResult(head1,head2);
		Node temp = newhead;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}	
}