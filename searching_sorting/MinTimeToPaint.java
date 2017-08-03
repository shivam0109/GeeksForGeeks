
/*
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. 
There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. 
You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.
*/

import java.io.* ;
import java.util.* ;

public class MinTimeToPaint{
  public boolean isPossible(ArrayList<Integer> c, int units, int painter, int size){
        int i=0 ;
        int temp = units ;
        System.out.println("units: "+units) ;
        while(i<size){
            if(painter==0)
                return false ; 
            if(temp-C.get(i)<0){
                temp = units ;
                painter-- ;
            }
            else{
                temp -= C.get(i) ;
                i++ ;
            }
        }
        return true ; 
  }
  public int findSum(ArrayList<Integer> list, int n){
      int sum = 0 ;
      for(int i=0; i<n ;i++)
          sum += list.get(i) ;
      return sum ; 
  }
  public int paint(int a, int b, ArrayList<Integer> c) {
      int n = c.size() ;
      int ans = 0 ;
      if(c.size()==0)
          return 0 ;
      int low = 0 ;
      int high = findSum(c,n) ;
      int mid = 1 ;
      while(low<=high){
          mid = (low+high)/2 ; 
          if(isPossible(c,mid,a,n)){
              ans = mid%10000003 ; 
              high = high -1 ;
          }
          else 
              low += 1;
      }
      long ans2 = ((long)ans)*b ;
      ans2 = ans2%10000003 ;
      return (int)(ans2) ; 
  }
  public static void main(String[] args){
    Scanner scr = new Scanner(System.in) ;
    int ntest = scr.nextInt() ;
    while(ntest-- > 0){
      int painter = scr.nextInt() ;
      int time = scr.nextInt() ;
      int n = scr.nextInt() ;
      ArrayList<Integer> list = new ArrayList<Integer>() ;
      for(int i=0; i<n ; i++)
        list.add(scr.nextInt()) ;
      MinTimeToPaint mtp = new MinTimeToPaint() ; 
      System.out.println(mtp.paint(painter,time,list)) ; 
    }
  }
}