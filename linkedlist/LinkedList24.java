//Merge two sorted linkedlist into one linkedlist in asc order.

import java.io.* ;
import java.util.* ;

public class LinkedList24{
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
		LinkedList24 llist = new LinkedList24();
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
	static Node mergelist(Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		//System.out.printf("%d %d", head1.data, head2.data);
		//System.out.printf("\n");
		Node prev = null;
		Node store;
		Node store2;
		while(temp1!=null && temp2!=null){
			if(temp1.data <= temp2.data){
				prev = temp1;
				temp1 = temp1.next;
			}
			else{
				if(prev!=null){
					store = temp2.next;
					prev.next = temp2;
					temp2.next = temp1;
					prev = temp2;
					temp2 = store;
				}
				else{
					//System.out.printf("%d ",head2.next.data);
					store2 = head2.next;
					head2.next = head1;
					head1 = head2;
					head2 = store2;
					temp1 = head1;
					temp2 = head2;
				}
			}
		}
		if(temp1==null && temp2!=null){
			prev.next = temp2;
		}
		return head1;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size1 = scr.nextInt();
		Node head1 = buildlist(size1);
		int size2 = scr.nextInt();
		Node head2 = buildlist(size2);
		Node newhead = mergelist(head1,head2);
		Node temp = newhead;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
	}
}