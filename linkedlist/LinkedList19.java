//Given a singly linked list, remove all the nodes which have a greater value on right side. 

// The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. 
// Note that 12, 10, 5 and 2 have been deleted because there is a greater value on the right side.

import java.io.* ;
import java.util.* ;

public class LinkedList19{
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	static Node buildlist(int size){
		Scanner scr = new Scanner(System.in);
		LinkedList19 llist = new LinkedList19();
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
		Node curr = head1;
		Node next = head1.next;
		Node prev = null;
		while(next!=null){
			if(curr == head1 && curr.data < next.data){
				head1 = next;
				curr = next;
				next = curr.next;
			}
			else if(curr.data<next.data){
				prev.next = next;				
				curr = next;
				next = curr.next ;				
			}
			else{
				prev = curr;
				curr = next;
				next = curr.next;
			}
		}
		Node temp = head1;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
	}
}