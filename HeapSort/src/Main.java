import java.util.Arrays;

public class Main {
	
	public static void main (String[]args){
		int [] C = {10,9,8,7,6,5,4,3,2,1,0};
		int []A = NewCopy(C);
	    HeapSort is = new HeapSort(A);
	    System.out.println(Arrays.toString(A));
	}
	
	public static  int [] NewCopy (int [] A) {
		int [] B = new int [A.length + 1];
		for(int k = 1 ; k < B.length ; k ++){
			B[k] = A[k-1];
		}
		B[0] = Integer.MIN_VALUE;
		return B;
	}
	
	
}
