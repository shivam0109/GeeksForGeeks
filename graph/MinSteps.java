import java.io.* ;
import java.util.* ;

public class MinSteps{
	public int bfs(int s, int d, int mat[][], int level[], int n){
		LinkedList<Integer> q = new LinkedList<Integer>() ; 
		q.add(s) ;
		level[s] = 0 ;
		//visited[s] = true ;
		while(!q.isEmpty()){
			int p = q.pop() ;
			for(int k=0; k<n ;k++){
				if(mat[p][k]==1){
					level[k] = Math.min(level[p]+1,level[k]) ;
					//visited[k] = true;
					if(level[k]==level[p]+1) 
						q.add(k) ; 
				}
			}
		}
		return level[d] ; 
	}
	public static void main(String[] args){
		int mat[][] = {{0,1,0},{0,0,1},{1,0,0}} ; 
	}
}