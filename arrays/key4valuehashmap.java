//get key from a value in a hashmap

import java.io.*;
import java.util.*;

public class key4valuehashmap{
	public static void main(String[] args){
		Map<Integer, String> testMap = new HashMap<Integer, String>();
        testMap.put(10, "a");
        testMap.put(20, "b");
        testMap.put(30, "c");
        testMap.put(40, "d");
        for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
            if (entry.getValue().equals("c")) {
                System.out.println(entry.getKey());
            }
        }
	}
}