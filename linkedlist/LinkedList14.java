//There are two singly linked lists in a system. 
//By some programming error the end node of one of the linked list got linked into the second list, 
//forming a inverted Y shaped list. Write a program to get the point where two linked lists merge.

import java.io.* ;
import java.util.* ;

public class LinkedList14{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static int findlen(Node head){
		Node temp = head;
		int count = 0;
		while(temp!=null){
			count = count + 1;
			temp = temp.next;
		}
		return count ;
	}
	public static void main(String[] args){
		LinkedList14 llist1 = new LinkedList14();
		LinkedList14 llist2 = new LinkedList14();
		llist1.head = new Node(3);
		Node a = new Node(6);
		Node b = new Node(9);
		Node c = new Node(15);
		Node d = new Node(30);
		llist2.head = new Node(10);
		llist1.head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		llist2.head.next = cif;

		int len1 = findlen(llist1.head);
		int len2 = findlen(llist2.head);
		int dif = Math.abs(len1-len2);
		System.out.println(len1 + " " + len2 + " " + dif);

		Node temp1 = llist1.head ;
		Node temp2 = llist2.head ;

		int i = 0;
		int flag = 0;

		while(i!=dif){
			if(len1<len2){
				temp2 = temp2.next;
			}
			else{
				temp1 = temp1.next;
			}
			i = i+1;	
		}

		System.out.println(temp1.data);
		System.out.println(temp2.data);

		while(temp1!=null && temp2!=null){
			if(temp1 == temp2){
				flag = 1;
				break;
			}
			else{
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}

		if(flag==1)
			System.out.println(temp1.data + " " + flag);
		else
			System.out.println(-1);
	
	}
}