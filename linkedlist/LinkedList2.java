//Deleting a node

import java.io.* ;
import java.util.* ;

public class LinkedList2{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	public static void main(String[] args){
		LinkedList2 llist = new LinkedList2();
		llist.head = new Node(8);
		Node second = new Node(2) ;
		Node third = new Node(3) ;
		Node fourth = new Node(1) ;
		Node fifth = new Node(7) ;
		
		llist.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		Scanner scr = new Scanner(System.in);
		int pos = scr.nextInt();
		int i = 0;
		int len = 0;
		Node temp = llist.head ;

		System.out.printf("Before Deleting: ");
		while(temp!= null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");

		temp = llist.head ;

		while(temp!=null){
			len = len+1;
			temp = temp.next ;
		}
		if(pos == 0){
			llist.head = llist.head.next ;
		}
		else if(pos == len-1){
			temp = llist.head;
			while(temp.next.next != null){
				temp = temp.next;
			}
			temp.next = null;
		}
		else{
			temp = llist.head ; 
			while((i+1) != pos){
				i = i+1;
				temp = temp.next ;	
			}
			temp.next = temp.next.next ;
		}
		
		System.out.printf("After Deleting : ");
		temp = llist.head ;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
	}
} 