//Array Implementation of Queue
//Difference b/w stack and queue is in removing. 
//Stack follows LIFO and queue follows FIFO. 
//Enqueue : Add item to the queue
//Dequeue : Remove from back.
//Front : Item in front.
//Rear : Item in back.

//Used in Breadth First Search. When things dont need to be processed immediately. 

import java.io.* ;
import java.util.* ;

public class queue1{
	static final int max = 100;
	int arr[] = new int[max];
	int front,rear,len;

	queue1(){
		len = 0;
		front = -1;
		rear = -1;
		//int arr[] = new int[size];
	}
	
	boolean isempty(){
		return front==-1 ;
	}

	boolean enqueue(int x){
		if(front==-1 && rear == -1){
			front = 0;
			rear = 0;
			len++;
			return true;
		}
		else{
			if(rear==max){
				System.out.println("Overflow");
				return false;
			}
			else{
				rear = rear + 1;
				System.out.println("rear:"+rear+" "+"arr length:"+arr.length+" ");
				arr[rear] = x;
				len++;
				return true;
			}
		}
	}

	boolean isFull(){
		return front==0 && rear == max-1 ;
	}

	int dequeue(){
		if(isempty()){
			System.out.println("Underflow");
			return -1;
		}
		else{
			len--;
			int x = arr[front];
			if(front!=-1){
				front++;
			}
			else{
				front = -1;
				rear = -1;
			}
			return x;
		}
	}

	int getSize(){
		return len;
	}

	void display(){
		if(len==0){
			System.out.println("Empty");
		}
		else{
			for(int i=front;i<=rear;i++)
				System.out.printf("%d ",arr[i]);
			System.out.printf("\n");
		}
	}

	int frontitem(){
		if(len==0){
			System.out.println("Empty");
			return -1;
		}
		else
			return arr[front];
	}

	int rearitem(){
		if(len==0){
			System.out.println("Empty");
			return -1;
		}
		else
			return arr[rear];
	}

	public static void main(String[] args){
		queue1 q = new queue1();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.display();
		q.dequeue();
		q.dequeue();
		q.display();
	}
}