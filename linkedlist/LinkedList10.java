//Build a linked list with inputs from user given the size of list

import java.util.* ;
import java.io.*;

public class LinkedList10{
	Node head;
	static class Node{
		int data ;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		LinkedList10 llist = new LinkedList10();
		int size = scr.nextInt();
		llist.head = new Node(0);
		Node temp = llist.head;
		int i;
		for(i=0;i<size;i++){
			temp.data = scr.nextInt();
			temp.next = new Node(0);
			temp = temp.next;
			//System.out.printf("%d ",temp.data);
		}
		temp = llist.head;
		while(temp.next!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}