//Write a removeDuplicates() function which takes a list sorted in non-decreasing order 
//and deletes any duplicate nodes from the list. The list should only be traversed once.

import java.io.* ;
import java.util.* ;

public class LinkedList15{
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
		LinkedList15 llist = new LinkedList15();		
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
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node temp = buildlist(size);
		Node curr = temp.next;
		Node prev = temp;
		while(curr!=null){
			if(curr.data == prev.data){
				prev.next = curr.next;
				curr = curr.next;
			}
			else{
				prev = prev.next;
				curr = curr.next;
			}
		}
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		} 
		System.out.printf("\n");
	}
}