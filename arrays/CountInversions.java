//count Inversions in an array 

import java.io.* ;
import java.util.* ;

public class CountInversions{
	static int merge(int[] arr, int[] temp, int left, int mid, int right){
		int i = left;
		int j = mid ;
		int k = left;
		int count = 0;
		while(i<=mid-1 && j<=right){
			if(arr[i]<=arr[j]){
				temp[k++] = arr[i++] ;
			}
			else{
				temp[k++] = arr[j++] ;
				count += mid-i;
			}
		}
		while(i<=mid-1){
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j<=right){
			temp[k] = arr[j];
			j++ ;
			k++ ;
		}
		for(i=left;i<=right;i++)
			arr[i] = temp[i] ;
		return count ;		
	}
	static int sort(int[] arr,int temp[],int left, int right){
		int mid ;
		int count = 0 ;
		if(left < right){
			mid = left + (right-left)/2 ;
			count = sort(arr,temp,left,mid) + sort(arr,temp,mid+1,right) + merge(arr,temp,left,mid+1,right); 
		}
		return count ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int i;
			int[] arr = new int[size];
			for(i=0;i<size;i++)
				arr[i] = scr.nextInt();
			int[] temp = new int[size];
			System.out.println(sort(arr,temp,0,size-1));
		}
	} 
}