/*
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
*/

/*
Take 4 variables. 
top,bottom,left,right and a direction var to specify which direction to move.  
top = 0 ; 
bottom = m-1 ;
left = 0 ;
*/

import java.io.* ;
import java.util.* ;

public class SpiralOrder1{
	public ArrayList<Integer> spiralOrder(List<ArrayList<Integer>> a){
		int m = a.size() ;
		if(m==0)
			return new ArrayList<Integer>() ;
		int n = a.get(0).size() ;
		if(n==0)
			return new ArrayList<Integer>() ;
		int top = 0 ;
		int bottom = m-1 ; 
		int left = 0 ;
		int right = n-1 ; 
		int dir = 0 ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		while(top<=bottom && left<=right){
			//move from left to right. 
			if(dir==0){
				for(int i=left ; i<=right ; i++){
					list.add(a.get(top).get(i)) ; 
				}
				top++ ;
				dir = 1 ;
			}
			//move from top to bottom. 
			if(dir==1){
				for(int i=top ; i<=bottom ; i++)
					list.add(a.get(i).get(right)) ; 
				right-- ;
				dir = 2;
			}
			//move from right to left. 
			if(dir==2){
				for(int i=right ; i>=left ;i--)
					list.add(a.get(bottom).get(i)) ; 
				bottom-- ;
				dir=3 ;
			}
			//move from bottom to top. 
			if(dir==3){
				for(int i=bottom; i>=top ;i--)
					list.add(a.get(i).get(left)) ;
				left++ ;
				dir=1 ; 
			}
		}
		return list ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ; 
		int ntest = scr.nextInt() ;
		while(ntest-- > 0){
			int m = scr.nextInt() ;
			int n = scr.nextInt() ;
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>() ;
			int i,j ;
			for(i=0;i<m;i++){
				ArrayList<Integer> inList = new ArrayList<Integer>() ;
				for(j=0;j<n;j++){
					int num = scr.nextInt() ;
					inList.add(num) ; 
				}
				list.add(inList) ; 
			}
			SpiralOrder1 spiral = new SpiralOrder1() ;
			System.out.println(spiral.spiralOrder(list)) ; 
		}
	}
}