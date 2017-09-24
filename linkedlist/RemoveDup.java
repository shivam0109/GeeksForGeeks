/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
*/

import java.io.* ;
import java.util.* ;

public class RemoveDup{
	static Node head ;
	static class Node{
		Node next ;
		int val ;
		Node(int d){
			next = null ;
			val = d; 
		}
	}
	public Node removeHead(Node head){
		if(head==null || head.next==null)
			return head ;
		Node node = head ;
		Node next = head.next ;
		if(node.val!=next.val)
			return node;
		Node temp = node ; 
		while(temp!=null && node.val == temp.val)
			temp = temp.next ; 	
		return removeHead(temp) ;  
	}
	public Node removeDup(Node head){
		head = removeHead(head) ; 
		if(head==null || head.next==null)
			return head;
		Node prev = head ; 
		Node curr = head.next ;
		Node next1 = head.next.next ; 
		while(next1!=null){
			if(curr.val!=next1.val){
				prev = curr ;
				curr = next1 ;
				next1 = next1.next ; 
			}
			else{
				Node temp = curr ;
				while(temp!=null && temp.val == curr.val)
					temp = temp.next ; 
				if(temp==null){
					curr = null ;
					next1 = null ; 
					prev.next = null ;
				}
				else{
					prev.next = temp ;
					curr = temp ;
					next1 = temp.next ; 
				}
			}
		}
		return head ;   
	}
	public void printList(Node head){
		Node temp = head ;
		while(temp!=null){
			System.out.printf("%d ",temp.val) ;
			temp = temp.next ;
		}
		System.out.printf("\n") ; 
	}
	public static void main(String[] args){
		RemoveDup rd = new RemoveDup() ; 
		rd.head = new Node(1) ;
		rd.head.next = new Node(1) ;
		rd.head.next.next = new Node(2) ;
		rd.head.next.next.next = new Node(2) ;
		rd.head.next.next.next.next = new Node(3) ;
		rd.head.next.next.next.next.next = new Node(4) ;
		rd.head.next.next.next.next.next.next = new Node(4) ;
		rd.head.next.next.next.next.next.next.next = new Node(5) ;
		rd.head.next.next.next.next.next.next.next.next = new Node(6) ;
		rd.printList(rd.head) ;
		Node newhead = rd.removeDup(rd.head) ;
		rd.printList(newhead) ;  
	}
}