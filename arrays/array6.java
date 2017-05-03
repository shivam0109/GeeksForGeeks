//An element in a sorted array can be found in O(log n) time via binary search. 
//But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
//So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

//using findpivot function recursively
import java.io.* ;
import java.util.* ; 

public class array6{
	public static int bsearch(int arr[], int size, int item){
		int left = 0;
		int right = size - 1;
		int flag = 0;
		int mid = (left + right)/2	;	
		while(left<=right){
			if(item==arr[mid]){
				flag = 1;
				break ;
			}
			else if(item<arr[mid]){
				right = mid-1;
			}
			else 
				left = mid + 1;
			mid = (left + right)/2 ;
		}
		if(flag==0){
			mid = -1;
		}
		return mid ;
	}
	public static int findpivot(int arr[], int size, int left, int right){
		// if(right<left)
		// 	return -1;
		// if(right == left)
		// 	return left;
		int mid = (left+right)/2 ;
		if((mid<right) && arr[mid]>arr[mid+1])
			return mid;
		if((mid>left) && arr[mid]<arr[mid-1])
			return mid-1;
		if(arr[left]>=arr[mid])
			return findpivot(arr,size,left,mid-1);
		return findpivot(arr,size,mid+1,right);
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int i;
			int arr[] = new int[size];
			for(i=0;i<size;i++)
				arr[i] = scr.nextInt();
			int k = scr.nextInt();
			int pivot = findpivot(arr,size,0,size-1);
			//System.out.println(pivot);
			int arr1[] = Arrays.copyOfRange(arr,0,pivot+1);
			int arr2[] = Arrays.copyOfRange(arr,pivot+1,size);
			int ans1 = bsearch(arr1,arr1.length,k);
			int ans2 = bsearch(arr2,arr2.length,k);
			System.out.printf("%d %d\n", ans1,ans2);
			if((ans1 == -1) && (ans2 != -1))
				System.out.println(arr1.length + ans2);
			if((ans1 != -1) && (ans2 == -1))
				System.out.println(ans1);
			else 
				System.out.println(-1);

		}
	}
}