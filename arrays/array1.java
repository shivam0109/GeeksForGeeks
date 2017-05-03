
//Given an array A[] ,of n numbers and another number x,
//determine whether or not there exist two elements in A whose sum is exactly x.

//Using sorting 
import java.util.* ;
import java.io.* ;

public class array1{
	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i = 0;
		for(i=0;i<ntest;i++){
			int size = scr.nextInt();
			int rsum = scr.nextInt();
			int j=0;
			int arr[] = new int[size];
			for(j=0;j<size;j++){
				arr[j] = scr.nextInt();
			}
			Arrays.sort(arr);
			int flag = 0;
			int left = 0;
			int right = size-1;
			while(left<right){
				if(arr[left] + arr[right] == rsum){
					flag = 1;
					break;
				}
				else if(arr[left] + arr[right] > rsum){
					right = right - 1;
					//System.out.println("Right: " + right);
				}	
				else {
					left = left + 1;
					//System.out.println("Left: " + left);
				}
			}
   			if(flag==1)
   				System.out.println("YES");
   			else
   				System.out.println("NO");	
   		}
	}
}