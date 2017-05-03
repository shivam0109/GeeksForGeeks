//Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

import java.io.* ;
import java.util.* ;

public class array34{
	static int first = -1;
    static void bsearch(int arr[],int left, int right,int x){
        int mid = (left+right)/2 ;
        if(left<=right){
            if(arr[mid]==x){
                first = mid;
                bsearch(arr,left,mid-1,x);
            }
            else if(arr[mid]>x)
                bsearch(arr,left,mid-1,x);
            else
                bsearch(arr,mid+1,right,x);
            }
        }
    static void printmat(int mat[][], int m, int n){
    	int i,j;
    	for(i=0;i<m;i++){
    		for(j=0;j<n;j++)
    			System.out.printf("%d ",mat[i][j]);
    		System.out.printf("\n");
    	}
    }
	public static void main (String[] args) {
		//code
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
		    int m = scr.nextInt();
		    int n = scr.nextInt();
		    int mat[][] = new int[m][n];
		    int i,j;
		    for(i=0;i<m;i++){
		        for(j=0;j<n;j++){
		            mat[i][j] = scr.nextInt();
		        }
		    }
		    printmat(mat,m,n);
		    int arr[] = new int[n];
		    for(i=0;i<m;i++){
		    	for(j=0;j<n;j++)
		    		arr[j] = mat[i][j];
		    	bsearch(arr,0,n-1,1);
		    	if(first!=-1)
		    		break;	
		    }
		    int first1_i = i;
		    int first1_j = first ; 
		    int maxrow = i;
		    int maxnum = n-first;
		    int l;
		    j = first1_j;
		    while(i<m-1){
		    	if(mat[i+1][j]==0){
		    		i++;
		    		System.out.print("x\n");
		    	}
		    	else{
		    		//search for first 1 in this row
		    		System.out.print("y\n");
		    		for(l=0;l<n;l++)
		    			arr[l] = mat[i+1][l];
		    		bsearch(arr,0,n-1,1);
		    		maxrow = i+1;
		    		maxnum = n-first;
		    		j = first;
		    		if(maxnum==n)
		    			break;
		    		i++;
		    	}
		    	System.out.println("i:"+i+" "+"maxnum:"+maxnum+" "+"maxrow:"+maxrow+" ");
		    }	
		    //System.out.printf("%d %d\n",maxnum,maxrow);
		}
	}
}