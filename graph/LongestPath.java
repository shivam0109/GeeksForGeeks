/*
Find Longest Path in Matrix 
*/

import java.util.*;

public class LongestPath{
    public static void findFarthest(int s, int n, boolean[] visited, ArrayList<Integer> dis, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> wt, int currSum, ArrayList<Integer> node){
        visited[s] = true ;
        ArrayList<Integer> list = adj.get(s) ; 
        for(int i=0 ; i<list.size() ; i++){
            if(!visited[i]){
                if(dis.get(0)<currSum+wt.get(s).get(i)){
                    dis.set(0,currSum+wt.get(s).get(i)) ;
                    node.set(0,i) ; 
                }
                findFarthest(i,n,visited,dis,adj,wt,currSum+wt.get(s).get(i),node) ; 
            }
        }    
    }
    public static void main(String[] args){
        Scanner scr = new Scanner(System.in) ;
        int ntest = scr.nextInt() ;
        while(ntest-->0){
            int n = scr.nextInt() ;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>() ;
            boolean visited[] = new boolean[n+1] ;
            ArrayList<Integer> dis = new ArrayList<Integer>() ;
            ArrayList<ArrayList<Integer>> wt = new ArrayList<ArrayList<Integer>>() ;
            ArrayList<Integer> node = new ArrayList<Integer>() ;
            for(int i=0;i<=n;i++){
                ArrayList<Integer> list = new ArrayList<Integer>() ;
                adj.add(list) ;
                wt.add(list) ;
            }
            for(int i=0;i<n;i++){
                int a = scr.nextInt() ;
                int b = scr.nextInt() ;
                int w = scr.nextInt() ;
                adj.get(a).add(b) ;
                adj.get(b).add(a) ;
                wt.get(a).set(b,w) ;
                wt.get(b).set(a,w) ;
            }
            dis.add(0) ;
            node.add(1) ; 
            findFarthest(1,n,visited,dis,adj,wt,0,node) ;
            int src = node.get(0) ;
            dis.set(0,0) ;
            for(int i=0;i<n;i++)
                visited[i] = false ; 
            node.set(0,src) ; 
            findFarthest(src,n,visited,dis,adj,wt,0,node) ; 
            int ans = dis.get(0) ;
            int cost = 0 ;
            if(ans>10000)
                cost = 10000 ;
            else if(ans>1000)
                cost = 1000 ;
            else if(ans>100)
                cost = 100 ;
            else
                cost = 0; 
            System.out.println(cost + " " + ans) ;
        }
    }
}
