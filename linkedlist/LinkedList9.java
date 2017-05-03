//Given two numbers represented by two lists, write a function that returns sum list. 
//The sum list is list representation of addition of two input numbers.

//First List: 5->6->3  // represents number 365
//Second List: 8->4->2 //  represents number 248
//Resultant list: 3->1->6  // represents number 613

import java.io.* ;
import java.util.* ;

public class LinkedList9{
	Node head;
	static class Node{
		int data;
		Node next ;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static Node buildlist(){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		LinkedList9 llist = new LinkedList9() ;
		llist.head = new Node(0);
		Node temp = llist.head ;
		int i;
		for(i=0;i<size;i++){
			temp.data = scr.nextInt();
			if(i!=size-1)
				temp.next = new Node(0);
			temp = temp.next ;
		}
		return llist.head;
	}
	public static void main(String[] args){
		Node head1 = buildlist();
		Node head2 = buildlist();

		Node temp1 = head1;
		Node temp2 = head2;

		LinkedList9 llist = new LinkedList9();
		llist.head = new Node(0);
		int carry;
		Node temp = llist.head ;
		while(temp1!=null && temp2!=null){
			carry = 0;
			temp.data = temp.data + temp1.data + temp2.data;
			if(temp.data>9){
				carry = 1;
				temp.data = temp.data - 10;
			}
			temp.next = new Node(carry);
			temp = temp.next;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp1==null && temp2!=null){
			while(temp2!=null){
				temp.data = temp2.data;
				temp.next = new Node(0);
				temp = temp.next;
				temp2 = temp2.next;
			}
		}
		if(temp1!=null && temp2==null){
			while(temp1!=null){
				temp.data = temp1.data;
				temp.next = new Node(0);
				temp = temp.next;
				temp1 = temp1.next;
			}
		}
		Node temp3 = llist.head;
		while(temp3!=null){
			System.out.printf("%d ",temp3.data);
			temp3 = temp3.next;
		}
		System.out.printf("\n");
	}
}