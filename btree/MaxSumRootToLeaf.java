/*
Given a Binary Tree, find the maximum sum path from a leaf to root.
*/ 

import java.io.* ;
import java.util.* ;

public class MaxSumRootToLeaf{
	Node root ; 
	static class Node{
		Node left,right ;
		int data ;
		Node(int d){
			data = d ;
		}
	}
	public boolean isLeaf(Node root){
		return root.left==null && root.right==null ;
	}
	public void maxSum(Node root, ArrayList<Integer> list, ArrayList<Integer> res, int sum, ArrayList<Integer> max){
		if(root==null)
			return ; 
		if(isLeaf(root)){
			if(max.get(0)<sum){
				max.set(0,sum) ;
				res.clear() ;
				for(int i=0; i<list.size();i++)
					res.add(list.get(i)) ; 
			}
			else
				return ;  
		}
		if(root.left!=null){
			list.add(root.left.data) ;
			maxSum(root.left,list,res,sum+root.left.data,max) ;
			list.remove(list.size()-1) ;
		}
		if(root.right!=null){
			list.add(root.right.data) ; 
			maxSum(root.right,list,res,sum+root.right.data,max) ; 
			list.remove(list.size()-1) ;
		}
	}
	public static void main(String[] args){
		MaxSumRootToLeaf tree = new MaxSumRootToLeaf() ;
		tree.root = new Node(10) ;
		tree.root.left = new Node(-2) ;		
		tree.root.left.left = new Node(8) ;
		tree.root.left.right = new Node(-4) ; 
		tree.root.right = new Node(7) ; 
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		ArrayList<Integer> res = new ArrayList<Integer>() ;
		ArrayList<Integer> max = new ArrayList<Integer>() ;
		list.add(tree.root.data) ; 
		max.add(Integer.MIN_VALUE) ; 
		MaxSumRootToLeaf ms = new MaxSumRootToLeaf() ;
		ms.maxSum(tree.root,list,res,tree.root.data,max) ; 
		System.out.println(res) ; 
		System.out.println(max.get(0)) ; 
	}
}