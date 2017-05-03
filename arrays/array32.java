//Given two arrays X[ ] and Y[ ] of positive integers, find number of pairs such that x^y > y^x 
//where x is an element from X[ ] and y is an element from Y[ ].

import java.io.* ;
import java.util.* ;

public class array32{
	static int bsearch(int arr[] ,int left, int right, int x){
		//System.out.println("left:"+left+" "+"right:"+right);
		while(left<=right){
			int mid = (left+right)/2 ;
			//System.out.println("mid:"+mid);
			if(arr[mid]==x)
				return mid ;
			else if(arr[mid]<x){
				left = mid+1;
			//	System.out.println("left:"+left);
			}
			else{
				right = mid-1;
			//	System.out.println("right:"+right);
			}
		}
		return left;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n1 = scr.nextInt();
			int n2 = scr.nextInt();
			int x[] = new int[n1];
			int y[] = new int[n2];
			int i;
			for(i=0;i<n1;i++)
				x[i] = scr.nextInt();
			for(i=0;i<n2;i++)
				y[i] = scr.nextInt();
			
			//Arrays.sort(x);
			Arrays.sort(y);

			int count = 0;
			for(i=0;i<n1;i++){
				if(x[i]==2){
					int cpoint = bsearch(y,0,n2-1,5);
				}
				else					
					int cpoint = bsearch(y,0,n2-1,x[i]);
				System.out.println("cpoint " + cpoint + " ");
				if(y[cpoint]==x[i] && x[i]!=1){
					count += n2-cpoint-1;
				}
				if(x[i]!=1){
					count += n2-cpoint ;
				}

			}
			
			System.out.println(count);
		}
	}
}
