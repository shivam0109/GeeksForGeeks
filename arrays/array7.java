//There are two sorted arrays. First one is of size m+n containing only m elements. 
//Another one is of size n and contains n elements. 
//Merge these two arrays into the first array of size m+n such that the output is sorted. Time : O(m+n)


//move the NA elements to one side of the array and then use merge algorithm from merge sort to arrange
//the elements in the bigger array. 
import java.io.* ;
import java.util.* ;

public class array7{
	public static void moveToEnd(int arr1[],int n,int m){
		int i = 0;
		int j = n;
		int store;
		while(i!=n && j!= n+m){
			if(arr1[i]==-1 && arr1[j]==-1){
				i = i+1;
				j = j+1;
			}
			else if(arr1[i] != -1 && arr1[j] == -1){
				store = arr1[i];
				arr1[i] = arr1[j];
				arr1[j] = store;
				i = i+1;
				j = j+1; 
			}
			else if(arr1[i] == -1 && arr1[j] != -1){
				i = i+1;
			}
			else{
				if(arr1[i] >= arr1[j] && arr1[j] != -1){
					j = j+1;
				}
				if(arr1[i] < arr1[j] && arr1[i] != -1){
					store = arr1[j];
					arr1[j] = arr1[i];
					arr1[i] = store;
					j = j+1;
				}
			}
		}		
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int m = scr.nextInt();
		int n = scr.nextInt();
		int i,j,k;
		int arr1[] = new int[m+n];
		int arr2[] = new int[n];
		for(i=0;i<(m+n);i++){
			arr1[i] = scr.nextInt();
		}
		for(i=0;i<n;i++){
			arr2[i] = scr.nextInt();
		}
		i = 0 ; j = n;
		moveToEnd(arr1,n,m);
		// for(i=0;i<(m+n);i++){
		// 	System.out.printf("%d ",arr1[i]);
		// }
		i = n ;
		j = 0 ;
		k = 0 ;
		while(i != m+n && j != n){
			if(arr1[i] >= arr2[j]){
				arr1[k] = arr2[j];
				j = j+1;
				k = k+1;
			}
			else{
				arr1[k] = arr1[i];
				i = i+1;
				k = k+1;
			}
		//	System.out.printf("i : %d j : %d  k: %d\n",i,j,k);
		}
		if(i==m+n){
			while(j!=n){
				arr1[k] = arr2[j];
				j = j+1;
				k = k+1;
		//		System.out.printf("j : %d k : %d\n", j,k);
			}
		}
		
		for(k=0;k<(m+n);k++){
			System.out.printf("%d ", arr1[k]);
		}
	}
}