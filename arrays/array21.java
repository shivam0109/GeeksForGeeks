//Find max(j-i) such that arr[j]>=arr[i] in O(n) time and O(n) space.

//Construct arrays premin and sufmax such that premin[i] represents the min element upto arr[i]
//sufmax[j] represents max number from arr[n-1]...arr[j]. 
//Now traverse through both the arrays. If premin[i]<=sufmax[j] do j++ bcoz we will find the j where max j-i occurs for that i. 
//If premin[i]>sufmax[j] do i++  

import java.io.* ;
import java.util.* ;

public class array21{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j,k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			int premin[] = new int[n];
			int sufmax[] = new int[n];
			
			premin[0] = arr[0];	
			
			for(i=1;i<n;i++)
				premin[i] = Math.min(arr[i],premin[i-1]);
			
			sufmax[n-1] = arr[n-1];
			
			for(i=n-2;i>=0;i--)
				sufmax[i] = Math.max(arr[i],sufmax[i+1]);
				
			// for(i=0;i<n;i++)
			// 	System.out.printf("%d ",premin[i]);
			// System.out.printf("\n");

			// for(i=0;i<n;i++)
			// 	System.out.printf("%d ",sufmax[i]);
			// System.out.printf("\n");

			i=0;
			j=0;
			int max = -1;
			while(i!=n && j!=n){
				if(premin[i]<=sufmax[j]){
					max = Math.max(j-i,max);
					j++;
				}
				else
					i++;
			}
			System.out.println(max);		
		}
	}
}
