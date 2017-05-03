//Given a number n, find the smallest number that has same set of digits as n and is greater than n. 
//If x is the greatest possible number with its set of digits, then print “not possible”.

import java.io.* ;
import java.util.* ;

public class math1{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j=0,k;
		for(k=0;k<ntest;k++){
			int flag = 0;
			String num = scr.next();
			int arr[] = new int[num.length()];
			int size = arr.length;
			for(i=0;i<size;i++){
				char c = num.charAt(i);
				arr[i] = Character.getNumericValue(c);
			}
			for(i=size-1;i>=1;i--){
				if(arr[i-1]<arr[i]){
					flag = 1;
					break;
				}
			}
			System.out.println("i:"+i);
			if(flag==1){
				//find min and minindex greater than arr[i-1]
				int ind1 = i-1;
				int min=10;
				int minindex = i;			
				for(j=i;j<arr.length;j++){
					if(arr[j]<min && arr[j]>arr[i-1]){
						min = arr[j];
						minindex = j;
					}
				}
				System.out.println("min:"+min);
				//swap index i-1 and minindex.
				int temp = arr[i-1];
				arr[i-1] = arr[minindex];
				arr[minindex] = temp;

				//sort array from index i to arr.length-1
				int arr2[] = Arrays.copyOfRange(arr,i,arr.length);
				Arrays.sort(arr2);

				for(j=0;j<arr.length;j++){
					if(j<i){
						System.out.printf("%d",arr[j]);
					}
					else{
						System.out.printf("%d",arr2[j-i]);
					}
				}
			}
			else
				System.out.printf("not possible");
			System.out.printf("\n");
		}
	}
}