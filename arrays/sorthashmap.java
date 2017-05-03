//create a function to sort hashmap according to values.

import java.util.* ;
import java.io.* ;

public class sorthashmap{

	public static void main(String[] args){
		LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<Integer,Integer>();

		//populate 
		lhmap.put(25,1);
		lhmap.put(21,4);
		lhmap.put(22,5);
		lhmap.put(20,3);
		lhmap.put(10,4);
		lhmap.put(15,5);
		lhmap.put(12,10);

		//create set to iterate over
		Set set = lhmap.entrySet();
		System.out.println(set);

		//create iterator
		Iterator iter = set.iterator();

		while(iter.hasNext()){
			Map.Entry me = (Map.Entry)iter.next();
			System.out.print(me.getKey());
			System.out.println(" " + me.getValue());
		}

		//Sort Linkedhashmap
		//Step 1 : Create a list of Map.entries so that we can use Collections.sort(list, new comparator)
		List<Map.Entry<Integer,Integer>> listentry = new ArrayList<Map.Entry<Integer,Integer>>(lhmap.entrySet());

		//Step 2 : Use Collections.sort with a new comparator. 
		Collections.sort(listentry,new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
				return -a.getValue().compareTo(b.getValue());
			}
		} );

		//Loop and store result in a new map. 

		Map<Integer,Integer> sortedmap = new LinkedHashMap<Integer,Integer>();
		for(Map.Entry<Integer,Integer> entry : listentry){
			sortedmap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(sortedmap);
	}
}
