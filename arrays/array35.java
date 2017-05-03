//Triplet sum in Array 

import java.io.* ;
import java.util.* ;

public class array35{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int x = scr.nextInt();
			int arr[] = new int[n];
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			Arrays.sort(arr);
			int flag = 0;
			for(i=0;i<n-1;i++){
				int left = i+1;
				int right = n-1;
				int reqsum = x-arr[i];
				while(left<right){
					if(arr[left]+arr[right] == reqsum){
						flag = 1;
						break;
					}
					else if(arr[left]+arr[right]>reqsum)
						right--;
					else
						left++;
				}
				if(flag==1)
					break;
			}
			System.out.println(flag);
		}
	}
}