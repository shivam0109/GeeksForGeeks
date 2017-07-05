//Given n Magnets which are placed linearly, with each magnet to be considered as of point object. 
//Each magnet suffers force from its left sided magnets such that they repel it to the right and vice versa. 
//All forces are repulsive. The force being equal to the distance (1/d , d being the distance). Now given the positions of the magnets, 
//the task to find all the points along the linear line where net force is ZERO.


import java.io.* ;
import java.util.* ;

public class MagnetArray{
	static double findForce(double x, double arr[], int index, int len){
		double leftForce = 0;
		double rightForce = 0;
		int i;
		for(i=0;i<len;i++){
			if(i<=index)
				leftForce += 1/(x-arr[i]) ; 
			else
				rightForce += 1/(arr[i]-x) ; 
		}
		return leftForce-rightForce ; 
	}

	static double bsearch(double arr[], double left, double right, int leftIndex, int len){
		double mid = (left+right)/2  ;
		double force = findForce(mid,arr,leftIndex,len) ; 
		if(Math.abs(force) < 0.00001)
			return mid ; 
		else if(force<0){
			right = mid ;
			return bsearch(arr,left,right,leftIndex,len) ;
		}
		else{
			left = mid ;
			return bsearch(arr,left,right,leftIndex,len) ;	
		}
 	}

 	static void findEqPoints(double[] arr, int len, ArrayList<Double> list){ 
 		int i;
 		double ans ; 
 		for(i=0;i<len-1;i++){
 			ans = bsearch(arr,arr[i]+0.01,arr[i+1]-0.01,i,len) ; 
 			list.add(Math.round(ans*100.0)/100.0) ; 
 		}
 	}

 	public static void main(String[] args){
 		Scanner scr = new Scanner(System.in) ; 
 		int ntest = scr.nextInt();
 		int i,j ;
 		for(j=0;j<ntest;j++){
 			int n = scr.nextInt() ;
 			double arr[] = new double[n] ;
 			for(i=0;i<n;i++)
 				arr[i] = scr.nextDouble() ;
			ArrayList<Double> list = new ArrayList<Double>() ;
			//Arrays.sort(arr) ; 
			findEqPoints(arr,n,list) ; 
			// System.out.println(list) ;
			for(i=0;i<list.size();i++)
				System.out.printf("%.2f ", list.get(i)) ;
			System.out.printf("\n") ;  			
 		}
 	}
}