import java.util.Arrays;

public class InsertionSort {

	public InsertionSort(int[] A) {
		
		run(A);
	}
	
	private void run (int[] A) {
		for(int j = 1 ; j < A.length  ; j++) {
			int key = A[j];
			int i = j - 1;
			while (i > -1 && A[i] > key) {
				A[i+1] = A[i];
				i = i -1 ;
			}
			A[i+1] = key ;
			System.out.println((j)+"th iteration result: "+Arrays.toString(A));
		}
	}
}
