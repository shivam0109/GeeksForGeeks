//reverse an array

import java.io.* ;
import java.util.* ;

public class array9{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int arr[] = new int[size];
		int i;
		for(i=0;i<size;i++)
			arr[i] = scr.nextInt();
		i = 0;
		int j = size-1;
		int store ;
		while(j>=i){
			store = arr[i];
			arr[i] = arr[j];
			arr[j] = store;
			i = i+1;
			j = j-1;
		}
		for(i=0;i<size;i++)
			System.out.printf("%d ",arr[i]);
 	}
}