//Reverse a Linked List in groups of given sizes

import java.io.* ;
import java.util.* ;

public class LinkedList6{
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
		Scanner scr = new Scanner(System.in);
		LinkedList6 llist = new LinkedList6();
		llist.head = new Node(scr.nextInt());
		int i;
		Node temp = llist.head;
		for(i=1;i<size;i++){
			temp.next = new Node(scr.nextInt());
			temp = temp.next ;
		}
		return llist.head;		
	}
	static Node[] reverse(Node node,int k){
		Node curr = node;
		Node prev = null;
		Node next = null;
		int i;
		for(i=0;i<k;i++){
			next = curr.next;
			curr.next = prev;
			prev = next;
			curr = next;
		}
		Node[] arr = new Node[3];
		arr[0] = node;
		arr[1] = prev;
		arr[2] = curr;
		return arr ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node head1 = buildlist(size);
		int k = scr.nextInt();
		Node[] arr = new Node[3] ;
		arr[0] = null;
		arr[1] = null;
		arr[2] = head1;
		int i;
		Node temp1,temp2;
		for(i=0;i<Math.ceil(size/k);i++){
			temp1 = arr[0];
			temp2 = arr[1];
			arr = reverse(arr[2],k);
			temp2.next = arr[0];
		}
	}
}