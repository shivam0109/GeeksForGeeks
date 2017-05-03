//Given two numbers represented by two lists, write a function that returns sum list. 
//The sum list is list representation of addition of two input numbers.

//First List: 5->6->3  // represents number 365
//Second List: 8->4->2 //  represents number 248
//Resultant list: 3->1->6  // represents number 613

import java.io.* ;
import java.util.* ;

public class LinkedList8{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	static int list2int(Node node){
		Node temp = node;
		int num = 0;
		int count = 1;
		while(temp!=null){
			num = num + count*temp.data;
			temp = temp.next;
			count = count*10 ;			
		}
		return num;
	}
	static Node int2list(int num){
		LinkedList8 llist = new LinkedList8();
		//System.out.println("reached int2list");
		llist.head = new Node(0);
		Node temp = llist.head;
		Node temp2 = llist.head;
		int count = 0;
		while(num>0){
			count = count + 1;
			//System.out.println("reached while loop " + count);
			temp.data = num%10 ;
			num = num/10 ;
			if(num>0)
				temp.next = new Node(0);
			temp = temp.next;
			//System.out.printf("%d ",temp.data);
		}
		return temp2 ;		
	}

	public static void main(String[] args){
		LinkedList8 llist1 = new LinkedList8();
		LinkedList8 llist2 = new LinkedList8();
		LinkedList8 llist3 = new LinkedList8();

		llist1.head = new Node(5);
		Node a = new Node(4);
		//Node b = new Node(3);
		llist1.head.next = a ;
		//a.next = b ;

		int num1 = list2int(llist1.head);

		llist2.head = new Node(5);
		Node c = new Node(4);
		Node d = new Node(3);
		llist2.head.next = c ;
		c.next = d ;

		int num2 = list2int(llist2.head);

		System.out.println(num1+num2);
		Node temp = int2list(num1+num2);
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}