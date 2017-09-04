//Given a string, print all permutations of a given string.

//Using Backtracking 
import java.io.* ;
import java.util.* ;

public class StringPermutations{
	//left denotes that indices up to left have been fixed. 
	static void permute(char[] arr, int left, int right, int len, ArrayList<String> list){
		int i; 
		if(left==right)
			list.add(String.valueOf(arr)) ;  
		else{
			for(i=left;i<=right;i++){
				//fix ith index 
				swap(arr,left,i) ;
				//pass permute from left+1
				permute(arr,left+1,right, len, list) ;
				//backtracking step..original config restored to go to other configs. 
				swap(arr,left,i) ; 
			}
		}
	}
	static void printlist(ArrayList<String> list){
		int i;
		for(i=0;i<list.size();i++)
			System.out.printf("%s ",list.get(i)) ;
		System.out.printf("\n") ;
 	}
	static void swap(char[] arr, int left, int right){
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp ; 
	}
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int j;
		for(j=0;j<ntest;j++){
			String str = scr.next();
			char[] arr = str.toCharArray() ;
			ArrayList<String> list = new ArrayList<String>() ; 
			permute(arr,0,str.length()-1,str.length(),list) ;
			Collections.sort(list) ;
			printlist(list) ;   
		}
	}
}
