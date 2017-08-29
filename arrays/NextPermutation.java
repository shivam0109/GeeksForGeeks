/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

*/

/*
First, we observe that for any given sequence that is in descending order, no next larger permutation is possible
We need to find the first pair of two successive numbers a[i] and a[i-1], from the right, which satisfy a[i] > a[i-1]. 
Now, no rearrangements to the right of a[i-1] can create a larger permutation since that subarray consists of numbers in descending order. 
Thus, we need to rearrange the numbers to the right of a[i-1] including itself.

Find the number just greater than a[i-1]. Swap these elements.
Now, the arrangement a[i]..a[n-1] is in descending order. Reverse this to get the answer.  
*/
import java.io.* ;
import java.util.* ;

public class NextPermutation{
	public void reverse(int arr[], int n, int left, int right){
        int temp ;
        while(left<right){
            temp = arr[left] ;
            arr[left] = arr[right] ;
            arr[right] = temp ;
            left++ ;
            right-- ;
        }
    }
    public int findIndex(int arr[], int n){
        int i ;
        for(i=n-1;i>=1;i--){
            if(arr[i-1]<arr[i])
                return i-1 ; 
        }
        return -1 ;
    }
    public int findJustGreater(int arr[], int index, int n){
        int min = Integer.MAX_VALUE ;
        int minIndex = index ;
        int i ;
        for(i=index+1;i<n;i++){
            if(arr[i]>arr[index] && arr[i]<=min){
                min = arr[i] ;
                minIndex = i ;
            }
        }
        return minIndex ;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length ;
        int i,j ;
        if(n==0)
            return ;
        int index = findIndex(nums,n) ;
        if(index==-1){
            reverse(nums,n,0,n-1) ;
            return ; 
        }
        int greaterIndex = findJustGreater(nums,index,n) ;
        //SWAP ELEMENTS 
        int temp = nums[index] ;
        nums[index] = nums[greaterIndex] ;
        nums[greaterIndex] = temp ;
        reverse(nums,n,index+1,n-1) ;
    }
    public static void main(String[] args){
    	Scanner scr = new Scanner(System.in) ;
    	int ntest = scr.nextInt() ;
    	while(ntest-->0){
    		int n = scr.nextInt() ;
    		int arr[] = new int[n] ;
    		int i;
    		for(i=0;i<n;i++)
    			arr[i] = scr.nextInt() ;
    		NextPermutation np = new NextPermutation() ;
    		np.nextPermutation(arr) ;
    		for(i=0;i<n;i++)
    			System.out.printf("%d ",arr[i]) ;
    		System.out.printf("\n") ; 
    	}
    }
}