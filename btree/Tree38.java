//Bottom View of q Binary Tree. 

//A node x is there in output if x is the bottommost node at its horizontal distance from root. 

import java.io.* ;
import java.util.* ;

public class Tree38{
	Node root;
	static class Node{
		int data;
		Node left,right;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	static int findDistance(Node root, int data, int level){
		if(root==null)
			return -1;
		
		if(root.data==data)
			return level;
		
		int left = findDistance(root.left,data,level+1);
		int right = findDistance(root.right,data,level+1);
		
		if(left!=-1)
			return left;
		else
			return right;
	}
	static void bottomView(Node root, Node node, int hd, HashMap<Integer,Integer> hmap){
		if(node==null)
			return;
		if(!hmap.containsKey(hd))
			hmap.put(hd,node.data);
		else{
			if( findDistance(root,node.data,0) >= findDistance(root,hmap.get(hd),0) )
				hmap.put(hd,node.data);
		}
		bottomView(root,node.left,hd-1,hmap);
		bottomView(root,node.right,hd+1,hmap);
	}
	static Map<Integer,Integer> sortMap(LinkedHashMap<Integer,Integer> hmap){
		List<Map.Entry<Integer,Integer>> listentry = new ArrayList<Map.Entry<Integer,Integer>>(hmap.entrySet()) ;
		Collections.sort(listentry,new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
				return a.getKey().compareTo(b.getKey());
			}
		} );
		Map<Integer,Integer> sortedmap = new LinkedHashMap<Integer,Integer>();
		for(Map.Entry<Integer,Integer> entry : listentry){
			sortedmap.put(entry.getKey(), entry.getValue());
		}
		return sortedmap ;
	}
	public static void main(String[] args){
		Tree38 tree = new Tree38();
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
		LinkedHashMap<Integer,Integer> hmap = new LinkedHashMap<Integer,Integer>() ;
		bottomView(tree.root,tree.root,0,hmap);
		Map<Integer,Integer> sortedMap = sortMap(hmap);
        System.out.println(sortedMap);
        System.out.println(sortedMap.keySet());
        for(Integer key : sortedMap.keySet())
        	System.out.printf("%d ",key);
        System.out.printf("\n");
        //System.out.println(findDistance(tree.root,14,0));
	}
}