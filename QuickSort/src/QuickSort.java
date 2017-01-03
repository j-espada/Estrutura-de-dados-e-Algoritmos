
public class QuickSort {

	private void exchange(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public QuickSort(int[] A) {
		final int p = 0;
		int r = A.length - 1;
		run(A, p, r);
	}

	private void run(int[] A, int p, int r) {
		if(p < r) {
			int q = partition(A,p,r);
					run(A,p,q-1);
			run(A,q+1,r);
				
		}
	}

	private int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1 ;
		for(int j = p ; j <= r - 1 ; j++){
			if(A[j]<=x){
				i ++ ;
				exchange(A, i, j);
			}
		}
		exchange(A, i+1, r);
		return i+1;
	}
}
