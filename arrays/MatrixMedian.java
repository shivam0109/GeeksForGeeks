/*
Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.
*/

import java.io.* ;
import java.util.* ;

public class MatrixMedian{
	public int findSmallerElements(int arr[], int n, int num){
		int start = 0 ;
		int end = n-1 ;
		int mid = -1 ;
		if(arr[0]>num)
			return 0 ;
		if(arr[n-1]<=num)
			return n ;
		while(start<end){
			mid = start + (end-start)/2 ;
			if(mid+1<=n-1 && arr[mid]==num && arr[mid+1]!=num)
				return mid ;
			else if(mid+1<=n-1 && arr[mid]==num && arr[mid+1]==num)
				start = mid+1 ; 
			else if(arr[mid]>num && arr[mid-1]<num)
				return mid ; 
			else if(arr[mid]>num)
				start = mid+1 ;
			else
				end = mid-1 ;
		}
		return -1 ; 
	}
	public int findMedian(ArrayList<ArrayList<Integer>> a) {
        int m = a.size() ;
        if(m==0)
            return -1 ;
        int n = a.get(0).size() ;
        if(n==0)
            return -1 ;
        int min = a.get(0).get(0) ;
        int max = a.get(m-1).get(n-1) ;
        int i ;
        for(i=1;i<m;i++){
            min = Math.min(a.get(i).get(0),min) ;
            max = Math.max(a.get(i).get(n-1),max) ;
        }
        int total = m*n ; 
        int desired = (total+1)/2 ;
        int mid = -1 ;
        int smaller = 0 ;
        int index = -1 ;
        int totalSmaller = 0 ;
        while(min<max){
            mid = min + (max-min)/2 ;
            //System.out.println("mid: " + mid + " max: " + max + " min: " +min) ;
            totalSmaller = 0 ;
            smaller = 0 ;
            for(i=0;i<m;i++){
                index = Collections.binarySearch(a.get(i),mid) ;
                if(index<0)
                    smaller = Math.abs(index)-1 ;
                else{
                    int j = index ;
                    while(j<n && a.get(i).get(j)==mid)
                        j++ ;
                    smaller = j ; 
                }
                //System.out.println("smaller: " +smaller) ; 
                totalSmaller += smaller ; 
            }
            if(totalSmaller<desired)
                min = mid+1 ;
            else
                max = mid ;
        }
        return min ; 
    }
	public static void main(String[] args){
		int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} }; 
		MatrixMedian mm = new MatrixMedian() ;
		System.out.println(mm.findMedian(m)) ; 
	}
}