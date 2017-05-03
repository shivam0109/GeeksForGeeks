//Given a linked list of line segments, remove middle points

import java.io.* ;
import java.util.* ;

public class LinkedList22{
	Node head;
	static class Node{
		int data1;
		int data2;
		Node next;
		Node(int d1, int d2){
			data1 = d1;
			data2 = d2;
			next = null;
		}
	}
	static Node buildlist(int size){
		Scanner scr = new Scanner(System.in);
		LinkedList22 llist = new LinkedList22();
		llist.head = new Node(scr.nextInt(),scr.nextInt());
		Node temp = llist.head ;
		int i;
		for(i=1;i<size;i++){
			temp.next = new Node(scr.nextInt(),scr.nextInt());
			temp = temp.next;
		}
		return llist.head;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node head1 = buildlist(size);
		Node temp = head1;
		int xflag = 0;
		int yflag = 0;
		while(temp.next!=null){
			if(temp==head1)
				System.out.printf("(%d,%d) ",temp.data1,temp.data2);
			if(xflag == 1 && temp.data1 != temp.next.data1)
				System.out.printf("(%d,%d) ",temp.data1,temp.data2);
			if(yflag == 1 && temp.data2 != temp.next.data2)
				System.out.printf("(%d,%d) ",temp.data1,temp.data2);
			if(temp.data1 == temp.next.data1){
				xflag = 1;
				yflag = 0;
			}
			if(temp.data2 == temp.next.data2){
				yflag = 1;
				xflag = 0;
			}
			temp = temp.next;
		}
		System.out.printf("(%d,%d) ",temp.data1,temp.data2);
		System.out.printf("\n");
	}
}