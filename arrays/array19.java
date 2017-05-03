//Find union and intersection of two sorted arrays

import java.io.* ;
import java.util.* ;

public class array19{
	static List<Integer> union(int arr1[], int arr2[],int n1, int n2){
		int i = 0;
		int j = 0;
		List<Integer> al = new ArrayList<Integer>();
		while(i!=n1 && j!=n2){
			if(arr1[i]>arr2[j]){
				al.add(arr2[j]);
				j++;
			}
			else if(arr1[i]<arr2[j]){
				al.add(arr1[i]);
				i++;
			}
			else{
				al.add(arr1[i]);
				i++;
				j++;
			}
		}
		if(i==n1){
			while(j!=n2){
				al.add(arr2[j]);
				j++;
			}
		}
		else{
			while(i!=n1){
				al.add(arr1[i]);
				i++;
			}
		}
		return al ;
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,k;
		for(k=0;k<ntest;k++){
			int n1 = scr.nextInt();
			int n2 = scr.nextInt();
			int arr1[] = new int[n1];
			int arr2[] = new int[n2];
			for(i=0;i<n1;i++)
				arr1[i] = scr.nextInt();
			for(i=0;i<n2;i++)
				arr2[i] = scr.nextInt();
			List<Integer> res = new ArrayList<Integer>();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			res = union(arr1,arr2,n1,n2);
			for(i=0;i<res.size();i++)
				System.out.printf("%d ",res.get(i));
			System.out.printf("\n");
		}
	}
}