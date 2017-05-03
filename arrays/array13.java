//Maximum sum such that no two elements are adjacent

//at each step, consider 2 sums, one including the current element and other excluding the current element
//take max at each step and continue the max at next step
//PS : the elements may or may not be alternate
import java.io.* ;
import java.util.* ;

public class array13{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0; k<ntest; k++){
			int size = scr.nextInt();
			int i;
			int arr[] = new int[size];
			for(i=0;i<size;i++)
				arr[i] = scr.nextInt();
			int sum1 = arr[0];
			int sum2 = 0;
			int store;
			for(i=1;i<size;i++){
				store = Math.max(sum1,sum2);
				sum1 = sum2 + arr[i];
				sum2 = store;
			}
			System.out.println(Math.max(sum1,sum2));
		}		
	}
}