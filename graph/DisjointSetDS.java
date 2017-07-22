/* Disjoint Set Data Structure Implementation 
   Given n individuals and some relations 1<->2 , 2<->4.. , find whether x is related to y or not. Transitivity is alloweed. 	
*/ 

/* 
Partition the individuals into different groups according to the groups in which they fall. 
This method is known as disjoint set data structure.

Initially all elements belong to different sets. After working on the given relations, we select a member as representative.
If representatives of two individuals are same, then they will become friends. (are related). 
*/

/* 
Three functions : 
makeSet 
findSet
union 
*/

import java.io.* ;
import java.util.* ;

public class DisjointSetDS{
	private Map<Long,Node> map = new HashMap() ; 

	class Node{
		long data;
		Node parent ; 
		int rank ; 
	}

	/*Create a set with only one element */
	public void makeSet(long data){
		Node node = new Node() ;
		node.data = data ;
		node.rank = 0;
		node.parent = node ; 
		map.put(data,node) ; 
	}

	/* Join two sets. Increment the rank of new parent. Return true if data1 and data2 are in different sets, else, false. */
	public boolean union(long data1, long data2){
		Node parent1 = findSet(map.get(data1)) ;
		Node parent2 = findSet(map.get(data2)) ; 
		if(parent1.data == parent2.data)
			return false ; 
		else{
			if(parent1.rank>=parent2.rank){
				if(parent1.rank == parent2.rank)
					parent1.rank++ ;
				parent2.parent = parent1 ; 
			}
			else{
				parent1.parent = parent2 ;  
			}
		}
		return true ; 
	}

	public long findSet(long data){
		return findSet(map.get(data)).data ; 
	}

	/* Finds the representative and does path compression. */
	public Node findSet(Node node){
		Node temp = node.parent  ; 
		if(temp == node)
			return temp ; 
		node.parent = findSet(temp) ; 
		return node.parent ; 
	}

	public static void main(String[] args){
		DisjointSetDS ds = new DisjointSetDS();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
	}
}
