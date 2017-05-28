//count inversions in an array 	

import java.io.* ;
import java.util.* ;

public class CountInversions{
	static int merge(int[] arr, int l, int m, int r){
		int i,j,k,n1,n2;
		int count = 0; 
		n1 = m-l;
		n2 = r-m ;
		int[] left = new int[n1] ;
		int[] right = new int[n2] ;
		
		for(i=0;i<n1;i++)
			left[i] = arr[l+i] ;
		
		for(j=0;j<n2;j++)
			right[j] = arr[m+j] ;
		
		// System.out.println("left:") ;
		// printArray(left,n1) ;
		// System.out.println("right: " ) ;
		// printArray(right,n2) ;
				
		i=j=0;
		
		k = l;
		
		while(i<n1&&j<n2){
			if(left[i]<=right[j]){
				arr[k] = left[i] ;
				i++ ;
			}
			else{
				arr[k] = right[j] ;
				j++ ;
				//System.out.println("l m i r" +l+" " +m +" " + i+ " "+ r);
				count += m-i-l ;
			}
			k++ ;
		}
		
		//System.out.println("count " + count) ;
		
		while(i<n1){
			arr[k] = left[i] ;
			i++ ;
			k++ ;
		}

		while(j<n2){
			arr[k] = right[j] ;
			j++;
			k++;
		}

		return count ;
	}

	static int sort(int[] arr, int l, int r){
		if(l<r-1){
			int mid = l + (r-l)/2  ;
			return sort(arr,l,mid) + sort(arr,mid,r) + merge(arr, l, mid, r) ;
		}
		else
			return 0 ;
	}

	static void printArray(int[] arr, int len){
		int i;
		for(i=0;i<len;i++)
			System.out.printf("%d ",arr[i]) ;
		System.out.printf("\n") ;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int size = scr.nextInt() ;
			int i;
			int arr[] = new int[size] ;
			for(i=0;i<size;i++){
				arr[i] = scr.nextInt() ;
			}
			int invcount = sort(arr,0,size) ;
			//printArray(arr,size) ;
			System.out.println(invcount) ;
		}
	}

}