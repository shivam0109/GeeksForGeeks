//Implement Adjacency List 

/* 
Steps:
1. Create a private hashmap which will store keys as vertices and edges as list (value to keys). 
2. Constructor will take number of vertices as input and create the map. 
3. setEdge modifies the list
4. getEdge returns the list. 
*/
import java.io.* ;
import java.util.* ;

public class AdjList{
	Map<Integer, List<Integer>> Adjacency_List ; 

	public AdjList(int numVertices){
		Adjacency_List = new HashMap<Integer, List<Integer>>() ;
		for(int i = 1; i<=numVertices ;i++)
			Adjacency_List.put(i,new LinkedList<Integer>()) ; 
	}

	public void setEdge(int source, int destination){
		if(source > Adjacency_List.size() || destination > Adjacency_List.size()){
			System.out.println("Cant add more") ; 
			return ;
		}
		//get the list corresponding to the key and add the connected vertex in it's list. 
		List sList = Adjacency_List.get(source) ; 
		sList.add(destination) ; 

		//get the list corresponding to the key and add the connected vertex in it's list. Only in undirected graph. 
		List dList = Adjacency_List.get(destination) ;
		dList.add(source) ; 
	}

	public List<Integer> getEdge(int source){
		if(source > Adjacency_List.size()){
			System.out.println("Vertex Not Present") ; 
			return null ;
		}
		return Adjacency_List.get(source) ; 
	}
	
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		System.out.println("Enter number of vertices and edges") ;
		int numVertices = scr.nextInt() ;
		int numEdges = scr.nextInt() ;
		AdjList adjList = new AdjList(numVertices) ;	
		int count = 1;
		while(count<=numEdges){
			int source = scr.nextInt() ;
			int destination = scr.nextInt() ;
			adjList.setEdge(source, destination) ; 
			count ++ ;
		}

		int i,j;

		for(i=1;i<=numVertices;i++){
			List edgeList = adjList.getEdge(i) ;
			System.out.printf("%d ", i) ;
			for(j=1;j<=edgeList.size();j++)
				System.out.printf("%d ", edgeList.get(j-1)) ;
			System.out.printf("\n") ; 
		}
	
	}

 }