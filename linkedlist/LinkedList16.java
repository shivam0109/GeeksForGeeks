//Write a removeDuplicates() function which takes a list and 
//deletes any duplicate nodes from the list. The list is not sorted.

import java.io.* ;
import java.util.* ;

public class LinkedList16{
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
		LinkedList16 llist = new LinkedList16();
		Scanner scr = new Scanner(System.in);
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
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		Node curr = head1;
		Node prev = null;
		while(curr!=null){
			if(hmap.containsKey(curr.data)){
				prev.next = curr.next;
			}
			else{
				hmap.put(curr.data,1);
				prev = curr;
			}
			curr = curr.next;
		}
		Node temp = head1;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}