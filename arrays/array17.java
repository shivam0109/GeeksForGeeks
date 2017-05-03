//Given an integer array, you need to find the two elements such that their sum is closest to zero.

import java.util.* ;
import java.io.* ;

public class array17{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt() ;
		int i,j ;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			int arr[] = new int[size];
			for(i=0;i<size;i++)
				arr[i] = scr.nextInt();
			Arrays.sort(arr);
			//for(i=0;i<size;i++)
			//	System.out.printf("%d ",arr[i]);
			//System.out.printf("\n");
			int left = 0;
			int right = size - 1;
			int minsum = 10000000;
			int leftans = -1;
			int rightans = -1;
			if(arr[0]>=0){
				//System.out.println(Math.abs(arr[0]+arr[1]));
				leftans = arr[0];
				rightans = arr[1];
			}
			else if(arr[size-1]<=0){
				//System.out.println(Math.abs(arr[size-2]+arr[size-1]));
				leftans = arr[size-2];
				rightans = arr[size-1];
			}
			else{
				while(left<right){
					//System.out.printf("Left: %d Right: %d\n",left,right);
					if(minsum>Math.abs(arr[left]+arr[right])){
						minsum = Math.abs(arr[left] + arr[right]);
						leftans = arr[left];
						rightans = arr[right];
					}
					if(Math.abs(arr[left+1]+arr[right]) < Math.abs(arr[left]+arr[right-1]))
						left = left + 1;
					else
						right = right - 1;	
				}
				//System.out.println(minsum);
			}
			//System.out.printf("Leftans:%d, Rightans:%d\n",leftans,rightans);
			System.out.printf("%d %d\n",leftans,rightans);			
		}
	}
}