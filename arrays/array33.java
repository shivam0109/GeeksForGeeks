//The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 
// {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. 
//Again buy on day 4 and sell on day 6

import java.io.* ;
import java.util.* ;

public class array33{
	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int k;
		for(k=0;k<ntest;k++){
			int n = scr.nextInt();
			int arr[] = new int[n];
			int i;
			for(i=0;i<n;i++)
				arr[i] = scr.nextInt();
			i = 0;
			LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<Integer,Integer>();
			lhmap.put(0,1);
			for(i=0;i<n-1;i++){
				if(arr[i+1]<arr[i]){
					if(lhmap.containsKey(i))
						lhmap.put(i,2);
					else
						lhmap.put(i,1);
					lhmap.put(i+1,1);
				}
			}
			if(lhmap.containsKey(n-1))
				lhmap.put(n-1,2);
			else
				lhmap.put(n-1,1);

			i = 0;
			int flag = 0;
			// for(Integer key : lhmap.keySet())
			// 	System.out.printf("%d %d ",key,lhmap.get(key));
			for(Integer key : lhmap.keySet()){
				if(lhmap.get(key)==1){
					flag = 1;
					if(i%2==0){
						System.out.print("(");		
						System.out.printf("%d ",key);
					}
					else{						
						System.out.printf("%d",key);
						System.out.print(") ");
					}
					i++;
				}
			}
			if(flag==0)
				System.out.print("No Profit");
			System.out.printf("\n");

		}
	}
}