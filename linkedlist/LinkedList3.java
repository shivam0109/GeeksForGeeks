//Swap Nodes without swapping data

import java.io.* ;
import java.util.* ;

public class LinkedList3{
	Node head;
	static class Node{
		int data;
		Node next ;
		Node(int d){
			data = d;
			next = null;
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int x = scr.nextInt();
		int y = scr.nextInt();
		LinkedList3 llist = new LinkedList3();
		llist.head = new Node(10);
		Node second = new Node(15);
		Node third = new Node(12);
		Node fourth = new Node(13);
		Node fifth = new Node(20);
		Node sixth = new Node(14);

		//linking them 
		llist.head.next = second;
		second.next = third ;
		third.next = fourth;
		fourth.next = fifth ;
		fifth.next = sixth ;

		//Traversing before swapping 
		Node temp = llist.head ;
		System.out.printf("Before Swapping: ") ;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");

		Node temp1 = llist.head ;
		Node temp2 = llist.head ;
		
		if(x == llist.head.data){
			while(temp2.next.data != y)
				temp2 = temp2.next ;
			Node store1 = llist.head.next ;
			Node store2 = temp2.next ;
			Node store3 = temp2.next.next ;
			temp2.next = temp1 ;
			temp2.next.next = store3 ;
			llist.head = store2 ;
			llist.head.next = store1 ;
		}

		else{
			while(temp1.next.data != x){
				temp1 = temp1.next ;
			}
			while(temp2.next.data != y){
				temp2 = temp2.next ;
			}
		
			Node store1 = temp1.next.next ; 
			Node store2 = temp2.next.next ;
			Node store3 = temp1.next ;
			temp1.next = temp2.next ;
			temp1.next.next = store1 ;
			temp2.next = store3 ;
			temp2.next.next = store2 ;
		}	
		//Traversing after swapping
		System.out.printf("After Swapping: ") ;
		temp = llist.head ;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
	}
}