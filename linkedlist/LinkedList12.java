//find nth node from end without finding the length of the list

import java.io.* ;
import java.util.* ;

public class LinkedList12{
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
		LinkedList12 llist = new LinkedList12();
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int num = scr.nextInt();
		int i;
		llist.head = new Node(0);
		Node temp = llist.head;
		for(i=0;i<size;i++){
			temp.data = scr.nextInt();
			temp.next = new Node(0);
			temp = temp.next;
		}
		if(num<=size){
			temp = llist.head;
			Node mainref = llist.head;
			int count = 1 ;
			while(temp.next!=null){
				if(count<=num){
					temp = temp.next;
				}
				if(count>num){
					temp = temp.next;
					mainref = mainref.next;
				}
				count = count +1 ;
			}
			System.out.println(mainref.data);
		}
		else
			System.out.println(-1);
	}
}