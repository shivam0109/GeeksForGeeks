//Left Rotate a LinkedList

import java.io.*;
import java.util.* ;

public class LinkedList11{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static Node buildlist(){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		LinkedList11 llist = new LinkedList11();
		llist.head = new Node(0);
		Node temp = llist.head;
		int i;
		for(i=0;i<size;i++){
			temp.data = scr.nextInt();
			temp.next = new Node(0);
			temp = temp.next;
		}
		return llist.head;
	}
	public static void main(String[] args){
		Node head1 = buildlist();
		Node temp1 = head1;
		Scanner scr = new Scanner(System.in);
		int k = scr.nextInt();
		int i = 0;
		Node temp2;
		for(i=0;i<k;i++)
			temp1 = temp1.next ;
		temp2 = temp1;
		while(temp1.next!=null){
			System.out.printf("%d ",temp1.data);
			temp1 = temp1.next ;
		}
		temp1 = head1;
		while(temp1!=temp2){
			System.out.printf("%d ",temp1.data);
			temp1 = temp1.next ;
		}
		System.out.printf("\n");
	}
} 