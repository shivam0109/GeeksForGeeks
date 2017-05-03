//Arrange given numbers to form the biggest number
//Given an array of numbers, arrange them in a way that yields the largest value. 
//For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654

import java.io.* ;
import java.util.* ;

public class array30{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			List<String> list = new ArrayList<String>();
			int i;
			for(i=0;i<n;i++)
				list.add(scr.next());			

			Collections.sort(list,new Comparator<String>(){
				public int compare(String a,String b){
					String one = a.concat(b);
					String two = b.concat(a);
					if(Integer.valueOf(one)>Integer.valueOf(two))
						return -1;
					else 
						return 1;
					}
				});	

			for(i=0;i<n;i++)
				System.out.printf("%s",list.get(i));
			System.out.printf("\n");	
		}
	}
}