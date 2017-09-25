//mergesort for linkedlist

import java.io.* ;
import java.util.* ;

public class MergeSort{
	static Node head ;
	static class Node{
		Node next ;
		int data ;
		Node(int d){
			data = d;
			next = null ;
		}
	}
	public Node getMid(Node node){
		if(node==null || node.next==null)
			return node ;
		Node slow = node ;
		Node fast = node.next ;
		while(fast!=null && fast.next!=null){
			slow = slow.next ;
			fast = fast.next.next ;
		}
		return slow ;
	}
	public Node mergeSort(Node node){
		if(node==null || node.next==null)
			return node ;
		Node mid = getMid(node) ;
		Node midNext = mid.next ;
		mid.next = null ;
		Node left = mergeSort(node) ;
		Node right = mergeSort(midNext) ;
		Node head = merge(left,right) ;
		return head ; 
	}
	
	public Node merge(Node node1, Node node2){
		Node head = new Node(0) ;
		Node temp = head ;
		Node temp1 = node1 ;
		Node temp2 = node2 ;
		while(temp1!=null && temp2!=null){
			if(temp1.data<temp2.data){
				temp.next = temp1 ;
				temp1 = temp1.next ;
			}
			else{
				temp.next = temp2 ;
				temp2 = temp2.next ;
			}
			temp = temp.next ;
		}
		while(temp1!=null){
			temp.next = temp1 ;
			temp1 = temp1.next ;
			temp = temp.next ; 
		}
		while(temp2!=null){
			temp.next = temp2 ;
			temp2 = temp2.next ;
			temp = temp.next ; 
		}
		return head.next ;
	}

	public void printList(Node head){
		Node temp = head ;
		while(temp!=null){
			System.out.printf("%d ",temp.data) ;
			temp = temp.next ;
		}
		System.out.printf("\n") ; 
	}
	public static void main(String[] args){
		MergeSort ms = new MergeSort() ;
		ms.head = new Node(10) ;
		ms.head.next = new Node(3) ;
		ms.head.next.next = new Node(9) ;
		ms.head.next.next.next = new Node(5) ;
		ms.head.next.next.next.next = new Node(8) ;
		ms.head.next.next.next.next.next = new Node(1) ;
		ms.printList(ms.head) ;
		Node newHead =  ms.mergeSort(ms.head) ;
		//System.out.println(newHead.data) ;
		ms.printList(newHead) ; 
	}
}