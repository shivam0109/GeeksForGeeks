//Construct Tree from inorder and preorder traversals.

import java.io.* ;
import java.util.* ;

public class Tree16{
	Node root;
	static class Node{
		char data;
		Node left,right;
		Node(char d){
			data = d;
			left = null;
			right = null;
		}
	}
	static int search(char[] in, char a){
		int i;
		for(i=0;i<in.length;i++){
			if(in[i]==a)
				break;
		}
		//System.out.println("rootIndex "+i);
		return i;
	}
	static Node buildTree(char[] in, char[] pre, int len){
		if(len>0){
			Node root = new Node(pre[0]);
			int rootIndex = search(in,pre[0]);
			int nleft = rootIndex ;
			int nright = len-rootIndex-1;
			if(nleft!=0){
				char[] leftIn = Arrays.copyOfRange(in,0,rootIndex);
				char[] leftPre = Arrays.copyOfRange(pre,1,nleft+1);
				root.left = buildTree(leftIn,leftPre,nleft);
			}
			if(nleft==0)
				root.left = null;
			if(nright!=0){
				char[] rightIn = Arrays.copyOfRange(in,rootIndex+1,len);
				char[] rightPre = Arrays.copyOfRange(pre,nleft+1,len);
				root.right = buildTree(rightIn, rightPre, nright);
			}
			if(nright==0)
				root.right = null ;
			return root ;
		}
		else
			return null ;
	}
	static void inorder(Node root){
		if(root==null)
			return;
		else{
			inorder(root.left);
			System.out.printf("%c ",root.data);
			inorder(root.right);
		}
	}
	public static void main(String[] args){
		Tree16 tree = new Tree16();
		Scanner scr = new Scanner(System.in);
		int len = scr.nextInt();
		char[] in = new char[len];
		char[] pre = new char[len];
		int i;
		for(i=0;i<len;i++)
			in[i] = scr.next().charAt(0);
		for(i=0;i<len;i++)
			pre[i] = scr.next().charAt(0);
		tree.root = buildTree(in,pre,in.length);
		inorder(tree.root);
		System.out.printf("\n");
	}
}
