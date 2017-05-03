//Using arraylist instead of array.
//No need to know the size

import java.util.* ;
import java.io.* ;

public class arraylist_example{
	public static void main(String[] args){
		//creating a list
		List<Integer> al = new ArrayList<Integer>();

		//add elements to arraylist
		int i;
		for(i=0;i<10;i++)
			al.add(i);

		//show size of arraylist
		System.out.println("Size of arraylist: " + al.size());

		//iterate through the arraylist
		System.out.println("Using for loop\n");
		for(i=0;i<al.size();i++)
			System.out.printf("%d ",al.get(i));

		System.out.printf("\n");

		System.out.println("Using iterator\n");
		Iterator<Integer> aliter =   al.iterator() ;
		while(aliter.hasNext())
			System.out.printf("%d ",aliter.next());

	}
}