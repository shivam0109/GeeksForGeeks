//Given a singly linked list: A0→A1→…→An-1→An,
//reorder it to: A0→An→A1→An-1→A2→An-2→…

//Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

import java.io.* ;
import java.util.* ;

public class LinkedList26{
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
		LinkedList26 llist = new LinkedList26();
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
	static Node reverse(Node node){
		Node curr = node;
		Node prev = null;
		Node next = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	static Node reachmid(Node head){
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while(fast!= null && fast.next!=null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if(prev!=null)
			prev.next = null;
		//System.out.println(slow.data);
		return slow;
	}
	static Node reorderlist(Node head){
		if(head.next!=null){
			Node temp1 = head;
			Node revfromhere = reachmid(head);
			Node revhead = reverse(revfromhere);
			Node temp2 = revhead;
			Node store1;
			Node store2;
			Node prev = null ;
			while(temp1!=null && temp2!=null){
				store1 = temp1.next;
				temp1.next = temp2;
				store2 = temp2.next;
				temp2.next = store1;
				prev = temp2;
				temp1 = store1;
				temp2 = store2;
			}
			if(temp2!=null && temp1==null)
				prev.next = temp2;
		}		
		return head;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node head1 = buildlist(size);			
		Node newhead = reorderlist(head1);
		Node temp = newhead;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}