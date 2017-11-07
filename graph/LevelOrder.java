import java.util.*;
import java.io.* ;

public class LevelOrder{
    public static int BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int k, int n){
        visited[s] = true ; 
        LinkedList<Integer> q = new LinkedList<Integer>() ;
        int level[] = new int[n+1] ;
        q.add(s) ; 
        int i=0 ;
        level[s] = 0 ;
        while(!q.isEmpty()){
            int x = q.poll() ;
            System.out.println(x) ;
            ArrayList<Integer> list = adj.get(x) ; 
            for(i=0;i<list.size();i++){
                int d = list.get(i) ;
                if(!visited[d]){
                    visited[d] = true ; 
                    level[d] = level[x]+1 ; 
                    q.add(d) ; 
                }
            }
        }
        for(i=0;i<n+1;i++)
            System.out.printf("%d ",level[i]) ;
        System.out.printf("\n") ;
        int count = 0 ;
        for(i=1;i<n+1;i++){
            if(level[i]==k)
                count++ ;
        }
        return count ; 
    }
    public static void main(String args[] ) throws Exception {
        Scanner scr = new Scanner(System.in) ;
        int n = scr.nextInt() ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>() ;
        int i;
        for(i=0;i<n+1;i++){
            ArrayList<Integer> list = new ArrayList<Integer>() ;
            adj.add(list) ; 
        }
        for(i=0;i<n-1;i++){
            int a = scr.nextInt() ;
            int b = scr.nextInt() ;
            adj.get(a).add(b) ;
            adj.get(b).add(a) ;
        }
        int k = scr.nextInt() ;
        boolean visited[] = new boolean[n+1] ; 
        int ans = BFS(adj,1,visited,k,n) ; 
        System.out.println(ans) ;
    }
}
