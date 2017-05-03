//Given a Linked List of integers, write a function to modify the linked list such that 
//all even numbers appear before all the odd numbers in the modified linked list. 
//Also, keep the order of even and odd numbers same.

import java.io.* ;
import java.util.* ;

public class LinkedList20{
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
		LinkedList20 llist = new LinkedList20();
		llist.head = new Node(scr.nextInt());
		Node temp = llist.head;
		int i;
		for(i=1;i<size;i++){
			temp.next = new Node(scr.nextInt());
			temp = temp.next;
		}
		return llist.head;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		Node head1 = buildlist(size);
		Node even_num = null;
		Node odd_num = null;
		Node temp = head1;
		Node prev = null;
		Node store;
		int flag = 0;
		while(temp!=null){
			if(temp.data%2==1){
				if(flag == 0){
					odd_num = temp;
					flag = 1;
				}
				prev = temp;
				temp = temp.next;				
			}
			else{
				if(temp==head1){
					even_num = temp;
					prev = temp;
					temp = temp.next;
				}
				else if(prev.data%2 == 0){
					even_num = temp;
					prev = temp;
					temp = temp.next;
				}
				else{
					Node newevennode = new Node(temp.data);
					prev.next = temp.next;
					temp = prev.next;
					if(even_num == null)
						head1 = newevennode;
					else{
						store = even_num.next;
						even_num.next = newevennode;
						newevennode.next = store;
					}
					even_num = newevennode; 
				}
			}	
		}
		if(even_num != null)
			even_num.next = odd_num;
		temp = head1;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next ;
		}
		System.out.printf("\n");
	}
}