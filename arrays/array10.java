//Program for array rotation


//Start printing from dth element upto nth and then from 1st to (d-1)th element. 
import java.io.* ;
import java.util.* ;

public class array10{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int size = scr.nextInt();
		int d = scr.nextInt();
		int i;
		int arr[] = new int[size];
		for(i=0;i<size;i++)
			arr[i] = scr.nextInt();
		d = d%size;
		i = d;
		while(i!=size){
			System.out.printf("%d ",arr[i]);
			i = i+1 ;
		}
		i = 0 ;
		while(i!=d){
			System.out.printf("%d ",arr[i]);
			i = i+1;
		}
	}
}