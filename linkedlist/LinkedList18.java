//Detect and remove loop in LinkedList

//Loop Detection: Move slow pointer by 1 and fast by 2 units. 
//If they meet, then linkedlist has a loop.
//Loop Removal: Suppose the head of loop starts from m units after the head of linkedlist. Suppose the loop has n elements.
//The pointers meet after k units. 
//Then, m+n*x+k = 2(m+n*y+k) x,y - no. of rounds of loop of fast and slow pointer res.   
//m + k = (x-2y)*n
//m + k is a multiple of n.
//If we move one pointer from head of list and other from meeting point with same speed, the point 
//at which they will meet will be the start point of loop.
//At present, the meeting point is at k, -> move it k more.  

import java.io.* ;
import java.util.* ;

public class LinkedList18{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d){
			d = data;
			next = null;
		}
	}
	static int detectandremoveloop(Node head){
		Node slow = head;
		Node fast = head;
		int flag = 0;
		Node temp;
		while(fast!=null){
			if(fast == slow){
				flag = 1;
				break;
			}
			else{
				if(fast.next==null)
					fast = fast.next;
				else{
					fast = fast.next.next;
					slow = slow.next;
				}
			}			
		}
		temp = fast;
		if(flag==1){
			slow = head;
			while(slow.next!=temp.next){
				slow = slow.next;
				temp = temp.next;
			}
		}
		if(temp!=null)
			temp.next = null;
		
		return flag;
	}
	public static void main(String[] args){
		LinkedList18 llist = new LinkedList18();
		llist.head = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		llist.head.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = b;

		int ans = detectandremoveloop(llist.head);
		System.out.println(ans);
		Node temp = llist.head;
		while(temp!=null){
			System.out.printf("%d ",temp.data);
			temp = temp.next;
		}
		System.out.printf("\n");
	}
}