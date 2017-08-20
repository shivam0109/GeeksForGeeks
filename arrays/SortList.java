/*
Given an arraylist of arraylist of integers, sort it in ascending order. 
*/ 
import java.io.* ;
import java.util.* ;

public class SortList{
	public void sortList(ArrayList<ArrayList<Integer>> list){
		Collections.sort(list, new Comparator<ArrayList<Integer>>(){
			public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
				if(a1.get(1)==a2.get(0))
					return -1 ;
				return a1.get(1) - a2.get(0) ;
			}
		}) ;
	}
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>() ;
		ArrayList<Integer> a = new ArrayList<Integer>() ;
		ArrayList<Integer> b = new ArrayList<Integer>() ;
		ArrayList<Integer> c = new ArrayList<Integer>() ;
		ArrayList<Integer> d = new ArrayList<Integer>() ;
		a.add(3) ; 
		a.add(4) ; 
		b.add(0) ;
		b.add(1) ;
		c.add(-1) ;
		c.add(-2) ;
		d.add(2) ;
		d.add(3) ; 
		list.add(a) ;
		list.add(b) ;
		list.add(c) ;
		list.add(d) ;
 		System.out.println(list) ;
		SortList obj = new SortList() ;
		obj.sortList(list) ;
		System.out.println(list) ; 
	}
}