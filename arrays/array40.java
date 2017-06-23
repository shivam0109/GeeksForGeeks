//Search an element in an unsorted array using minimum number of comparisons

// for(i=0;i<n;i++){ //n+1 comparisions
// 	if(arr[i]==x){ //n comparisions
// 		print something
// 		break;
// 	}	
// }

// The above code requires 2n+1 comparisions. 

//We need to min comparisions. 
//Total n+2 comparisions. 
import java.io.* ;
import java.util.* ;

public class array40{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int x = scr.nextInt();
		int arr[] = new int[n] ;
		int i;
		for(i=0;i<n;i++)
			arr[i] = scr.nextInt();

		//Store last element of array in backup. 
		int backup = arr[n-1];

		if(backup==x)						// 1 comparision
			System.out.println("Found") ;  

		//Store x in last index; 
		arr[n-1] = x;

		for(i=0;i++){
			if(arr[i]==x){                 //n comparisions
				if(i!=n-1)					//1 comparision 
					System.out.println("Found");
			}
		}
	}
}