//Three arrays of the same size are given. 
//Find a triplet such that (maximum – minimum) in that triplet is the minimum of all the triplets. 
//A triplet should be selected in a way such that it should have one number from each of the three given arrays.


import java.io.* ;
import java.util.* ;

public class HappiestTriplet{
	
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int n = scr.nextInt() ;
			
			int arr1[] = new int[n] ;
			int arr2[] = new int[n] ;
			int arr3[] = new int[n] ;

			for(i=0;i<n;i++)
				arr1[i] = scr.nextInt() ;

			for(i=0;i<n;i++)
				arr2[i] = scr.nextInt() ;

			for(i=0;i<n;i++)
				arr3[i] = scr.nextInt() ;

			int arr[] = new int[3] ;

			Arrays.sort(arr1);
			Arrays.sort(arr2);
			Arrays.sort(arr3);

			int ref1,ref2,ref3 ;
			ref1 = 0;
			ref2 = 0;
			ref3 = 0;

			int diff = Integer.MAX_VALUE ;
			
			while(ref1<n && ref2<n && ref3<n){
				int min = Math.min(Math.min(arr1[ref1],arr2[ref2]),arr3[ref3]) ; 
				int max = Math.max(Math.max(arr1[ref1],arr2[ref2]),arr3[ref3]) ;
				int sum = arr1[ref1] + arr2[ref2] + arr3[ref3] ;

				if(min==arr1[ref1])
					ref1++;
				else if(min==arr2[ref2])
					ref2++;
				else
					ref3++;

				if(diff>max-min){
					diff = max-min ;
					arr[0] = max ;
					arr[1] = sum - max - min ;
					arr[2] = min ;					
				}
			}

			for (i=0; i<3; i++) {
				System.out.printf("%d ",arr[i]) ;
			}
			System.out.printf("\n") ;
		}
 	}
}