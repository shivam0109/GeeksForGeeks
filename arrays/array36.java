//Find max element in an array which is first increasing then decreasing.

import java.io.* ;
import java.util.* ;

public class array36{
	static int modsearch(int arr[], int left, int right){
		if(left<right){
			int mid = (left+right)/2 ;
			if(mid+1>arr.length-1){
				//System.out.printf("right:%d arr[right]:%d\n",right,arr[right]);
				return right;
			}
			else if(mid-1<0){
				//System.out.printf("left:%d arr[left]:%d\n",left,arr[left]);
				return left;
			}
			else{
				if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
					//System.out.printf("mid:%d arr[mid]:%d\n",mid,arr[mid]);
					return mid;
				}
				else if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]){
					//System.out.printf("mid:%d arr[mid]:%d\n",mid,arr[mid]);
					return modsearch(arr,mid+1,right);
				}
				else{
					//System.out.printf("mid:%d arr[mid]:%d\n",mid,arr[mid]); 
					return modsearch(arr,left,mid-1);
				}
			}
		}
		return left;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int ans = modsearch(arr,0,n-1);
			System.out.println(arr[ans]);
		}
	}
}