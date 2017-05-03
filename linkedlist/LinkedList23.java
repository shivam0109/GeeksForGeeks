//Flatten a Linked List

import java.io.* ;
import java.util.* ;

public class LinkedList23{
	Node head;
	static class Node{
		int data;
		Node next;
		Node bottom ;
		Node(int d){
			data = d;
			next = null;
			bottom = null;
		}
	}
	static Node mergelist(Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		Node prev = null ;
		Node store ;
		Node store2 ;
		while(temp1!=null && temp2!=null){
			if(temp1.data <= temp2.data){
				//System.out.printf("%d ",temp1.data);
				prev = temp1;
				temp1 = temp1.bottom;								
			}
			else{
				if(prev!=null){
					//System.out.printf("%d ",temp2.data);
					prev.bottom = temp2;
					store = temp2.bottom;
					temp2.bottom = temp1;
					prev = temp2;
					temp2 = store;					
				}
				else{
					store2 = head2.next;
					head2.next = head1;
					head1 = head2;
					head2 = store2;
					temp1 = head1;
					temp2 = head2;
				}
			}
		}
		if(temp1==null && temp2!= null)
			prev.bottom = temp2;
		
		return head1;
	}
	static Node flatten(Node root){
		Node newroot = root;
		Node param2 = root.next;
		Node param3 = null; 		
		while(param2!=null){
			//System.out.println(param2.data);
			param3 = param2.next;
			newroot = mergelist(newroot,param2);
			param2 = param3; 
		}
		return newroot;
	}
	public static void main(String[] args){
		LinkedList23 llist1 = new LinkedList23();
		llist1.head = new Node(5);
		llist1.head.bottom = new Node(7);
		llist1.head.bottom.bottom = new Node(8);
		llist1.head.bottom.bottom.bottom = new Node(30);

		LinkedList23 llist2 = new LinkedList23();
		llist2.head = new Node(10);
		llist2.head.bottom = new Node(20);

		LinkedList23 llist3 = new LinkedList23();
		llist3.head = new Node(19);
		llist3.head.bottom = new Node(22);
		llist3.head.bottom.bottom = new Node(50);

		LinkedList23 llist4 = new LinkedList23();
		llist4.head = new Node(28);
		llist4.head.bottom = new Node(35);
		llist4.head.bottom.bottom = new Node(40);
		llist4.head.bottom.bottom.bottom = new Node(45);

		llist1.head.next = llist2.head;
		llist2.head.next = llist3.head;
		llist3.head.next = llist4.head;

		Node head1 = flatten(llist1.head);
		Node temp = head1;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.bottom;
		}
		System.out.printf("\n");
	}

}