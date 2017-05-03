//Basic HashMap

import java.util.* ;
import java.io.* ;

public class hashmap{
	public static void main(String[] args){
		//create an empty hashmap
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

		//put keys and values in hashmap
		hmap.put(25,1);
		hmap.put(24,3);
		hmap.put(23,2);
		hmap.put(22,5);
		hmap.put(21,0);
		//Sorted by key values.
		
		//KeySet Method for HashMaps. Shows the keys in hashmap. 
		Set keyset = hmap.keySet();

		//Check KeySet values.
		System.out.println("Key Set Values are: " + keyset);

		//Construct an Iterator for HashMap. For Constructing an Iterator, we first need a keySet.
		Iterator<Integer> iter = keyset.iterator();

		//Iterating Over hashmap
		while(iter.hasNext()){
			int key = iter.next();
			System.out.println("Key: " + key +  " Value: " + hmap.get(key));
		}

		//Size of HashMap
		System.out.println(hmap.size());

		//ContainsKey and ContainsValue Example
		System.out.println("21 as Key: " + hmap.containsKey(21));
		System.out.println("21 as Value: " + hmap.containsValue(21));

		//Sort HashMap According to Values. 		
	}
}