//Find Cube Root of a given Numebr. 

//Use Binary Search. 


import java.io.* ;
import java.util.* ;

public class CubeRoot{
	static float bsearch(float n){
		float start = 0;
		float end = n;

		while(true){
			float mid = (start+end)/2 ;

			if(Math.abs(mid*mid*mid -n) < 0.0001)
				return mid;

			if(mid*mid*mid<n)
				start = mid;
			else
				end = mid ;
		}
	}

	public static void main(String[] args){
		Scanner scr = new Scanner(System.in);
		int ntest = scr.nextInt();
		int j ;
		for(j=0;j<ntest;j++){
			float n = scr.nextFloat() ;
			float left = (float)0 ;
			float ans = bsearch(n);
			System.out.println(ans);
		}
	}
}