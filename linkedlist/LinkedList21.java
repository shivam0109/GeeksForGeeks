//Given a linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f .. 
//where a, b, c.. are consecutive data node of linked list.

import java.io.* ;
import java.util.* ;

public class LinkedList21{
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
		LinkedList21 llist = new LinkedList21();
		llist.head = new Node(scr.nextInt());
		Node temp = llist.head;
		int i;
		for(i=1;i<size;i++){
			temp.next = new Node(scr.nextInt());
			temp = temp.next;
		}
		return llist.head;
	}
	static void swap(Node a,Node b){
		int temp = a.data;
		a.data = b.data;
		b.data = temp;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node head1 = buildlist(size);
		int count = 0;
		Node curr = head1;
		while(curr.next!=null){
			if(count%2==0){
				if(curr.data>curr.next.data){
					swap(curr,curr.next);
				}
			}
			else{
				if(curr.data<curr.next.data){
					swap(curr,curr.next);
				}
			}
			curr = curr.next;
			count = count + 1;
		}
		Node temp = head1;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}