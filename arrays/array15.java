//Print the elements of an array in the decreasing frequency 
//if 2 numbers have same frequency then print the one which came first.

//Take input as key in hash table and their count as value.
//Convert it into arraylist to use Collection.sort with a new Comparator function. 
//Iterate through the arraylist for printing the key (count number of times). 

import java.util.* ;
import java.io.* ;

public class array15{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int i,j;
		for(j=0;j<ntest;j++){
			int size = scr.nextInt();
			LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<Integer,Integer>() ;
			while(size>0){
				int in = scr.nextInt();
				if(lhmap.containsKey(in)){
					lhmap.put(in,lhmap.get(in)+1);
				}
				else{
					lhmap.put(in,1);
				}
				size = size - 1;
			}
			List<Map.Entry<Integer,Integer>>entries = new ArrayList<Map.Entry<Integer,Integer>>(lhmap.entrySet());

			Collections.sort(entries, new Comparator<Map.Entry<Integer,Integer>>(){
				public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
					int compans = a.getValue().compareTo(b.getValue());
					if(compans == 0){
						return a.getKey().compareTo(b.getKey());
					}
					else 
						return -compans ;
				}
			});

			//System.out.println(entries);
			for(Map.Entry<Integer,Integer> entry : entries){
				for(i=0;i<entry.getValue();i++){
					System.out.printf("%d ",entry.getKey());
				}
			}
			System.out.printf("\n");
		}
	}
}