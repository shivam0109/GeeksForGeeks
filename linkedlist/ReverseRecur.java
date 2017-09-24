/* Reverse Linked List Using Recursion */

public class ReverseRecur{
	static Node head ;
	static class Node{
		int data ;
		Node next ;
		Node(int val){
			data = val ;
			next = null ;
		} 
	}
	public Node reverse(Node node){
		if(node==null || node.next==null)
			return node ; 
		Node remaining = reverse(node.next) ;
		node.next.next = node ;
		node.next = null ;
		return remaining ; 
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
		ReverseRecur rr = new ReverseRecur() ;
		rr.head = new Node(1) ;
		rr.head.next = new Node(2) ;
		rr.head.next.next = new Node(3) ;
		rr.head.next.next.next = new Node(4) ;
		rr.head.next.next.next.next = new Node(5) ;
		rr.printList(rr.head) ; 
		Node newHead = rr.reverse(rr.head) ; 
		rr.printList(newHead) ; 
	}
}