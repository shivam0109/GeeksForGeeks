//Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those  in A2
//For the elements not present in A2. Append them at last in sorted order. It is also given that the number of elements in A2[] 
//are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements


//Using HashMap 
import java.io.* ;
import java.util.* ;

public class RelativeSorting{
	static void relativeSort(int a[], int b[], int alen, int blen){
		LinkedHashMap<Integer,Integer> hmap = new LinkedHashMap<Integer,Integer>();
		int i;
		for(i=0;i<alen;i++){
			if(hmap.containsKey(a[i]))
				hmap.put(a[i],hmap.get(a[i])+1) ;
			else 
				hmap.put(a[i],1) ; 
		}
		
		for(i=0;i<blen;i++){
			if(hmap.containsKey(b[i])){
				int count = hmap.get(b[i]) ;
				while(count>0){
					System.out.printf("%d ",b[i]) ;
					count-- ;
				}
				hmap.put(b[i],-1) ; 
			}
		}

		ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>() ;
		
		for(Map.Entry<Integer,Integer> entry : hmap.entrySet()) {
			if(entry.getValue() != -1)
				list.add(entry) ;
		}

		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
				return a.getKey().compareTo(b.getKey()) ;
			}
		}) ; 

		for(i=0;i<list.size();i++){
			Map.Entry<Integer,Integer> entry = list.get(i) ;
			int count = entry.getValue() ;
			while(count>0){
				System.out.printf("%d ",entry.getKey());
				count-- ;
			}
		}

		System.out.printf("\n") ;
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in) ;
		int ntest = scr.nextInt() ;
		int i,j;
		for(j=0;j<ntest;j++){
			int alen = scr.nextInt() ;
			int blen = scr.nextInt() ;
			int a[] = new int[alen] ;
			int b[] = new int[blen] ;

			for(i=0;i<alen;i++)
				a[i] = scr.nextInt();
			
			for(i=0;i<blen;i++)
				b[i] = scr.nextInt();

			relativeSort(a,b,alen,blen) ;
		}
	}
}