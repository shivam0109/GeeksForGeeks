
//Given an array A[] ,of n numbers and another number x,
// determine whether or not there exist two elements in A whose sum is exactly x.

//Using Hash Table..Time Complexity = O(n) but works only if range of numbers is given. Space = O(range_of_numbers)
import java.util.* ;
import java.io.* ;

public class array1_a{
	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int flag = 0;
		int rsum = scr.nextInt();
		int arr[] = new int[size];
		int i = 0;
		for(i=0;i<size;i++){
			arr[i] = scr.nextInt();
		}
		for(i=0;i<size;i++){
			System.out.println(arr[i]);
		}
		int arr2[] = new int[1000];
		for(i=0;i<1000;i++){
			arr2[i] = 0;
		}
		for(i=0;i<size;i++){
			if(arr2[rsum-arr[i]]==1){
				flag = 1;
				break ;
			}
			else{
				arr2[arr[i]] = 1;
			}
		}
		if(flag == 1)
			System.out.println("Yes\n");
		else
			System.out.println("No\n");

	}
}