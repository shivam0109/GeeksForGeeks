//Find the smallest missing number in an unsorted array in O(n) time and O(1) space.

import java.io.* ;
import java.util.* ;

public class array37{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int arr[] = new int[size];
			
			for(i=0;i<size;i++){
				int num = scr.nextInt();
				if(num>0 && num<=size)
					arr[num-1] = 1; 
			}

			for(i=0;i<size;i++){
				if(arr[i]==0){
					System.out.println(i+1);
					break;
				}
			}
		
		}
	}
}